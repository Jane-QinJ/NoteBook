Struts HelloWorld program:

1. 新建Web项目
2. 导入jar包
- 参考 apps—> struts2-blank.war中的jar包
3. 编写web.xml文件-配置struts的核心控制器
- 核心控制器在Libraries中的-->org.apache.struts2.dispatcher.ng.filter.StrutsExecuteFilter中
这个核心控制器是框架开始工作的入口，负责接管请求(tomcat接到用户的request，转到Struts)



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

### Learn
- "aaa".equals(name)
如果反写 ： name.equals('aaa');
会出现空指针异常的情况， 变量值可能为空

- Struts将所有的请求（表单或者超链接）都转变为action，由Java类来处理它们
这个类会返回一个字符串，这个返回值和Struts.xml的result标签中name一致的话，就会返回目标jsp页面