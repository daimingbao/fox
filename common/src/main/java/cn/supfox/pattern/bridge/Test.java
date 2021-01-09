package cn.supfox.pattern.bridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        /**
         * JDBC规定了这些步骤，但是没有具体实现。<br>
         * 这些具体实现跟抽象步骤怎么衔接起来呢？通过DriverManager来桥接<br/>
         */
        try {
            //1.加载驱动  ---> 建立桥
            Class.forName("com.mysql.jdbc.Driver");  //反射机制加载驱动类，执行静态块代码，调用Driver的构造方法<br>
            // 2.获取连接Connection
            //主机:端口号/数据库名  --> 前面建立桥了 这里就用
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.8.71:3306/ds0", "root", "123456");
            // 3.得到执行sql语句的对象Statement
            Statement stmt = conn.createStatement();
            // 4.执行sql语句，并返回结果
            ResultSet rs = stmt.executeQuery("select *from table");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
