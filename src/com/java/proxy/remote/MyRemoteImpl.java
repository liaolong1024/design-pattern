package com.java.proxy.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 继承UnicastRemoteObject使得MyRemoteImpl具备远程功能
 *
 * @author ll
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    @Override
    public String sayHello() throws RemoteException {
        return "Server says: 'Hey'";
    }

    public MyRemoteImpl() throws RemoteException {
        super();
    }

    /**
     * 注册服务,放到RMI registry中, 注册的是stub, 供客户对象查找服务
     * @param args
     */
    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();

            // 方式1
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteHello", service);

            // 方式2
            // Naming.rebind("RemoteHello", service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
