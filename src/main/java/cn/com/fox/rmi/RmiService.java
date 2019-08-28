package cn.com.fox.rmi;

import java.rmi.Remote;

/**
 * @author dmb
 * @since 2019/8/28
 */
public interface RmiService extends Remote {

    String hello();
}
