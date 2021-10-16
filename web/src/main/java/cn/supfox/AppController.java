package cn.supfox;

import cn.supfox.core.db.User;
import cn.supfox.core.service.BookUseService;
import cn.supfox.core.service.UserService;
import cn.supfox.request.WechatEnpointRequest;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.common.IOUtils;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

@Scope(scopeName = "prototype")
@RestController
public class AppController {

    private Logger log = LoggerFactory.getLogger("FOX-WEB");

    @Resource
    private BookUseService bookUseService;

    @Value("${fox.book.list.path}")
    private String bookListPath;

    @Value(("${fox.book.list.access.url}"))
    private String bookListUrl;

    @Value(("${fox.we.chat.enpoint.token}"))
    private String wechatEnpointToken;

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private UserService userService;

    @GetMapping("/rest/test")
    public String test(@RequestParam(name = "name") String name) {

        redissonClient.getFairLock("dmb").lock(10, TimeUnit.MINUTES);
        redissonClient.getFairLock("dmb").lock(10, TimeUnit.MINUTES);
        redissonClient.getFairLock("dmb").unlock();

        return "ok receive message ===> " + name;
    }

    @GetMapping("/redisson")
    public WechatEnpointRequest testRedisson(@RequestParam(name = "name") String name, @RequestBody WechatEnpointRequest request) {

        userService.register(new User());
        redissonClient.getBucket("test").set("dmb");
        Object test = redissonClient.getBucket("test").get();
        request.setEchostr(test.toString());
        return request;
    }

    @EventListener
    public void listener(ServletRequestHandledEvent servletRequestHandledEvent) {
        System.out.println("监听到事件{}"+ JSON.toJSONString(servletRequestHandledEvent));
    }

    /**
     * 1）将token、timestamp、nonce三个参数进行字典序排序
     * 2）将三个参数字符串拼接成一个字符串进行sha1加密
     * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     *
     * @param request
     * @param enpointRequest
     * @return
     */
    @GetMapping("/auth")
    public String wechatEnpoint(HttpServletRequest request, WechatEnpointRequest enpointRequest) {
        Long timestamp = enpointRequest.getTimestamp();
        Integer nonce = enpointRequest.getNonce();
        List<? extends Serializable> paramList = Arrays.asList(timestamp.toString(), wechatEnpointToken, nonce.toString());
        paramList.sort(org.springframework.util.comparator.Comparators.comparable());
        String digest = DigestUtils.sha1DigestAsHex(StringUtils.join(paramList.toArray()));
        System.out.println("请求参数：" + enpointRequest);
        System.out.println("参数加密后：" + digest);
        //若确认此次GET请求来自微信服务器，请原样返回echostr参数内容
        return digest.equalsIgnoreCase(enpointRequest.getSignature()) ? enpointRequest.getEchostr() : "";
    }

    /**
     * 书籍上传
     *
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public String upload(MultipartHttpServletRequest request) {

        Map<String, MultipartFile> fileMap = request.getFileMap();
        fileMap.forEach((bookName, multipartFile) -> {
            File bookFile = new File(bookListPath + File.separator + bookName);
            try {
                FileCopyUtils.copy(multipartFile.getBytes(), bookFile);
            } catch (IOException e) {
                e.printStackTrace();
                log.error("上传书籍{}失败", bookName, e);
                throw new RuntimeException("上传书籍" + bookName + "失败, 请稍后再试！");
            }
        });
        return "OK";
    }

//    @GetMapping("/")
//    public String index() {
//        return "hello world";
//    }

    @GetMapping("/books")
    public String bookList() {
        File file = new File(bookListPath);
        StringBuilder sb = new StringBuilder();
        LongAdder longAdder = new LongAdder();
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();

            for (File bookFile : files) {
                longAdder.add(1);
                String bookFileName = bookFile.getName();
                sb.append(longAdder.intValue() + ":  <a href=" + ( "download" + File.separator + bookFileName) + " > " + bookFileName + " </a>");
                sb.append("</br>");
            }
        }
        return sb.toString();
    }

    @GetMapping("/download/{bookName}")
    public void download(HttpServletResponse response, HttpServletRequest request, @PathVariable(name = "bookName") String bookName) {
        File book = new File(bookListPath + File.separator + bookName);

        try (ServletOutputStream outputStream = response.getOutputStream()) {
            IOUtils.copyBytes(new FileInputStream(book), outputStream, 2048);
            //记录书籍使用记录
            String remoteIp = request.getHeader("remote_ip");
            String remoteHost = request.getRemoteHost();
            String remoteAddr = request.getRemoteAddr();
            int remotePort = request.getRemotePort();
            log.info(remoteAddr);
            log.info(remoteHost);
            log.info(remoteIp);
            remoteIp = StringUtils.isBlank(remoteIp) ? (StringUtils.isBlank(remoteAddr) ? (remoteHost+remotePort) : "localhost") : remoteIp;

            bookUseService.useBook(bookName, remoteIp);
        } catch (IOException e) {
            log.error("下载书籍失败", e);
        }
    }
}
