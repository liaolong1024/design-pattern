package com.java.proxy.remote.client;

import com.java.proxy.remote.MyRemote;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author ll
 */
public class MyClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        // Remote lookup = Naming.lookup("rmi://127.0.0.1/RemoteHello");
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        MyRemote myRemote = (MyRemote) registry.lookup("RemoteHello");
        System.out.println(myRemote.sayHello());
    }
}
