package cn.com.fox.rmi;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author dmb
 * @since 2019/8/28
 */
public interface RmiService extends Remote , Serializable {

    String hello() throws RemoteException;
}
