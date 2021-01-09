package cn.supfox.pattern.decorator.logger;

import org.slf4j.Logger;

import java.io.*;

/**
 * Created by Tom.
 */
public class Test {
//    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    private static final Logger logger = JsonLoggerFactory.getLogger(Test.class);

    @org.junit.Test
    public  void testLogger()
    {
        System.out.println("开始打印日志");
        logger.error("系统错误");
        System.out.println("结束打印日志");
    }

    @org.junit.Test
    public  void test2()
    {
        try {
            InputStream in = new FileInputStream("Test.class");

            BufferedInputStream bis = new BufferedInputStream(in);

            bis.read();
            bis.close();

            BufferedReader br = new BufferedReader(new FileReader(""));
            br.readLine();

            BufferedReader bs = new BufferedReader(new StringReader(""));
            bs.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
