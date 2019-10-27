package com.fox.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author dmb
 * @since 2019/8/28
 */
public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {

    public RmiServiceImpl() throws RemoteException {
    }

    @Override
    public String hello() {
        System.out.println("hello.");
        return "a";
    }
}
