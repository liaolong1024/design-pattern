# 责任链模式

## 优点
* 将请求发送者和接受者解耦
* 增强系统的可扩展性
* 工作流程发生变化，可以动态改变链内的成员或者调动它们的次序
* 责任分担，每个类只需要处理自己责任内的工作，符合类的单一职责原则

## 缺点
* 对比较长的职责链，请求处理可能涉及多个对象，系统性能将受到一定影响
* 职责链建立的合理性要靠客户端来保证，增加了客户端的复杂性

## Spring Security中责任链模式
### FilterChainProxy
主要是由其内部类VirtualFilterChain来体现责任链
```java
public class FilterChainProxy extends GenericFilterBean {
    private static final class VirtualFilterChain implements FilterChain {
    
        private final FilterChain originalChain;

        private final List<Filter> additionalFilters;

        private final FirewalledRequest firewalledRequest;

        private final int size;

        private int currentPosition = 0;

        private VirtualFilterChain(FirewalledRequest firewalledRequest, FilterChain chain,
                List<Filter> additionalFilters) {
            this.originalChain = chain;
            this.additionalFilters = additionalFilters;
            this.size = additionalFilters.size();
            this.firewalledRequest = firewalledRequest;
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
            if (this.currentPosition == this.size) {
                if (logger.isDebugEnabled()) {
                    logger.debug(LogMessage.of(() -> "Secured " + requestLine(this.firewalledRequest)));
                }
                // Deactivate path stripping as we exit the security filter chain
                this.firewalledRequest.reset();
                this.originalChain.doFilter(request, response);
                return;
            }
            this.currentPosition++;
            Filter nextFilter = this.additionalFilters.get(this.currentPosition - 1);
            if (logger.isTraceEnabled()) {
                logger.trace(LogMessage.format("Invoking %s (%d/%d)", nextFilter.getClass().getSimpleName(),
                        this.currentPosition, this.size));
            }
            nextFilter.doFilter(request, response, this);
        }

    }
}
```
1. VirtualFilterChain 类中首先声明了 5 个全局属性，originalChain 表示原生的过滤器链，也就是 Web Filter；additionalFilters 表示 Spring Security 中的过滤器链；firewalledRequest 表示当前请求；size 表示过滤器链中过滤器的个数；currentPosition 则是过滤器链遍历时候的下标。
2. doFilter 方法就是 Spring Security 中过滤器挨个执行的过程，如果 currentPosition == size，表示过滤器链已经执行完毕，此时通过调用 originalChain.doFilter 进入到原生过滤链方法中，同时也退出了 Spring Security 过滤器链。否则就从 additionalFilters 取出 Spring Security 过滤器链中的一个个过滤器，挨个调用 doFilter 方法。nextFilter.doFilter 就是过滤器链挨个往下走。
#### 过滤器的顺序
org.springframework.security.config.annotation.web.builders.FilterOrderRegistration

## 参考
* [盘点 Spring Security 框架中的八大经典设计模式](http://www.javaboy.org/2020/0730/springsecurity-pattern.html)