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

**Q**:
java.lang.ClassNotFoundException: com.mysql.jdbc.Driver 
**S**:
在web项目中，当Class.forName("om.mysql.jdbc.Driver");时myeclipse是不会去查找字符串，不会去查找驱动的。所以只需要把mysql-connector-java-5.1.7-bin.jar拷贝到tomcat下lib目录就可以了
[solve](https://www.cnblogs.com/swxj/archive/2013/06/05/3119206.html)

### Spring第十章
**Q**
javax.el.PropertyNotFoundException: Property [id] not found on type [java.lang.String]

**S**
在jstl标签属性中的""中间不能有空格
[solve](https://www.cnblogs.com/xiangkejin/p/5800521.html)

**【Thought】**:
1. 找到想用的构件，之后搜索配置生效方法
- 网上有许多可用资源， 但前提是知道自己需要什么， 这需要掌握基本的知识，知道框架原理，才可以随心取用构件。
要往深学， 学那些有共同点的知识，平时要在知识中寻找串联点，这样才能一通百通，举一反三。

2. springMVC 将所有的请求都交给了spring，经由controller处理后，返回处理结果，之间经由各种逻辑处理。


WebShop Spring实现
把Cart当成Service
增删改查

参考名片管理系统

从表单，表格角度考虑

- 页面间传递的数据
1. 表单穿给表格
2. 表格中的链接， 到另一个表格

注册， 登录

角色
-  


### Spring增删改查

*公共函数（为多选框赋值）*：
```
@Controller
@RequestMapping("/user")
public class UerController {
	
	@Autowired
	private UserService userService;
	public void setform(Model model) {
		HashMap<String, String> hobbys = new HashMap<String,String>();
		hobbys.put("篮球", "basketball");
		hobbys.put("乒乓球", "pingpong");
		hobbys.put("电玩", "computer games");
		hobbys.put("游泳", "swimming");
		
//		model.addAttribute("user", new User()); 出错，每次都新建一个user，回退无法保存数据
		model.addAttribute("hobbys",hobbys);
		model.addAttribute("carrers",new String[] {"teacher","student","coding remover","IT民工","others"});
		model.addAttribute("houseRegisters", new String[] {"Beijing","ShangHai","Guangzhou","Shenzhen","others"});
	}
```
---
*Bean对象*

```
package domain;

public class User {
	private String userName;
	private String[] hobby; 
	private String[] friends;
	private String carrer;
	private String houseRegister;
	private String remark;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String[] getFriends() {
		return friends;
	}
	public void setFriends(String[] friends) {
		this.friends = friends;
	}
	public String getCarrer() {
		return carrer;
	}
	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}
	public String getHouseRegister() {
		return houseRegister;
	}
	public void setHouseRegister(String houseRegister) {
		this.houseRegister = houseRegister;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

```

---
*服务类*

```
@Service
public class UserServiceImpl implements UserService{
	//使用静态集合变量users模拟数据库
	private static ArrayList<User> users = new ArrayList<User>();
	@Override
	//增
	public boolean addUser(User u) {
		// TODO Auto-generated method stub
		if(!"IT民工".equals(u.getCarrer())) {//不允许添加 IT民工
			users.add(u);
			return true;}
		return false;
	}
	//查
	@Override
	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		return users;
	}
}
	
	//
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		
		return users.get(id); //查询某一个
	}
	
	//修改
	@Override
	public void updateUser(int id, User user) {
		// TODO Auto-generated method stub
		users.set(id, user); //修改某一个
	}
	
	//删除
	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		users.remove(id); //删除某一个
	}
	
```

---
**功能**
1. 增：
```
	@RequestMapping(value="/input")
	public String inputUser(Model model) {
		model.addAttribute("user", new User());
		setform(model);
		return "userAdd";
		
	}
```

跳转到userAdd.jsp:(注意modelAttribute="user")
```
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form modelAttribute="user" method="post" action="user/save">
	<form:input path="userName" />
```

### key point:
通过后台打开表单：后台model存放对象，form绑定对象，二者一致
- model.addAttibute("user",new User()); //相当于创建一个新表单
- form:form modelAttribute = "user" //绑定一个javabean对象
- form:input path="userName" //path和bean属性保持一致
当表单用html标签，bean成员变量名必须和name属性保持一致；
当表单用spring标签，bean成员变量名必须和path保持一致；

由userAdd.jsp跳转到/user/save:

```
@Autowired
	private UserService userService;
@RequestMapping(value="/save")
	public String addUser(@ModelAttribute User user, Model model) {
		if(userService.addUser(user)) {
			return "redirect:/user/list";
		}else {
			setform(model);
			return "userAdd";
			
		}
	}
```
### key point:
@ModelAttribute存放对象，form绑定对象 二者一致，数据回退不丢失
- @ModelAttribute User user //回退数据还在
- form:form modelAttribute="user"

@ModelAttribute User user <-> model.addAttribute("user",user);
如果没有指定键值，它的键值为类名小写，如：
@ModelAttribute UserForm user <-> model.addAttribute("userFrom",user);


2. 查

```
@RequestMapping(value="/list")
	public String listUsers(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users",users);
		return "userList";
	}
```
之前若添加成功，则 return "redirect:/user/list"

用userService获得用户List,封装到Model中存储。

之后跳转到
**userList.jsp**表格页面:

```
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1">
<c:forEach items="${users}" var="user">
            <tr>
                <td>${user.userName }</td>
            </tr>
</c:forEach>
</table>
```
### key point:
- items 属性要加双引号， 用EL表达式 ${users}获取之前封装到model中的用户List
		List<User> users = userService.getUsers();
		model.addAttribute("users",users);
- var表示每次循环的对象，表格中用EL表达式${user.userName} 取bean对象属性
- 导JSTL包

3. 改

```
//输出表单，展示某一条数据
		//user/select?id=1
		//user/select?id=0
	@RequestMapping(value="/select")
			public String update(@ModelAttribute User user,Integer id,Model model) {
				//修改某个数据
//				model.addAttribute("users",userService.getUsers()); //若不保存列表，则跳转到user/update时之前的数据丢失
				model.addAttribute("id",id);
				setform(model);
				return "userUpdate"; //打开修改表单
		}


		//修改表单，点提交。修改某一个
	@RequestMapping(value="/update")
	public String updateUser(@ModelAttribute User user,Model model, int id) {
		userService.updateUser(id, user); //arraylist set方法
		return "redirect:/user/list";
	}
```