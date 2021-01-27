### 本工程是自己从网上查看资料,在本地做的测试,资源来源于互联网

## 在初始化情况下的注册Servlet组件有两种方法：
1. 实现ServletContextListener接口,在contextInitialized方法中完成注册.
2. 在jar文件中放入实现ServletContainerInitializer接口的初始化器



## ServletContainerInitializer

在Servlet 3.0环境中， 容器会在类路径中查找实现
javax.servlet.ServletContainerInitializer接口的类，

如果能发现的话， 就会用它来配置Servlet容器。


Spring提供了这个接口的实现， 名为SpringServletContainerInitializer， 这个类反过来又会查找实现WebApplicationInitializer的类并将配置的任务交给它们来完成。


Spring 3.2引入了一个便利的WebApplicationInitializer基础实现， 也就是AbstractAnnotationConfigDispatcherServletInitializer

因为我们的Spittr-WebAppInitializer扩展了AbstractAnnotationConfigDispatcherServletInitializer（同时也就实现了WebApplicationInitializer） ， 因此当部署到Servlet 3.0容器中的时候， 容器会自动发现它， 并用它来配置Servlet上下文。

ServletContainerInitializer--------->SpringServletContainerInitializer--->WebApplicationInitializer-->AbstractAnnotationConfigDispatcherServletInitializer





