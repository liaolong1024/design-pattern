package com.java.proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author LiaoLong
 * @create 2023-04-02 19:28
 */
public interface MyRemote extends Remote {

    /*
       变量和返回值属于primitive类型或者可序列化类型
     */
    public String sayHello() throws RemoteException;
}
