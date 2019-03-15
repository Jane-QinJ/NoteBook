### Spring第一章
- 两个配置文件
1. web.xml

2. servletName-servlet.xml

- 请求控制类
控制类实现Controller接口
返回ModelAndView

- 视图
JSP页面，可配置视图解析
返回的ModelAndView指定视图名称

- 流程
1. web.xml部署DispatcherServlet，处理所有请求
2. DispathcerServlet通过servletName-servlet.xml配置文件将请求分发给具体的Controller
3. Controller接口处理用户请求，返回ModelAndView
4. 返回视图

### Spring第二章
web.xml不用改变
第一章：哪个请求交给哪个类
第二章：哪个请求交给哪个类的那个函数


### Issues
-[ ] 创建工程时用的jdk10 之后改为1.8 是否可以简单的只改变编译环境 而不用重新创建项目