package cn.supfox.webservices;



import com.alibaba.fastjson.JSON;
import com.gooben.yxt.service.api.ws.v1.*;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CXFTest {

    public static void main(String[] args) throws GeneralSecurityException, UnsupportedEncodingException, ParseException, MalformedURLException {

        long l = System.currentTimeMillis();

//        String userCode = "sxswxb";
//        String password = "sxswxb@2021";
        String userCode = "Lswxb-2021";
        String password = "Lswxb@20210108";


        String timestamp = String.valueOf(l).substring(0,8);
        String userName = DESHelper.encryptDES(userCode.getBytes(StandardCharsets.UTF_8), timestamp);
//        String s = DESHelper.decryptDES(result.getBytes(), timestamp);
//        System.out.println(s);
        System.out.println(userName);


        String p1 = DESHelper.MD5Encode(password, "UTF-8");
        String p2 = DESHelper.MD5Encode(userCode + p1, "UTF-8");
        String p3 = DESHelper.MD5Encode(p2 + String.valueOf(l), "UTF-8");



        com.gooben.yxt.service.api.ws.v1.impl.WsItfTask wsItfTaskImpl = new com.gooben.yxt.service.api.ws.v1.impl.WsItfTask(new URL("http://115.239.137.23:9501/ws/v1?wsdl"));
        com.gooben.yxt.service.api.ws.v1.WsItfTask wsItfTaskImplPort = wsItfTaskImpl.getWsItfTaskImplPort();
        com.gooben.yxt.service.api.ws.v1.InterfaceResult authorization = wsItfTaskImplPort.authorization(userName, p3, l);
        System.out.println(authorization.getCode());
        System.out.println(authorization.getMessage());
        Object result = authorization.getResult();
        com.gooben.yxt.service.api.ws.v1.TokenObj tokenObj =  (com.gooben.yxt.service.api.ws.v1.TokenObj) result;
        System.out.println(JSON.toJSONString(tokenObj));
//        000000
//        调用成功
        /**
         * {"expireTime":"2021-04-12 16:11:37","serverTime":"2021-04-12 16:01:37","token":"GnDX/pvyeJXhCTYJQ+1V/0PGGOSphzGmr2ZdnaBrf1EfQBExodEup8ufKE0t4NAWPozskKseLIqe05NsgySVw+C7Sbp5ZStrsdLtfQXAWSI=.c934ca88e1542b0edaa8c7ad2a67e894"}
         */
        /**
         * {"expireTime":"2021-04-12 17:09:14","serverTime":"2021-04-12 16:59:14","token":"GnDX/pvyeJXhCTYJQ+1V/9Rwgy931VanOl959LBpWvEfQBExodEup8ufKE0t4NAWPozskKseLIqe05NsgySVw+C7Sbp5ZStrsdLtfQXAWSI=.d45d3e2e62b530468a9329723d28d72b"}
         */

        //发送短信
        String token = tokenObj.getToken();
        System.out.println(token);

        /**
         * 获取音信通token结果{"code":"000000","message":"调用成功","result":{"expireTime":"2021-04-16 10:24:16","serverTime":"2021-04-16 10:14:16","token":"GnDX/pvyeJXhCTYJQ+1V/0itPGWUPtjGvxSQU1u182kfQBExodEupxhE/v+gFSC18xnthyEYxcee05NsgySVw+C7Sbp5ZStrsdLtfQXAWSI=.4dd573c402b259a79b3de5882033c900"}}
         * 2021-04-16 10:14:16 |-INFO  [http-nio-8443-exec-2] com.dbappsecurity.nssa.component.push.yinxintong.impl.YxtServiceImpl:69 -| 音信通发送短信结果:{"return":{"code":"000000","message":"调用成功","result":"a9b76f87802746f9a0f1489050e16811"}}
         */
//        String token = "GnDX/pvyeJXhCTYJQ+1V/9fNucdNvjSFXO67o74R2YgfQBExodEupxhE/v+gFSC18xnthyEYxcee05NsgySVw+C7Sbp5ZStrsdLtfQXAWSI=.82cd5f9623760eaa0a80c4453c4f8ea5";
        SubmitTask parameters = new SubmitTask();
        ItfOptions options = new ItfOptions();
        ItfSmsOption smsopt = new ItfSmsOption();
        smsopt.setHasSms(true);
//        smsopt.setContent("【安恒信息】测试短信，请忽略");
//        smsopt.setRouteName("测试信息");
        options.setItfSmsOption(smsopt);
        parameters.setItfOptions(options);
        ItfSendDetail detail1 = new ItfSendDetail();
        detail1.setContent("【丽水市网信办】通报预警提示：您好，丽水市网络安全协调指挥平台有通报信息需要您及时审核，详细内容请登录平台查看。如有疑问请咨询85113989");
        detail1.setReceiveNumber("15675480942");
        List<ItfSendDetail> details1 = parameters.getDetails();
        details1.add(detail1);
        SubmitTaskResponse submitTaskResponse = wsItfTaskImplPort.submitTask(parameters, token);
        System.out.println(JSON.toJSONString(submitTaskResponse));

        GetSubmitResult parameter = new GetSubmitResult();
//        parameter.setSubmitKey("96058605f00b4b368b8571fe8d70524e1");
        parameter.setSubmitKey(submitTaskResponse.getReturn().getResult().toString());
        GetSubmitResultResponse submitResult = wsItfTaskImplPort.getSubmitResult(parameter, token);
        System.out.println(JSON.toJSONString(submitResult));

//        System.out.println(JSON.toJSONString(tokenObj));
//        System.out.println(JSON.toJSONString(submitTaskResponse));

    }

    /**
     * 加密
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     */
    public static  byte[] encrypt(byte[] datasource, String password) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }
}
