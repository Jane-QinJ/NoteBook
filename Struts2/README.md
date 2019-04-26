Struts HelloWorld program:

1. �½�Web��Ŀ
2. ����jar��
- �ο� apps��> struts2-blank.war�е�jar��
3. ��дweb.xml�ļ�-����struts�ĺ��Ŀ�����
- ���Ŀ�������Libraries�е�-->struts2-core-2.3.32.jar-->org.apache.struts2.dispatcher.ng.filter.StrutsExecuteFilter��
������Ŀ������ǿ�ܿ�ʼ��������ڣ�����ӹ�����(tomcat�ӵ��û���request��ת��Struts)

![���Ŀ�����](https://raw.githubusercontent.com/Jane-QinJ/NoteBook/master/Struts2/chapter1/images/img1.png)

```
<filter>
        <filter-name>struts2</filter-name>
        <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>struts2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

4. struts.xml

������ַ���������в���Ϊ��
1. web.xml
2. struts.xml
```
<struts>
	<!-- ����ģʽ -->
    
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
���struts.xml����web.xml���Ŀ��������ݸ���������(����һ����action)
struts.xml��package��Ԫ���У�action��Ԫ����������actionӳ��

����class������action������ʵ���������
����name��action���߼����ƣ�����ƥ���û�������

������ʾ���У�action��Ϊ"hello",������ʵ���������Ϊ"sxau.rjxy.HelloAction".�������action������"hello"ʱ��Struts2��ܽ�ִ��"sxau.rjxy.HelloAction"���д���

3. HelloAction.java
һ��action��Ӧһ����������һ��Ĭ�ϵ�execute����
- ��һ�������� public
- ��������ΪString
- �����в���

```
package sxau.rjxy;

public class HelloAction {
	/**
	 * ����->public
	 * �����в���
	 * ����Ĭ��Ϊexecute()
	 * @return String
	 */
	//һ��action
	public String excute() {
		System.out.println("HelloAction.execute()");
		return "success";
	}
}
```
������һ���ַ���������ַ�����struts.xml��
```<result name="success">```
	��ͬ

	֮�󷵻�result��ǩ�е�/hello.jsp
4. hello.jsp��Ӧ���û�

### Issues:
1. ʵ���г���Http Status 404 There is no Action mapped for namespace / and action name.
�ж����������⣬����Struts���Ŀ������޷��ҵ�action��map����
�������֪��struts.xml��λ�����⣺ 
**struts.xmlҪ��src��**

2.  Server�İ汾���� 
�޸�JDKΪ1.8 TomcatΪ1.7

### Learn
- "aaa".equals(name)
�����д �� name.equals('aaa');
����ֿ�ָ���쳣������� ����ֵ����Ϊ��

- Struts�����е����󣨱����߳����ӣ���ת��Ϊaction����Java������������
�����᷵��һ���ַ������������ֵ��Struts.xml��result��ǩ��nameһ�µĻ����ͻ᷵��Ŀ��jspҳ��

web.xml->struts.xml->Action.java->hello.jsp

**����default.properties**
- ����struts.xml��constant��Ԫ��
- �������ó���
λ�ã�
JaveResources->Libraries->Web App Libraries->struts2-core-2.3.32.jar->org.apache.struts2->default.properties

**��Ҫ���Ƕ�struts.xml�����е���⣬һ��action��Ӧ�������ļ���һ��actionӳ��**
- ��struts.xml�и����ӱ�ǩ�����Ͷ�Ӧ����޸�

ʹ�����������ķ�ʽ�Ǳʼǣ��������⣬���н�����Ż�

ѧϰ��ܡ�����������Ҫ��ѧϰһ�����̣���������˳��˼��

### Chapter2:
1. ҵ���߼���(Aciton��)������ʵ�ַ�ʽ
(1)�Զ���
(2)ʵ�ֽӿ�Action
- �������
SUCCESS,ERROR,LOGIN,INPUT,NONE
- ��дexecute()����
(3)�̳и���ActionSupport

2. ���ȡ���ݣ������û��������ݵ����ַ�ʽ
action���������ַ�ʽ��ҳ���л�ȡֵ.

һ��ֱ����action����д����.��Ϊ��������. (**Ҫ��get,set����**)
������action�����һ��JavaBean(�������)�Ķ���.���Ϊ��������.
����ͨ��ʵ��ModelDriven<Object>�ӿڣ����Ϊģ������

(1)��������
��Action����ֱ�Ӷ���get,set����

(2)�����������
����һ��javaBean(����set,get����)
ͨ��User user = new User(); set,get user����
��ͨ��user.name ȡ����
```
<input name="user.name">
```
(3)ģ������
class implements ModelDriven<User>
	ʵ�ֳ��󷽷�
	public User getModel(){
	return user;
}

��ȡ����ֻ��д��������
```
<input name='������'>
```

�ܵ���˵������Servlet�����ݹ������⡣ ��ν���ͼ�б���ֵȡ��������ν�action�������ֵ������ͼ��

3. struts.xml��������(constant)

�Ż�action��ǩ�������⣺ÿ����һ����������Ҫ����һ����ͬmethod���Ե�action
- ��̬��������
<!--     ��̬�������ã�������constant���Կ��Բ�ָ��method���ֵ��÷�execute���� -->
```
	<constant name="struts.enable.DynamicMethodInvocation" value="true"></constant>
```

�Ż�action��ǩ��������⣺ÿ����һ�������࣬��Ҫ����һ��action
�Ż�result��ǩ��������⣺ÿ����һ��ҳ�棬��Ҫ����һ��result name

**�������**:
ʹ��ͨ��� *  ����ͨ�����Ҫ��"\_"����
```
<action name="*_*" class="sxau.rjxy.{1}Action" method="{2}">
			<result name="{2}{1}success">
<!-- 			{2} �ڶ���*�������� ;  {1} ��һ��*������ҵ����Action�� -->
				/{2}_{1}_success.jsp
			</result>
			
			
		</action>
```
��������д��ַʱ
http://localhost:8081/testdmi/Teacher_delete
����struts����ʱ������:
```
<action name="Teacher_delete class="sxau.rjxy.TeacherAction" method="delete">
	<result name="deleteTeacher">
		/delete_Teacher_success.jsp
	</result>
</action>
```
���ͻ��ҵ���ȷ��ҵ������TeacherAction.java
Action���������ַ���deleteTeacher
��result��������delete_Teacher_success.jspҳ��

ͬ�����Ժܷ���Ĵ���
- ҵ�����ࣺStudentAction.java
- ������ͼ��delete_Student_success.jap

**��Ҫ����struts.xml�����޸�ҵ���߼�������ͼ����**


### Chapter3(Ex3)
**����request,session��application����**

��ͳ�����л��õ�Servlet API�е�HttpServletRequest,HttpSession��ServletContext��
Struts 2 �ṩ���ַ�ʽ�������������ֶ��󣬹��ɷ�Ϊ�����ࣺ
(1)��Servlet API����ķ��ʷ�ʽ (2)��ServletAPI��ϵķ��ʷ�ʽ��

1. ��ServletAPI����ķ��ʷ�ʽ
Ϊ�˱�����ServletAPI��ϣ�Strut2��HttpServletRequest,HttpSession��ServletContext�����˷�װ�� ����������Map������������ֶ�����Action�У�ֱ��ʹ��HttpServletRequest,HttpSession,ServletContext��Ӧ��**Map����**������Ͷ�ȡ���ݡ�

(1) **ActionContext** ��actionִ�е������ģ���ActionContext�б�����actionִ�������һ����󣬰���parameters,request,session,application��locale�ȡ�ActionContext�ඨ�������·�����ȡWebԪ�ض�Ӧ��Map����

- public Object get(Object key)

*ActionContext��ûӴ�ṩ����getRequest()�����ķ�������ȡ��װ��HttpServletRequest��Map����Ҫ�õ�����Map������ҪΪget()�������ݲ���"request"*

```
ActionContext context = ActionContext.getContext();
		/*public Object get(Object key)
		 * ActionContext��û���ṩ����getRequest()�����ķ�������ȡ��װ��HttpServletRequest��Map����
		 * Ҫ�õ�Map������ҪΪget�������ݲ���"request"*/
		Map request = (Map) context.get("request");
```

- public Map getSession()
��ȡ��װ��HttpSession��Map����

- public Map getApplication()
��ȡ��װ��ServletContext��Map����

Action�У�
```
ActionContext context = ActionContext.getContext();
Map session = context.getSession();
Map application = context.getApplication();
�������з�����Ϣ
		request.put("r1", "r1");
//		��session�б���user����
		session.put("user", "user");
//		��application�б�����Ϣ
		application.put("appkey", "value");
```

JSP��ͼ�У�
����EL���ʽ���ʣ�

```
${requestScope.r1}
${sessionScope.user}
${applicationScope.appkey}
```

(2) �ӿ�ע�뷽ʽ��ȡrequest,session,application����
- org.apache.struts2.interceptor.RequestAware
	�������RequestAware�ӿڣ���Actionʵ��ע��request Map���󡣸ýӿ�ֻ��һ������
	- public void setRequest(Map request)
- org.apache.struts2.interceptor.SessionAware
	�������SessionAware�ӿڣ���Actionʵ��ע��session Map���󡣸ýӿ�ֻ��һ������
	- void setSessioin(Map session)
- org.apache.struts2.interceptor.ApplicationAware
 	�������ApplicationAware�ӿڣ���Actionʵ��ע��application Map���󡣸ýӿ�ֻ��һ������
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
//		�������з�����Ϣ
		request.put("r1", "r1");
//		��session�б���user����
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
2. ��Servlet API��ϵķ��ʷ�ʽ

ֱ�ӷ���Servlet APIʹAction��Servlet���������һ�𣬶���HttpServletRequest,HttpServletResponse��ServletContext��Щ���󣬶�����Servlet��������ģ�����Щ�������һ�𣬲���ʱ����Ҫ��Servlet������������Action�ĵ�Ԫ���ԡ�
����ʱ��Ҫֱ�ӷ�����Щ����Ҫֱ�ӻ�ȡHttpServletRequest��ServletContext���󣬿���

(1)ʹ��org.apache.struts2.**ServletActionContext**�࣬����ʱActionContext�����࣬����������̬������
- public static HttpServletRequest getRequest()
�õ�HttpServletRequest����
- public static ServletContext getServletContext()
�õ�ServletContext����
- public static HttpServletResponse getResponse()
��ȡHttpServletResponse����
**ServletActionContext��û��ֱ�ӵõ�Httpsession����ķ���������ͨ��HttpServletRequest����õ�**

**eg**��
```
public class WebAction3 extends ActionSupport{

	HttpServletRequest request;
	HttpSession session;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		request = ServletActionContext.getRequest();
	/*ServletActionContext�ಢû�и���ֱ�ӵõ�HttpSession����ķ���
	 * HttpSession�������ͨ��HttpServletRequest�������õ�*/
		session = request.getSession(true);
		
		request.setAttribute("r1", "r1");
		session.setAttribute("session", "session");
		return super.execute();
	}
	
}

```
(2) �ӿ�ע��(���IOC)
ͨ��Action��**ʵ��ServletRequestAware��ServletContextAware�ӿ�**
��Struts2�����Actionʵ��ע��HttpServletRequest��ServletContext����

org.apache.struts2.interceptor.ServletRequestAware�ӿ���һ������
- void setServletRequest(HttpServletRequest request)

org.apache.struts2.util.ServletContextAware�ӿ���һ������
- void setServletContext(ServletContext context)
```
public class WebAction extends ActionSupport implements ServletRequestAware{
	HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		ע���еĽ��ʽ
//		ActionContext.getContext("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
		request.setAttribute("r1", "implements ServletRequestAware");
		return super.execute();
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
//		�ӿ�ע�뷽ʽ�� �ӿ��ṩset��������HttpServletRequest����ע�뵽Action
		this.request = request;
	}
	
	
}

```

#### issues
**Q**��
1. OGNL���ʾ�̬����ʱ�޷�����
**S**
���ʾ�̬����

```
<s:property value="@com.test.util.S@abc()">
```

ע��,����@��Լ��..Ҳ���Ǳ�����ôд.��һ��@������������ȫ��.�ڶ���@��������Ƕ�Ӧ�ķ�����.��Ȼ,������������Ǿ�̬��

 ������ʾ�̬������struts2.1�Ժ�İ汾������Ҫ����һ������,����ϵͳĬ���ǲ�֧�ַ��ʾ�̬������(struts2.0�汾Ĭ����֧�ַ��ʾ�̬������).����ķ�������struts.xml���������ôһ��

```
 <constant name="struts.ognl.allowStaticMethodAccess" value="true"></constant>
 ```
[ognl](https://www.cnblogs.com/20gg-com/p/6080107.html)

### Chapter4(Ex4)

*OGNL��*
**����Action����**
- Actionʵ��ͨ��ѹ��ֵջ�С� ��ΪAction��ֵջ�У�����ֵջ��OGNL�ĸ������Է���Action������ʱ����ʡ�Ծ���#

**����ǩ��name��value����**
- name���Գ���ΪHTML��Ԫ��ָ�����֣��ڱ��ύʱ��Ϊ��������������⣬ͬʱ����ӳ�䵽Action�����ԡ������£�name����ӳ�䵽һ���򵥵�JavaBean����(property)���磺name���Ե�ֵΪ'postalCode',���ύ��Struts2��ܻ����Action��setPostalCode()��������������(property)

�ַ�����������ַ������ԣ�
	ʹ��%���Զ�����ַ�������
	֮����ʻ���%{getText('key')}������ActionSupport�е�getText()����

### Struts��ǩ���Ϊ
ʹ��ǰ������Struts2��ǩ��

```
<%@ taglib uri="/struts-tags" prefix = "s" %>
```

1. �û������ǩ

- ����ǩ
- �Ǳ���ǩ

2. ���û���ǩ(��ͨ��ǩ)
- ���Ʊ�ǩ
- ���ݱ�ǩ


### issues
��valueֵΪ������������ֵ
```
<select>
	<option value="1">����</option>
	<option value="2">��ѧ</option>
	<option value="3">˶ʿ</option>
	<option value="4">��ʿ</option>

</select>
```

### Chapter5(Ex5)
**���ʻ�**
1. Java�еĹ��ʻ�
java.util�У�

java.util.Locale
- public Locale(String language)
- public Locale(String language,String country)
language��ʾ���ԣ�ȡֵ��ISO-639�����Сд�ġ�������ĸ��ɵ����Դ��롣
country��ʾ���һ������ȡֵ��ISO-3166����Ĵ�д�ġ�������ĸ��ɵĴ��롣

```
import java.util.Locale;
import java.util.ResourceBundle;
		Locale locale = new Locale("zn","CN");
		ResourceBundle res = ResourceBundle.getBundle("MyResources",locale);
		//res.getString("");
		System.out.println(res.getString("msg"));
	
```

**��Դ��**
�� **src**���½���Դ�ļ�
baseName_language_country.properties

```
MyResources_en_US.properties

MyResources_zn_CN.properties
```

��Դ�ļ�����Ϊ key = value
eg:

```
msg = hello
```

ͨ��
java.util.ResourceBundle��

��ȡĳ����Դ�������������ľ�̬����getBundle()��
���ݻ����õ���Դ����ʹ��ϵͳȱʡ��Locale����
- public static final ResourceBundle getBundle(String baseName)

���ݻ�����Locale����õ���Դ��
- public static final ResourceBundle getBundle(String baseName,Locale locale)

����getBundle()�������Եõ���Ӧ��ĳ��Locale�������Դ����Ȼ��Ϳ�������ResourceBundle���getString()�����õ���Ӧ���԰汾���ַ�����

- public final String getString(String key)
����Դ���и��ݹؼ��ֵõ��ַ���

```
Locale locale = new Locale("zn","CN");
ResourceBundle res = ResourceBundle.getBundle("MyResources",locale);
		//res.getString("");
System.out.println(res.getString("msg"));
```

2. Struts�еĹ��ʻ�

**a. ʹ��struts.custom.i18n.resources����ʵ�ֹ��ʻ�**
(1)����������web.xml�ļ������ù�����
(2)src�½���struts.xml
- action�� name class
- result��ǩ�� name����
**���constant����**

```
<constant name="struts.custom.i18n.resources value="baseName of properties"/>
```

(3)����Action������struts.xml��ָ�����ַ���
(4)������ͼ
ֱ��ʹ��i18n��ǩ

```
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:a href="login?request_locale=en">Ӣ��</s:a>
	<s:a href="login?request_locale=zh">����</s:a>
	<s:form>
		<s:textfield name="username" key="info.username"></s:textfield>
<!-- 		getText()Ҫ�̳�ActionSupport��������    
			 %���Ե���������ֹֻ����ַ��� -->
		<s:textfield name="password" label="%{getText('info.password')}"></s:textfield>
		<s:submit key="info.submit"></s:submit>
	</s:form>
```

��Դ�ļ���
```
info.username=username
info.password=password
```

**b. ʹ��i18n��ǩʵ�ֹ��ʻ�**
��ʹ��constant���ã���ʾ������ǩ
```
	<s:i18n name="baseName">
```

```
<s:form>
		<s:i18n name="app">
		<s:textfield name="username" key="info.username"></s:textfield>
<!-- 		getText()Ҫ�̳�ActionSupport��������    
			 %���Ե���������ֹֻ����ַ��� -->
		<s:textfield name="password" label="%{getText('info.password')}"></s:textfield>
		<s:submit key="info.submit"></s:submit>
		</s:i18n name="app">
	</s:form>
```

#### ������Դ�ļ�����Ϣ�ķ�ʽ

1. �ڱ���ǩ�з�����Դ�ļ��е���Ϣ

(1) ʹ�ñ���ǩ��key���ԣ����Ե�ֵ����Դ�ļ�����Ϣ��key

```
<s:textfield name="username" key="info.username"></s:textfield>
```

(2) ʹ�ñ���ǩ��label���ԣ����Ե�ֵͨ��getText()������ȡ

```
<!-- 		getText()Ҫ�̳�ActionSupport��������    
			 %���Ե���������ֹֻ����ַ��� -->
		<s:textfield name="password" label="%{getText('info.password')}"></s:textfield>
```

2. ��Action�з�����Դ�ļ��е���Ϣ
Struts2��com.opensymphony.xwork2.TextProvider�ӿڶ����˷�����Դ�ļ�����Ϣ��getText()������ActionSupport��ʵ���˸ýӿڡ�

�����Action�з�����Դ�ļ��е���Ϣ��ֻ��Action extends ActionSupport�Ϳ���Action����ֱ��ʹ��getText(String key) ������ȡ��Դ�ļ��е���Ϣ

3. ��JSPҳ���з�����Դ�ļ��е���Ϣ
- ʹ��text��ǩ
(1) ��Դ�ļ�����ռλ��:{0}

```
msg.welcome=\u6B22\u8FCE,{0}
```

��ͼ�У�

ͨ��s:param��ǩ����Դ�ļ��е�ռλ�����ݲ�����
����ж����ͬ��ռλ������s:param��ǩ��˳���ռλ��������˳�����ζ�Ӧ

```
<s:text name="msg.welcome">
<!-- 		ͨ������Դ�ļ������ռλ��������ͼ��s:param����Դ�ļ���ռλ�����ݲ��� -->
		<s:param>
			<s:property value="username"/>
		</s:param>
	</s:text>
```

(2)��Դ�ļ�����ognl���ʽ:${username}

```
msg.welcome.ognl=\u6B22\u8FCE,${username}
```

```
1. ռλ��{0}   s:param ���� <br>
	<s:text name="msg.welcome">
<!-- 		ͨ������Դ�ļ������ռλ��������ͼ��s:param����Դ�ļ���ռλ�����ݲ��� -->
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

**����û�����֤**

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

2. LoginAction��

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
(1) ��action������login����ᱻstrut.xmlת����LoginAction����
(2) ��LoginAction���ж��û���
- Ϊ�գ������ַ���login
- ��Ϊ�գ������ַ���success
(3) �������ַ�����result��ǩ��name���Աȶ�
- ��Ϊlogin,��ת��login.jsp(�û���Ϊ�գ���ת�ص�¼ҳ��)
- ��Ϊsuccess,��ת��welcome.jsp(�û�����ȷ����ת����ӭҳ��)
```
<s:form action="login">
		<s:textfield name="username" key="info.username"></s:textfield>
<!-- 		getText()Ҫ�̳�ActionSupport��������    
			 %���Ե���������ֹֻ����ַ��� -->
		<s:textfield name="password" label="%{getText('info.password')}"></s:textfield>
		<s:submit key="info.submit"></s:submit>
	</s:form>
```

### Learn
**Q**������˿�ռ��
**S**
1. �鿴�˿����
```
netstat -ano
```
2. �鿴���̺�
```
netstat -ano|findstr "�˿ں�"
```
3. �������������ռ�ö˿ڵĽ���

### chapter6(EX6)
Struts2��ܵ�����ת��
1. ������������ת��

**issues**
- ��������
- ���ڸ�ʽֻ��Ϊ 'xxxx-xx-xx'
SHORT��ʽ����
2. List����ת��

3. �Զ�������ת��

(1)�����Զ�������ת����

Converter:
- �̳�DefaultTypeConverter��
����StrutsTypeConverter�ӿڵļ򻯰�

```

/*
	 * Map context:����ָ��ִ��ת����������
	 * Object value:����ָ������ת����ֵ
	 * Class toType:����ָ��ֵ��ת����������
	 */

public Object convertValue(Map<String,Object) context, Object target, Member member, String propertyName, Object value, Class toType){
	return convertValue(context,value,toType);
}

public Object convertValue(Map<String,Object> context, Object value,Class toType){
	return convertType(value,toType);
}
```

PointConverter:
```
public class PointConverter extends StrutsTypeConverter{
//���е���������������б�ת��������ֵ��Ŀ�����
	
	/*
	 * Map context:����ָ��ִ��ת����������
	 * Object value:����ָ������ת����ֵ
	 * Class toType:����ָ��ֵ��ת����������
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// TODO Auto-generated method stub
		System.out.println("��Stringת��Ϊָ��������");
		String value = values[0];
		Point point = new Point();
		//(3,4)
		//x:�ڶ�����ʼ�������Ž���
		//y:�Ӷ��ſ�ʼ���������ڶ�������
		/*
		 *1. substring: 
		 * Returns a string that is a substring of this string. 
		 * The substring begins at the specified beginIndex andextends to the character at index endIndex - 1.
		 * Thus the length of the substring is endIndex-beginIndex.
		 * ����ָ���±���Ӵ�
		 * 2. indexof(str):
		 * Returns the index within this string of the first occurrence of the specified substring. 
		 * ����ָ���Ӵ���һ�γ��ֵ��±�
		 */ 
		
		point.setX(Integer.parseInt(value.substring(1, value.indexOf(","))));
		point.setY(Integer.parseInt(value.substring(value.indexOf(","), value.length()-1)));
		return point;
	}
	//ʹ��ognl���ʽ��ȡֵʱ����ø÷���
	@Override
	public String convertToString(Map content, Object obj) {
		// TODO Auto-generated method stub
		System.out.println("��ָ��������ת��ΪString");
		Point p = (Point)obj;
		return p.toString();
	}

}

