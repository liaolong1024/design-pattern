# 模板方法设计模式
## 定义
> 在一个方法中定义一个算法的骨架，而将某些步骤延迟到子类中实现。即子类在不改变既有步骤的前提下，重新定义算法中的某些步骤

## 哪个方法是模板方法？
```java
public abstract class Drink {
    final void prepareRecipe() {
        boilWater();
        dealWithWater();
        pourInCup();
        addRecipe();
    }
}
```

## 模板方法的作用是什么
> 模板方法定义了一个算法的步骤，并允许子类为一个或多个步骤提供实现

## 对模板方法挂钩
[带有钩子的模板方法抽象类](./hook/DrinkWithHook.java)

## Tips
* 子类必须提供算法中的某个步骤方法的实现时，该方法就声明为抽象方法
* 钩子的作用
    * 子类可以选择是否执行算法中可选的步骤方法
    * 子类可以选择在某个步骤方法执行前或之后利用钩子做些事情
* 算法的步骤不能切割得太细，这样可能会导致子类需要实现的方法会比较多；也不能太少，这样的设计比较没有弹性

## 模板方法优缺点
优点
* 在父类中提取了公共部分的代码，便于代码复用和扩展
* 部分方法是由子类实现的，子类可以通过扩展方式增加相应的功能，符合开闭原则

缺点
* 每个不同的实现都需要定义一个子类，导致类的个数增加，系统变复杂不易理解
* 父类中的抽象方法由子类实现，子类执行结果会影响父类的结果，增加代码理解难度

## Java API中的模板方法设计模式
### java.util.Arrays
`Arrays.sort`所调用的排序算法涉及到多个算法步骤，为了使得`sort`方法能够适配各种类型的数据对象的排序，将算法步骤中"比较大小"的步骤交由对象自行实现，即实现`Comparable`接口的`compareTo`方法

### java.io.InputStream
该抽象类的`read(byte b[], int off, int len)`就是一个模板方法，该方法中调用了一个`read()`方法，该`read()`由其子类提供具体实现

## Spring Security中的模板方法设计模式
### AbstractUserDetailsAuthenticationProvider
该类中的模板方法是`authenticate`
```
public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    // 其他步骤...
    user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
    // 其他步骤...
    additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
} 
```
上面调用的两个方法是是抽象方法，需要子类实现
```
// 子类实现该方法，自定义用户认证校验逻辑，如验证码，用户是否过期等
protected abstract void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException;

// 子类实现该方法，定义查找用户数据的逻辑，比如指定从数据库中获取用户信息
protected abstract UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException;
```
AbstractUserDetailsAuthenticationProvider中也有其他方法供子类选择性实现，如`createSuccessAuthentication`

如果你的数据源来自其他地方，或者登录凭证不是密码，那么自定义类继承自 AbstractUserDetailsAuthenticationProvider 并重写它里边的这两个方法即可


## 参考
* 《Head First 设计模式》
* [盘点 Spring Security 框架中的八大经典设计模式](http://www.javaboy.org/2020/0730/springsecurity-pattern.html)

