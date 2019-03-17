Struts HelloWorld program:

1. 新建Web项目
2. 导入jar包
- 参考 apps—> struts2-blank.war中的jar包
3. 编写web.xml文件-配置struts的核心控制器
- 核心控制器在Libraries中的-->org.apache.struts2.dispatcher.ng.filter.StrutsExecuteFilter中
这个核心控制器是框架开始工作的入口，负责接管请求(tomcat接到用户的request，转到Struts)

![核心控制器](https://raw.githubusercontent.com/Jane-QinJ/NoteBook/master/Struts2/chapter1/images/img1.png)



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
上网查得知是struts.xml的位置问题： **struts.xml要在src下**

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

### chapter2:
1. 业务逻辑类，三种实现方式
2. 表达取数据，三种方式
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
