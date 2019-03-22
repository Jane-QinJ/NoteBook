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

重新梳理知识点：
ch1: 第一个Sring应用 使用原始配置Controller (一个Controller一个bean)
ch2:使用基于注解的控制器
- @Controller和@RequestMapping
ch222: 接收参数的常见方式
1. 使用实体bean
2. 通过处理方法形参（和bean）属性相同

重定向和转发：
forward: 转发不改变地址栏
redirect: 重定向改变地址栏
return: 默认转发
### Issues
-[ ] 创建工程时用的jdk10 之后改为1.8 是否可以简单的只改变编译环境 而不用重新创建项目

### Spring第三章
Converter & Formatter
用于类型转换
