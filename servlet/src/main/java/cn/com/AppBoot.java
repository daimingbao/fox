package cn.com;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class AppBoot {

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();

        //2.构建Connector对象(连接器),负责协议配置,端口配置等
        Connector conn=new Connector("HTTP/1.1");
        conn.setPort(8080);
        Service service = tomcat.getService();
        service.addConnector(conn);
        tomcat.addContext("/app","/");
        tomcat.addServlet("/app","appServlet", new AppServlet());
        //3.启动tomcat
        tomcat.start();
        //4.阻塞当前线程
        tomcat.getServer().await();
    }
}
