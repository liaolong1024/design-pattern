# 代理模式
## 定义
> 为一个对象提供一个替身或者占位符以控制对这个对象的访问

## 术语
* Stub: 客户辅助对象
* Skeleton: 服务辅助对象

## 制作远程服务
### 1. 定义远程接口MyService
> 远程接口定义出可以让客户远程调用的方法, 客户将用他作为服务的类类型, Stub和实际的服务都实现此接口
```java
public interface MyRemote extends Remote {

    /*
       变量和返回值属于primitive类型或者可序列化类型
     */
    public String sayHello() throws RemoteException;
}

```
### 2. 制作远程的实现MyServiceImpl
> 实现步骤一中定义的接口, 即被代理的对象
```java
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
```

### 3. 利用rmic产生stub和skeleton
注意参数是远程实现类, 不是实现接口
```bash
rmic MyServiceImpl
```

### 4. 启动RMI registry
客户可以从中查到stub helper对象(代理的位置)
```bash
rmiregistry
```

### 5. 开始远程服务
将服务注册到rmi registry
```bash
java MyServiceImpl
```

### 6. 客户端
```java
public class MyClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        // Remote lookup = Naming.lookup("rmi://127.0.0.1/RemoteHello");
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        MyRemote myRemote = (MyRemote) registry.lookup("RemoteHello");
        System.out.println(myRemote.sayHello());
    }
}
```