```

(2)ע���Զ�������ת����

- ȫ��ע�᷽ʽ
ע��Ϊȫ�ֵ�����ת���������е�Action�������á�ע��ȫ�ֵ�����ת������Ҫ��WebӦ�õ�WEB-INF/classesĿ¼�´���һ������Ϊxwork-conversion.properties�������ļ���

�����ļ��ɼ�-ֵ����ɣ���ʽ���£�

```
��ת���������ʵ�������� = �Զ�������ת����������ʵ��������
```

- �ֲ�ע�᷽ʽ

ע��Ϊ�ֲ�������ת�����ֳ�Ϊ�ض��������ת������ע��ֲ�������ת������Ҫ�������ڵİ��н���һ���ļ���������ClassName-conversion.properties�������ļ���

�����ļ��ɼ�ֵ����ɣ���ʽ���£�

```
propertyName = �Զ�������ת����������ʵ��������
```
propertyName�����б�ת�����ֶ����ƣ�ֵ���Զ�������ת��������ʵ�������ơ�

(3) ��WebӦ����ʹ���Զ�������ת����

### issues
��ͼ�ղ������ݣ�Ҳû��ת��
�����Ʋ⣺ת����û�м��س�����ע��ת����������

### chapter7(Ex7)
һ�� ������

1. ����������������ʵ�ַ�ʽ��aʵ��Interceptor�ӿ�    b���̳�AbstractIntercepter�ࣩ

- ʵ��Interceptor�ӿ�

```
public class MyInterceptor1 extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//����ֵObject,ǿת
		HelloWorld hw = (HelloWorld)invocation.getAction(); //�������ļ�����ȡAction���� 
		hw.addActionMessage("Calling MyInterceptor1"); //action�̳�ActionSupport,ӵ�еĸ��෽��
		System.out.println("Calling MyInterceptor1");
		hw.addActionMessage("MyInterceptor1-1:ActionClass name is: "+ hw.getClass().getName());
		
		System.out.println("MyInterceptor1-1:ActionClass name is: "+ hw.getClass().getName());
		
		/*
		 * invocation.invoke()����֮ǰ�Ĵ��뽫��Actionִ��֮ǰִ��
			invocation.invoke()����֮��Ĵ��뽫��Actionִ��֮��ִ�С�
		 */
		String result = invocation.invoke(); //���У�ת��ActionInvocation
		hw.addActionMessage("MyInterceptor1-2:Theresult is: "+result);
		System.out.println("MyInterceptor1-2:Theresult is: "+result);
		
		return result;
	}

}

