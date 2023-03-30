# 单例模式
> 确保一个类只有一个实例，并提供一个全局访问点

## 哪些地方可能需要使用单例
* 线程池
* 缓存
* 对话框
* 日志对象

## 注意
* 如果系统中有多个类加载器，单例模式就会被打破，因为不同的类加载器可以可能都加载了我们定义的单例，这个时候"单例"就不止一个了
```java
private static Class getClass(String classname) throws ClassNotFoundException {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    if(classLoader == null) 
        classLoader = Singleton.class.getClassLoader();
      return (classLoader.loadClass(classname));
}
```