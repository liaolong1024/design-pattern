# 观察者模式
## 定义
> 定义了对象之间的一对多依赖，这样一来， 当一个对象改变状态时， 它的所有依赖都会收到通知并自动更新

## 优点
降低了主题和观察者之间的耦合关系

## 缺点
* 目标与观察者之间的依赖关系并没有完全解除，而且可能出现循环引用
* 当观察对等很多时，程序执行效率降低

# Spring中的观察者模式
## 几个接口
* ApplicationEvent
* ApplicationListener
* ApplicationEventPublisher

我们知道Spring的一个核心接口ApplicationContext，它继承于ApplicationEventPublisher接口，部分定义如下
```java
public interface ApplicationContext extends ApplicationEventPublisher {
    // ...
}
```
ApplicationEventPublisher接口定义如下，声明了发布事件的方法
```java
@FunctionalInterface
public interface ApplicationEventPublisher {
    default void publishEvent(ApplicationEvent event) {
        this.publishEvent((Object)event);
    }

    void publishEvent(Object event);
}
```
自然的，ApplicationContext接口的实现类需要实现ApplicationEventPublisher接口，比如和Servlet Web相关的`ServletWebServerApplicationContext`, 我们先看`ServletWebServerApplicationContext`的抽象父类`AbstractApplicationContext`

```
// AbstractApplicationContext中的部分定义
// 事件发布广播器，功能：1. 可以注册观察者 2. 可以删除观察者 3. 可以通知观察者（广播事件）
private ApplicationEventMulticaster applicationEventMulticaster;
// 事件观察者
private final Set<ApplicationListener<?>> applicationListeners = new LinkedHashSet<>();
private Set<ApplicationListener<?>> earlyApplicationListeners;
// 提前发布的事件(即观察者关注的事件)
private Set<ApplicationEvent> earlyApplicationEvents;
```

`AbstractApplicationContext`中的在容器启动时的一个核心方法`refresh`方法， 调用了一下两个方法
```java
// 初始化事件广播器
initApplicationEventMulticaster();

// 注册观察者
registerListeners();
```

initApplicationEventMulticaster方法就是给applicationEventMulticaster赋值
* 如果容器中有applicationEventMulticaster的bean,则从容器中获取
* 如果容器中没有，创建`SimpleApplicationEventMulticaster`,并注册到容器中

registerListeners方法
1. 遍历将通过编码方式创建的事件监听器(观察者)加入到事件广播器中
2. 注册容器中实现了ApplicationListener接口的观察者Bean
3. 获取需要提前发布的时间，并广播出去（通知观察者）

发布事件时，实现ApplicationEventPublisher接口的publishEvent方法来发布相应事件，借由applicationEventMulticaster来通知观察者listener

# Spring Security中的观察者模式

