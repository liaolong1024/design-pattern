# 策略设计模式
> 找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起

鸭子的行为可能各不相同（这就是可能需要变化的部分），如果让所有鸭子都实现一个行为接口，让行为各自不同，这是针对实现编程，依赖于实现，代码不能复用

> 针对接口编程，而不是针对实现编程

这里的接口是广义的接口，即包含接口和抽象类，现在我们还是需要一个行为接口，但是不由鸭子子类来实现该接口，而是编写一个实现了该行为接口的类，将这个行为类和鸭子类组合起来，利用多态，这样鸭子的行为就可以灵活多变，自由组合，代码也可以复用了

> 多用组合，少用继承

##  定义
> 定义了算法蔟，分别封装起来，让他们之间可以互相替换，此模式让算法的变化独立于使用算法的客户

## 优点
* 提供了对开闭原则的完美支持，可以在不改变原有系统的基础上选择具体的策略，也可以灵活地扩展新的策略
* 提供了管理相关的策略的方式
* 提供了可以替换继承关系的办法（组合）
* 可以避免使用多重条件转移语句


## 缺点
* 客户端必须直到所有的策略类，并自行决定使用哪一个策略类
* 策略模式会产生很多策略类（可以通过使用享元模式在一定程度上减少对象的数量）

## Spring Security中的策略模式
### 用户登录信息存储策略
用户存储策略接口
```java
public interface SecurityContextHolderStrategy {
	void clearContext();
	SecurityContext getContext();
    void setContext(SecurityContext context);
	SecurityContext createEmptyContext();
}
```
其中一个以ThreadLocal方式存储用户登录信息的策略
```java
final class ThreadLocalSecurityContextHolderStrategy implements SecurityContextHolderStrategy {

	private static final ThreadLocal<SecurityContext> contextHolder = new ThreadLocal<>();

	@Override
	public void clearContext() {
		contextHolder.remove();
	}

	@Override
	public SecurityContext getContext() {
		SecurityContext ctx = contextHolder.get();
		if (ctx == null) {
			ctx = createEmptyContext();
			contextHolder.set(ctx);
		}
		return ctx;
	}

	@Override
	public void setContext(SecurityContext context) {
		Assert.notNull(context, "Only non-null SecurityContext instances are permitted");
		contextHolder.set(context);
	}

	@Override
	public SecurityContext createEmptyContext() {
		return new SecurityContextImpl();
	}

}
```
用户信息存储容器类与存储策略类以组合方式协同工作
```java
public class SecurityContextHolder {

    private static SecurityContextHolderStrategy strategy;
    
    // clearContext具体执行委托给strategy        
    public static void clearContext() {
        strategy.clearContext();
    }                            
}
```

### Session并发管理
session策略接口
```java
public interface SessionAuthenticationStrategy {

	void onAuthentication(Authentication authentication, HttpServletRequest request, HttpServletResponse response)
			throws SessionAuthenticationException;

}
```

AbstractAuthenticationProcessingFilter与session策略组合
```java
public abstract class AbstractAuthenticationProcessingFilter extends GenericFilterBean
		implements ApplicationEventPublisherAware, MessageSourceAware {
    private SessionAuthenticationStrategy sessionStrategy = new NullAuthenticatedSessionStrategy();
    
    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)

    			throws IOException, ServletException {
        // 委托执行逻辑给session strategy
        this.sessionStrategy.onAuthentication(authenticationResult, request, response);

    }
    
    public void setSessionAuthenticationStrategy(SessionAuthenticationStrategy sessionStrategy) {
    		this.sessionStrategy = sessionStrategy;
    }

}
```


## 参考
* 《Head First 设计模式》
* [盘点 Spring Security 框架中的八大经典设计模式](http://www.javaboy.org/2020/0730/springsecurity-pattern.html)
