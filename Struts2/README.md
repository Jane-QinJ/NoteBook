Struts HelloWorld program:

1. 新建Web项目
2. 导入jar包
- 参考 apps—> struts2-blank.war中的jar包
3. 编写web.xml文件-配置struts的核心控制器
- 核心控制器在Libraries中的-->struts2-core-2.3.32.jar-->org.apache.struts2.dispatcher.ng.filter.StrutsExecuteFilter中
这个核心控制器是框架开始工作的入口，负责接管请求(tomcat接到用户的request，转到Struts)

![核心控制器](https://raw.githubusercontent.com/Jane-QinJ/NoteBook/master/Struts2/chapter1/images/img1.png)

4. struts.xml

输入网址，它的运行步骤为：
1. web.xml
2. struts.xml
```
<struts>
	<!-- 开发模式 -->
    
    <constant name="struts.devMode" value="true" />

    <package name="default" namespace="/" extends="struts-default">  

        <action name="hello" class="sxau.rjxy.HelloAction">
            <result name="success">
            	/hello.jsp
<!--                 <param name="actionName">HelloWorld</param> -->
<!--                 <param name="namespace">/example</param> -->
            </result>
        </action>
    </package>

    <include file="example.xml"/>

    <!-- Add packages here -->

</struts>
```
这个struts.xml捕获web.xml核心控制器传递给它的请求(比如一个表单action)
struts.xml的package子元素中，action子元素用于配置action映射

属性class：配置action的完整实现类的名称
属性name：action的逻辑名称，用于匹配用户的请求

在以上示例中，action名为"hello",其完整实现类的名称为"sxau.rjxy.HelloAction".当请求的action名称是"hello"时，Struts2框架将执行"sxau.rjxy.HelloAction"进行处理。

3. HelloAction.java
一个action对应一个请求，它有一个默认的execute方法
- 是一个公共的 public
- 返回类型为String
- 不能有参数

```
package sxau.rjxy;

public class HelloAction {
	/**
	 * 方法->public
	 * 不能有参数
	 * 名字默认为execute()
	 * @return String
	 */
	//一个action
	public String excute() {
		System.out.println("HelloAction.execute()");
		return "success";
	}
}
```
它返回一个字符串，这个字符串和struts.xml的
```<result name="success">```
	相同

	之后返回result标签中的/hello.jsp
4. hello.jsp响应给用户

### Issues:
1. 实验中出现Http Status 404 There is no Action mapped for namespace / and action name.
判断是配置问题，导致Struts核心控制器无法找到action的map镜像
上网查得知是struts.xml的位置问题： 
**struts.xml要在src下**

2.  Server的版本过高 
修改JDK为1.8 Tomcat为1.7

### Learn
- "aaa".equals(name)
如果反写 ： name.equals('aaa');
会出现空指针异常的情况， 变量值可能为空

- Struts将所有的请求（表单或者超链接）都转变为action，由Java类来处理它们
这个类会返回一个字符串，这个返回值和Struts.xml的result标签中name一致的话，就会返回目标jsp页面

web.xml->struts.xml->Action.java->hello.jsp

**查找default.properties**
- 设置struts.xml的constant子元素
- 用于配置常量
位置：
JaveResources->Libraries->Web App Libraries->struts2-core-2.3.32.jar->org.apache.struts2->default.properties

**重要的是对struts.xml配置中的理解，一个action对应到配置文件中一个action映射**
- 对struts.xml中各个子标签的理解和对应类的修改

使用问题驱动的方式记笔记，现有问题，后有解决与优化

学习框架、技术，最重要是学习一个流程，根据流程顺序思考

### Chapter2:
1. 业务逻辑类(Aciton类)，三种实现方式
(1)自定义
(2)实现接口Action
- 五个常量
SUCCESS,ERROR,LOGIN,INPUT,NONE
- 重写execute()方法
(3)继承父类ActionSupport

2. 表达取数据，接受用户输入数据的三种方式
action里面有三种方式从页面中获取值.

一是直接在action里面写属性.这为属性驱动.
二是在action里面放一个JavaBean(领域对象)的对象.这个为对象驱动.
三是通过实现ModelDriven<Object>接口，这个为模型驱动

(1)属性驱动
在Action类中直接定义get,set方法

(2)面向对象驱动
设置一个javaBean(内置set,get方法)
通过User user = new User(); set,get user对象
表单通过user.name 取数据
```
<input name="user.name">
```
(3)模型驱动
class implements ModelDriven<User>
	实现抽象方法
	public User getModel(){
	return user;
}

表单取数据只需写属性名：
```
<input name='属性名'>
```

总的来说，就是Servlet的数据共享问题。 如何将视图中表单的值取到，和如何将action处理过的值传给视图。

3. struts.xml常量配置(constant)

优化action标签过多问题：每增加一个方法，都要增加一个不同method属性的action
- 动态方法调用
<!--     动态方法调用，添加这个constant属性可以不指定method名字调用非execute方法 -->
```
	<constant name="struts.enable.DynamicMethodInvocation" value="true"></constant>
```

优化action标签过多的问题：每增加一个功能类，都要增加一个action
优化result标签过多的问题：每增加一个页面，都要增加一个result name

**解决方法**:
使用通配符 *  两个通配符需要用"\_"隔开
```
<action name="*_*" class="sxau.rjxy.{1}Action" method="{2}">
			<result name="{2}{1}success">
<!-- 			{2} 第二个*，代表方法 ;  {1} 第一个*，代表业务处理Action名 -->
				/{2}_{1}_success.jsp
			</result>
			
			
		</action>
```
这样，在写网址时
http://localhost:8081/testdmi/Teacher_delete
请求被struts处理时，就是:
```
<action name="Teacher_delete class="sxau.rjxy.TeacherAction" method="delete">
	<result name="deleteTeacher">
		/delete_Teacher_success.jsp
	</result>
</action>
```
它就会找到正确的业务处理类TeacherAction.java
Action处理并返回字符串deleteTeacher
经result处理，返回delete_Teacher_success.jsp页面

同理，可以很方便的创建
- 业务处理类：StudentAction.java
- 返回视图：delete_Student_success.jap

**需要根据struts.xml配置修改业务逻辑类与视图名字**


### Chapter3(Ex3)
**访问request,session和application对象**

传统开发中会用到Servlet API中的HttpServletRequest,HttpSession和ServletContext。
Struts 2 提供多种方式来访问上述三种对象，归结可分为两大类：
(1)与Servlet API解耦的访问方式 (2)与ServletAPI耦合的访问方式。

1. 与ServletAPI解耦的访问方式
为了避免与ServletAPI耦合，Strut2对HttpServletRequest,HttpSession和ServletContext进行了封装， 构造了三个Map对象代替这三种对象。在Action中，直接使用HttpServletRequest,HttpSession,ServletContext对应的**Map对象**来保存和读取数据。

(1) **ActionContext** 是action执行的上下文，在ActionContext中保存了action执行所需的一组对象，包括parameters,request,session,application和locale等。ActionContext类定义了以下方法获取Web元素对应的Map对象。

- public Object get(Object key)

*ActionContext类没哟提供类似getRequest()这样的方法来获取封装了HttpServletRequest的Map对象。要得到请求Map对象，需要为get()方法传递参数"request"*

```
ActionContext context = ActionContext.getContext();
		/*public Object get(Object key)
		 * ActionContext类没有提供类似getRequest()这样的方法来获取封装了HttpServletRequest的Map对象。
		 * 要得到Map对象，需要为get方法传递参数"request"*/
		Map request = (Map) context.get("request");
```

- public Map getSession()
获取封装了HttpSession的Map对象。

- public Map getApplication()
获取封装了ServletContext的Map对象。

Action中：
```
ActionContext context = ActionContext.getContext();
Map session = context.getSession();
Map application = context.getApplication();
在请求中放置信息
		request.put("r1", "r1");
//		在session中保存user对象
		session.put("user", "user");
//		在application中保存信息
		application.put("appkey", "value");
```

JSP视图中：
可用EL表达式访问：

```
${requestScope.r1}
${sessionScope.user}
${applicationScope.appkey}
```

(2) 接口注入方式获取request,session,application对象
- org.apache.struts2.interceptor.RequestAware
	框架利用RequestAware接口，向Action实例注入request Map对象。该接口只有一个方法
	- public void setRequest(Map request)
- org.apache.struts2.interceptor.SessionAware
	框架利用SessionAware接口，向Action实例注入session Map对象。该接口只有一个方法
	- void setSessioin(Map session)
- org.apache.struts2.interceptor.ApplicationAware
 	框架利用ApplicationAware接口，向Action实例注入application Map对象。该接口只有一个方法
 	- void setApplication(Map application)

 **eg**:
```
public class WebAction2 extends ActionSupport implements RequestAware,SessionAware{
	private Map request;
	private Map session;
	private Map application;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		在请求中放置信息
		request.put("r1", "r1");
//		在session中保存user对象
		session.put("user", "user");
		return super.execute();
	}
	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		this.session = session;
		}

	@Override
	public void setRequest(Map request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
``` 
2. 与Servlet API耦合的访问方式

直接访问Servlet API使Action和Servlet环境耦合在一起，对于HttpServletRequest,HttpServletResponse和ServletContext这些对象，都是由Servlet容器构造的，与这些对象绑定在一起，测试时就需要有Servlet容器，不便于Action的单元测试。
但有时需要直接访问这些对象，要直接获取HttpServletRequest和ServletContext对象，可以

(1)使用org.apache.struts2.**ServletActionContext**类，该类时ActionContext的子类，它有两个静态方法：
- public static HttpServletRequest getRequest()
得到HttpServletRequest对象
- public static ServletContext getServletContext()
得到ServletContext对象
- public static HttpServletResponse getResponse()
获取HttpServletResponse对象
**ServletActionContext类没有直接得到Httpsession对象的方法，它可通过HttpServletRequest对象得到**

**eg**：
```
public class WebAction3 extends ActionSupport{

	HttpServletRequest request;
	HttpSession session;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		request = ServletActionContext.getRequest();
	/*ServletActionContext类并没有给出直接得到HttpSession对象的方法
	 * HttpSession对象可以通过HttpServletRequest对象来得到*/
		session = request.getSession(true);
		
		request.setAttribute("r1", "r1");
		session.setAttribute("session", "session");
		return super.execute();
	}
	
}

```
(2) 接口注入(耦合IOC)
通过Action类**实现ServletRequestAware和ServletContextAware接口**
由Struts2框架向Action实例注入HttpServletRequest和ServletContext对象。

org.apache.struts2.interceptor.ServletRequestAware接口有一个方法
- void setServletRequest(HttpServletRequest request)

org.apache.struts2.util.ServletContextAware接口有一个方法
- void setServletContext(ServletContext context)
```
public class WebAction extends ActionSupport implements ServletRequestAware{
	HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		注入中的解耦方式
//		ActionContext.getContext("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
		request.setAttribute("r1", "implements ServletRequestAware");
		return super.execute();
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
//		接口注入方式： 接口提供set方法，将HttpServletRequest对象注入到Action
		this.request = request;
	}
	
	
}

```

#### issues
**Q**：
1. OGNL访问静态方法时无法访问
**S**
访问静态方法

```
<s:property value="@com.test.util.S@abc()">
```

注意,两个@是约定..也就是必须这么写.第一个@后面跟的是类的全名.第二个@后面跟的是对应的方法名.当然,这个方法必须是静态的

 这个访问静态方法在struts2.1以后的版本里面需要设置一个属性,否则系统默认是不支持访问静态方法的(struts2.0版本默认是支持访问静态方法的).具体的方法是在struts.xml里面添加这么一句

```
 <constant name="struts.ognl.allowStaticMethodAccess" value="true"></constant>
 ```
[ognl](https://www.cnblogs.com/20gg-com/p/6080107.html)

### Chapter4(Ex4)

*OGNL：*
**访问Action属性**
- Action实例通常压入值栈中。 因为Action在值栈中，并且值栈是OGNL的根，所以访问Action的属性时可以省略井号#

**表单标签的name和value属性**
- name属性除了为HTML表单元素指定名字，在表单提交时作为请求参数的名字外，同时它还映射到Action的属性。多数下，name属性映射到一个简单的JavaBean属性(property)，如：name属性的值为'postalCode',表单提交后，Struts2框架会调用Action的setPostalCode()方法来设置属性(property)

字符串属性与非字符串属性：
	使用%可以定义非字符串属性
	之后国际化用%{getText('key')}来调用ActionSupport中的getText()方法

### Struts标签库分为
使用前需引入Struts2标签库

```
<%@ taglib uri="/struts-tags" prefix = "s" %>
```

1. 用户界面标签

- 表单标签
- 非表单标签

2. 非用户标签(普通标签)
- 控制标签
- 数据标签


### issues
表单value值为传给服务器的值
```
<select>
	<option value="1">高中</option>
	<option value="2">大学</option>
	<option value="3">硕士</option>
	<option value="4">博士</option>

</select>
```

### Chapter5(Ex5)
**国际化**
1. Java中的国际化
java.util中：

java.util.Locale
- public Locale(String language)
- public Locale(String language,String country)
language表示语言，取值由ISO-639定义的小写的、两个字母组成的语言代码。
country表示国家或地区，取值由ISO-3166定义的大写的、两个字母组成的代码。

```
import java.util.Locale;
import java.util.ResourceBundle;
		Locale locale = new Locale("zn","CN");
		ResourceBundle res = ResourceBundle.getBundle("MyResources",locale);
		//res.getString("");
		System.out.println(res.getString("msg"));
	
```

**资源包**
在 **src**下新建资源文件
baseName_language_country.properties

```
MyResources_en_US.properties

MyResources_zn_CN.properties
```

资源文件内容为 key = value
eg:

```
msg = hello
```

通过
java.util.ResourceBundle类

获取某个资源包，调用这个类的静态方法getBundle()：
根据基名得到资源包，使用系统缺省的Locale对象
- public static final ResourceBundle getBundle(String baseName)

根据基名和Locale对象得到资源包
- public static final ResourceBundle getBundle(String baseName,Locale locale)

利用getBundle()方法可以得到对应于某个Locale对象的资源包，然后就可以利用ResourceBundle类的getString()方法得到相应语言版本的字符串。

- public final String getString(String key)
从资源包中根据关键字得到字符串

```
Locale locale = new Locale("zn","CN");
ResourceBundle res = ResourceBundle.getBundle("MyResources",locale);
		//res.getString("");
System.out.println(res.getString("msg"));
```

2. Struts中的国际化

**a. 使用sturts.custom.i18n.resources常量实现国际化**
(1)创建工程与web.xml文件，配置过滤器
(2)src下建立struts.xml
- action中 name class
- result标签中 name属性
**添加constant常量**

```
<constant name="struts.custom.i18n.resources value="baseName of properties"/>
```

(3)创建Action，返回struts.xml中指定的字符串
(4)创建视图
直接使用i18n标签

```
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:a href="login?request_locale=en">英语</s:a>
	<s:a href="login?request_locale=zh">汉语</s:a>
	<s:form>
		<s:textfield name="username" key="info.username"></s:textfield>
<!-- 		getText()要继承ActionSupport方法才有    
			 %可以调方法，防止只输出字符串 -->
		<s:textfield name="password" label="%{getText('info.password')}"></s:textfield>
		<s:submit key="info.submit"></s:submit>
	</s:form>
```

**b. 使用i18n标签实现国际化**
不使用constant配置，显示声明标签
```
	<s:i18n name="baseName">
```

```
<s:form>
		<s:i18n name="app">
		<s:textfield name="username" key="info.username"></s:textfield>
<!-- 		getText()要继承ActionSupport方法才有    
			 %可以调方法，防止只输出字符串 -->
		<s:textfield name="password" label="%{getText('info.password')}"></s:textfield>
		<s:submit key="info.submit"></s:submit>
		</s:i18n name="app">
	</s:form>
```

#### 访问资源文件中消息的方式

1. 在表单标签中访问资源文件中的消息

(1) 使用表单标签的key属性，属性的值是资源文件中消息的key

```
<s:textfield name="username" key="info.username"></s:textfield>
```

(2) 使用表单标签的label属性，属性的值通过getText()方法获取

```
<!-- 		getText()要继承ActionSupport方法才有    
			 %可以调方法，防止只输出字符串 -->
		<s:textfield name="password" label="%{getText('info.password')}"></s:textfield>
```

2. 在Action中访问资源文件中的消息
Struts2的com.opensymphony.xwork2.TextProvider接口定义了访问资源文件中消息的getText()方法，ActionSupport类实现了该接口。

因此在Action中访问资源文件中的消息，只需Action extends ActionSupport就可在Action类中直接使用getText(String key) 方法获取资源文件中的消息

3. 在JSP页面中访问资源文件中的消息
- 使用text标签
(1) 资源文件中用占位符:{0}

```
msg.welcome=\u6B22\u8FCE,{0}
```

视图中：

通过s:param标签给资源文件中的占位符传递参数。
如果有多个不同的占位符，则s:param标签的顺序和占位符的数字顺序依次对应

```
<s:text name="msg.welcome">
<!-- 		通过在资源文件中添加占位符，在视图用s:param给资源文件的占位符传递参数 -->
		<s:param>
			<s:property value="username"/>
		</s:param>
	</s:text>
```

(2)资源文件中用ognl表达式:${username}

```
msg.welcome.ognl=\u6B22\u8FCE,${username}
```

```
1. 占位符{0}   s:param 传参 <br>
	<s:text name="msg.welcome">
<!-- 		通过在资源文件中添加占位符，在视图用s:param给资源文件的占位符传递参数 -->
		<s:param>
			<s:property value="username"/>
		</s:param>
	</s:text>
<%-- 	<s:property value="username"/> --%>
<br>
=============<br>
2. ognl $ {username } <br>
	<s:text name="msg.welcome.ognl">
		
	</s:text>
```

**添加用户名验证**

1. struts.xml

```
<action name="login" class="sxau.rjxy.LoginAction">
            <result name="login">
            	/login.jsp
            </result>
            <result name="success">
            	/welcome.jsp
           </result>
        </action>
```

2. LoginAction中

```
	public String execute() {
		if(username==null||username.equals("")) {
			return "login";
		}
		else {
			return "success";
		}
	}
```

3. login.jsp
(1) 表单action发出的login请求会被strut.xml转交给LoginAction处理
(2) 在LoginAction中判断用户名
- 为空：返回字符串login
- 不为空：返回字符串success
(3) 处理结果字符串和result标签的name属性比对
- 若为login,跳转到login.jsp(用户名为空，跳转回登录页面)
- 若为success,跳转到welcome.jsp(用户名正确，跳转到欢迎页面)
```
<s:form action="login">
		<s:textfield name="username" key="info.username"></s:textfield>
<!-- 		getText()要继承ActionSupport方法才有    
			 %可以调方法，防止只输出字符串 -->
		<s:textfield name="password" label="%{getText('info.password')}"></s:textfield>
		<s:submit key="info.submit"></s:submit>
	</s:form>
```

### Learn
**Q**：解决端口占用
**S**
1. 查看端口情况
```
netstat -ano
```
2. 查看进程号
```
netstat -ano|findstr "端口号"
```
3. 任务管理器禁用占用端口的进程