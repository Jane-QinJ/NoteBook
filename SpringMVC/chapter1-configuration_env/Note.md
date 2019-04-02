### Spring第一章
- 两个配置文件
1. web.xml

2. servletName-servlet.xml (Web-INF下)

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

### Spring第四章 数据绑定和表单标签库
编程大题
程序题：	
           某手机管理系统，包含三个请求：/goods/input, /goods/save,  /goods/list,分别用于打开表单，添加手机，查询多条手机信息。   表单包含 “手机名称”、“手机价格”、“库存数量”三个文本框。
(1)编写addproduct.jsp的表单部分
(2)编写控制类，实现三个请求的处理方法。
       添加手机时，控制类调用goodsService.add(实体对象)，返回true,添加成功，重定向发出/list请求。否则，返回表单页面。
(3)编写productlist.jsp的表格输出部分

### Spring第九章
EL和JSTL
-[ ] 试用<c:forEach>实现九九乘法表（两个嵌套循环）
### Issues
**Q**:
- 页面跳转时地址栏请求出现重复
eg: http://localhost:8081/springphone/goods/goods/save

**S**:
在jsp页面中加上basePath
[reference](https://5aijava.iteye.com/blog/221412)

**这说明在该页面中的所有路径都是于项目的WebRoot为相对路径**

Html代码  JSP页面中加上
```
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
```

Html代码 
```
<base href="<%=basePath%>">  
```

