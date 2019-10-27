package com.fox.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author dmb
 * @since 2019/8/28
 */
public class RmiServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        RmiService rmiService = new RmiServiceImpl();
        LocateRegistry.createRegistry(9999);
        // 如果配置在远程服务器，把地址换成你的ip
//        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        Naming.bind("rmi://127.0.0.1:9999/hello", rmiService);
        System.out.println(">>>>>INFO:远程IHello对象绑定成功！");
    }
}