```

2. ע��������

```
<!-- 		ע��������  ����Action֮ǰִ��-->
		<interceptors>
			<interceptor name="myInterceptor1"
			class="sxau.rjxy.MyInterceptor1"></interceptor>
		</interceptors>		
		
```

3. ʹ��������

```
<action name="helloWorld" class="sxau.rjxy.HelloWorld" >
			<result name="success">
				/inputMessage.jsp
			</result>
			
<!-- 			ʹ�������� ��action�ڶ���-->
			<interceptor-ref name="defaultStack"/>
			<interceptor-ref name="myInterceptor1"/>			
			
		</action>
		
```

5. Action���� ��ȡ��Ϣ

```
public class HelloWorld extends ActionSupport{
	private String message;
	//������Ҫ������ֵ�Ͳ���
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute() {
		addActionMessage("HelloWorld! Message is:" + message);
		System.out.println("HelloWorld! Message is:" + message);
		return SUCCESS;
	}
}
```

6. View��ͼ

```
<s:actionmessage/>
	<s:form action="helloWorld">
		<s:textfield name="message" label="Message"/>
		<!--nameȥ�����Ͳ����ύ��action����-->
		<s:submit />
	</s:form>
```

invocation.invoke()����֮ǰ�Ĵ��뽫��Actionִ��֮ǰִ��
invocation.invoke()����֮��Ĵ��뽫��Actionִ��֮��ִ�С�

���������ػ��ų��ķ���ʱ������ж����������ô�Զ��ţ����ָ�

PreResultListener�ӿ�

void beforeResult(ActionInvocation invocation, String resultCode)

resultCode��Actionִ�з��صĽ���롣
�����������Actionִ�к�Resultִ��ǰ�����á�

���� ��¼������

���� ����������
Struts2����ṩ�˺ܶ����������������Щ��������struts-default.xml�����ļ���ע�ᣬ������Ա����ֱ��ʹ�á�

- Token��������token��
ȷ��ÿ������ֻ��һ��token����������ȷ�����˰�ť��˫�������������𲻱�Ҫ�ĸ���Ӱ�졣 

����ظ��ύ

### Learn
//Function������Ҫ������ֵ�Ͳ���

Strutsһ��Action�࣬ʵ��һ������

### issues

Struts has detected an unhandled exception: 


Q:**Messages: No result defined for action **

**Solution**:
�鿴Action�еķ���ֵ result�� ��ͼ���Ƿ���ȷ