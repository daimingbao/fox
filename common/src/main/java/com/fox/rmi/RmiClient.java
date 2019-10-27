package com.fox.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author dmb
 * @since 2019/8/28
 */
public class RmiClient {
    public static void main(String args[]) {
        try {
            // 填写服务器ip
            RmiService rmiService = (RmiService) Naming.lookup("rmi://127.0.0.1:9999/hello");
            rmiService.hello();
        } catch (NotBoundException e) {
        } catch (MalformedURLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
