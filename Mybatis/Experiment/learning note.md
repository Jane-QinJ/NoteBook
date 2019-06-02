## Ex 1
cmd命令：
打开注册表
ctrl + D -> regedit

管理服务：
右键我的电脑->管理->服务和应用程序->服务

### 传统数据库连接：
[Reference:JDBC入门及简单增删改数据库的操作](https://www.cnblogs.com/qianguyihao/p/4050825.html)

### Mybatis数据库连接
1. 添加jar包
- 【mybatis】
	mybatis-3.1.1.jar
- 【MYSQL驱动包】
    mysql-connector-java-5.1.7-bin.jar

2. 创建数据库+表

```
create database mybatis;
use mybatis;
CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT);
INSERT INTO users(NAME, age) VALUES('Tom', 12);
INSERT INTO users(NAME, age) VALUES('Jack', 11);
```

3. 添加Mybatis的配置文件conf.xml

**注意**： 
- conf.xml名称可随便起，之后加载时和它一致即可
- conf.xml配置文件要在src文件下

```
String resource = "conf.xml"; 
		//加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource); 
```


**conf.xml**

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<environments default="development">
		<environment id="development">
			<transactionManager type="JDBC" />
			<dataSource type="POOLED">
				<property name="driver"                        value="com.mysql.jdbc.Driver" />
				<!--数据库连接地址-->
				<property name="url" value="jdbc:mysql://localhost:3306/mybatis" />  
				<!--数据库连接用户名-->
				<property name="username" value="root" />
				<!--数据库连接密码-->
				<property name="password" value="root" />
			</dataSource>
		</environment>
	</environments>
</configuration>
```


4. 定义表所对应的实体类
```
public class User {
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "[id:"+id +"] [Name:"+name+"] [age:" + age + "]";
	}
	
}
```


5. 定义操作users表的sql映射文件userMapper.xml

```
<!-- namespace可自定义，但规范是包名+类名  -->
<mapper namespace="com.rjxy.ex1.userMapper"> 
	<select id="getUser" parameterType="int" 
		resultType="com.rjxy.ex1.User">
		select * from users where id=#{id}
	</select>
</mapper>
```

|标签|属性|含义|
|---|---|---|
|mapper|namespace|定位这条mapper|

|子标签|属性|含义|
|---|---|---|
|select|id|唯一定位这条select标签|
|insert    |parameterType|传入参数类型|
|delete |resultType|返回值类型|
|update||

**Attention**:
- 这里的namespace 和 select语句中的 id 可以自定义，目的是准确定位这一条SQL语句的位置
- namespace可自定义，但规范是包名+类名 
-  id=#{id} : '#'是占位符，之后可以传入参数

```
//映射sql的标识字符串
		String statement = "com.rjxy.ex1.userMapper"+".getUser";
//执行查询返回一个唯一user对象的sql
		User user = session.selectOne(statement, 1);
```
如这个表示传入了参数 1

所以最终的SQL语句为：

```
select * from users where id = 1
```


6. 在conf.xml文件中注册userMapper.xml文件

```
<mappers>
<!-- 		相对路径为src/ -->
		<mapper resource="com/rjxy/ex1/userMapper.xml"/>
	</mappers>
```

**Attention**:
- 这里的路径为src下的相对路径，所以从包名开始+xml文件名

> 路径的设置目的都为使计算机找到对应的文件所在的地址


7. 编写测试代码：执行定义的select语句

```
public class Test {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml"; 
		//加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource); 
		//构建sqlSession的工厂	
SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		
		//映射sql的标识字符串
		String statement = "com.rjxy.ex1.userMapper"+".getUser";
		//执行查询返回一个唯一user对象的sql
		User user = session.selectOne(statement, 1);
		System.out.println(user);
	}
}
```

### issues

1. **java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '1' for key 'PRIMARY'**

错误原因：*Duplicate entry 1* 多重输入1

```
id INT PRIMARY KEY AUTO_INCREMENT
```

**Solution**
因为id字段为主键，不允许重复。而表中已经有id为1的数据，所以将id改为不为1即可。


2. **The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one time zone**

**Solution**
时区问题，只需更改时区即可
[Reference](http://www.cnblogs.com/wangdianqian/p/9927406.html)

```
mysql -uroot -p
pw:123456

set global time_zone = ‘+8:00‘; ##修改mysql全局时区为北京时间，即我们所在的东8区
set time_zone = ‘+8:00‘; ##修改当前会话时区
flush privileges; #立即生效
```


3. **Caused by: java.lang.IllegalArgumentException: Mapped Statements collection does not contain value**

```
public class Test {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml"; 
		//加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource); 
		//构建sqlSession的工厂	
SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		
		//映射sql的标识字符串
		String statement = "com.rjxy.ex1.userMapper"+".getUser";
		//执行查询返回一个唯一user对象的sql
		User user = session.selectOne(statement, 1);
		System.out.println(user);
	}
}
```

*String statement = "com.rjxy.ex1.userMapper"+".getUser";*

这个值要和userMapper中namespace值和select SQL语句的 id 相同，才能准确找到sql映射文件中的某个sql语句。

selectOnt("String",1)
String: userMapper中的namespace和 id
int: 传入的参数值

**userMapper.xml**

```
<!-- namespace可自定义，但规范是包名+类名  -->
<mapper namespace="com.rjxy.ex1.userMapper"> 
<!-- 	parameterType:传入参数类型 -->
<!-- 	resultType：返回值类型 -->
	<select id="getUser" parameterType="int" 
		resultType="com.rjxy.ex1.User">
		select * from users where id=#{id}
	</select>
</mapper>
```

parameterType:传入参数类型 
resultType：返回值类型 

### To be solved:
-[ ] 添加DTD文档

### JDBC应用步骤
1. 注册加载一个驱动
2. 创建数据库连接（Connection）
3. 构造SQL语句
4. 创建statement，发送sql语句
5. 执行sql语句
6. 处理sql结果(查询select需要处理)
7. 关闭statement和connection 

### createStatement方法
- createStatement
Statement createStatement()
                   throws SQLException

Creates a Statement object for sendingSQL statements to the database.SQL statements without parameters are normallyexecuted using Statement objects. If the same SQL statementis executed many times, it may be more efficient to use a PreparedStatement object. 

创建一个statement对象用于给数据库传送SQL语句。
没有参数的SQL语句通常使用Statement对象。
如果相同的SQL语句执行多次，使用PreparedStatement对象会更有效。

Result sets created using the returned Statementobject will by default be type TYPE_FORWARD_ONLYand have a concurrency level of CONCUR_READ_ONLY.The holdability of the created result sets can be determined bycalling getHoldability().
Returns:a new default Statement objectThrows:SQLException - if a database access error occursor this method is called on a closed connection

### ResultSet接口实现查询操作：

步骤如下：（和上一篇博文中的增删改的步骤类似哦）

1. 加载数据库驱动程序：

Class.forName(驱动程序类)

2. 通过用户名密码和连接地址获取数据库连接对象：

DriverManager.getConnection(连接地址,用户名,密码)

3. 构造查询SQL语句

4. 创建Statement实例：

Statement stmt = conn.createStatement()

5. 执行查询SQL语句，并返回结果：

ResultSet rs = stmt.executeQuery(sql)

6. 处理结果

7. 关闭连接：

rs.close()、stmt.close()、conn.close()

## Ex 2 操作users表的CRUD
1). 定义sql映射xml文件：
之前的几步可以省略：导包、建表建库、定义实体类、创建conf.xml

在同一工程下，创建一个新的包com.rjxy.ex2

|功能|SQL语句|
|---|---|
|增|insert into 表名 values 字段值;|
|删|delete from 表名 where 条件；
|改|update 表名 set 字段=新字段值 where 条件；
|查|select 字段值 from 表名 where 条件；

userMapper.xml
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- namespace可自定义，但规范是包名+类名  -->
<mapper namespace="com.rjxy.ex2.userMapper"> 
	<insert id="insertUser" parameterType="com.rjxy.ex1.User">
	insert into users(name, age) values(#{name}, #{age});
	</insert>
	
	<delete id="deleteUser" parameterType="int">
		delete from users where id=#{id}
	</delete>
	
	<update id="updateUser" parameterType="com.rjxy.ex1.User">
		update users set name=#{name},age=#{age} where id=#{id}
	</update>
	
	<select id="selectUser" parameterType="int"
		resultType="com.rjxy.ex1.User">
		select * from users where id=#{id}	
	</select>
	
	<select id="selectAllUsers" resultType="com.rjxy.ex1.User">
		select * from users
	</select>
</mapper>
```

2). 在config.xml中注册这个映射文件

```
	<mapper resource="com/rjxy/ex2/userMapper.xml"/>
```

3). 测试CRUD

将常用的方法封装为一个类方法

MybatisUtils.java

```
public class MybatisUtils {
	public static SqlSessionFactory getFactory() {
		String resource = "conf.xml";
		InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}
}
```

JUnit测试：(点击要测试的方法名，右键run as JUnit)
```
public class Test1 {
	@Test
	public void testAdd() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		//可以将factory.openSession(true);重载
		SqlSession session = factory.openSession();
		
		String statement = "com.rjxy.ex2.userMapper.insertUser";
		int insert = session.insert(statement, new User(-1,"Jane",21));	
		
		//提交
		session.commit();
		session.close();
		
		System.out.println(insert);

	}
	
	@Test
	public void testDelete() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		//可以将factory.openSession(true);重载
		SqlSession session = factory.openSession(true);
		String statement1 = "com.rjxy.ex2.userMapper.deleteUser";
		int delete = session.delete(statement1, 6);
		System.out.println(delete);
	}
	
	@Test
	public void testUpdate(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession(true);
		String statementUpdate = “com.rjxy.ex2.userMapper.updateUser”;
		int update = session.update(statementUpdate ,new User(4,”KK444”,25);
	}
	
	@Test
	public void testSelect() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		//可以将factory.openSession(true);重载
		SqlSession session = factory.openSession(true);
		String statement2 = "com.rjxy.ex2.userMapper.selectUser";
		User user = session.selectOne(statement2, 1);
		System.out.println(user);
	}
	
	@Test
	public void testSelectAll() {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		//默认是手动提交的
		//可以将factory.openSession(true);重载
		SqlSession session = factory.openSession(true);
		String statement3 = "com.rjxy.ex2.userMapper.selectAllUsers";
		List<User> list = session.selectList(statement3);
		session.close();
		System.out.println(list);
	}
}
```
### 优化
4.1. 连接数据库的配置单独放在一个properties文件中

db.properties(src下)

```
driver= com.mysql.cj.jdbc.Driver
url= jdbc:mysql://localhost:3306/mybatis
username=root
password=123456
```

将db.properties导入到conf.xml中

```
<configuration>

	<properties resource="db.properties"/>
 
	<property name="driver" value="${driver}" />
	<property name="url" value="${url}" />
	<property name="username" value="${username}" />
	<property name="password" value="${password}" />
</configuration>
```

4.2. 为实体类定义别名,简化sql映射xml文件中的引用
conf.xml
放在configuration标签下

```
<typeAliases>
		<typeAlias type="com.rjxy.ex1.User" alias="User"></typeAlias>
	
	</typeAliases>
```

每次写全类名太繁琐，用别名代替

```
	<package name="com.rjxy.ex1"></package>
```

4.3. 可以在src下加入log4j的配置文件,打印日志信息
1. 添加jar: 
	log4j-1.2.16.jar 

2.1. log4j.properties(方式一) （放到src下）
2.2. log4j.xml(方式二)（放到src下）

## Ex3 解决字段名与实体类属性名不相同的冲突

之前的几步可以省略：1.导包

2.建表建库

注意数据库的字段名 和 javabean不同
```
CREATE TABLE orders(
	order_id INT PRIMARY KEY AUTO_INCREMENT,
	order_no VARCHAR(20), 
	order_price FLOAT
);
INSERT INTO orders(order_no, order_price) VALUES('aaaa', 23);
INSERT INTO orders(order_no, order_price) VALUES('bbbb', 33);
INSERT INTO orders(order_no, order_price) VALUES('cccc', 22);

```
3.定义实体类

**注意：数据库表字段和实体类属性名不一致。**

```
public class Order {
	private int id;
	private String orderNo;
	private float price;
}

```

4.创建conf.xml

1) 定义sql映射xml文件：


orderMapper.xml
```
<mapper namespace = "com.rjxy.ex3.orderMapper">
	<!-- private int id; -->
<!-- 	private String orderNo; -->
<!-- 	private float price; -->
	<select id="getOrder" parameterType="int" resultType="Order">
		select * from orders where order_id = #{id}
	</select>

</mapper>
```

2)注册
conf.xml

```
<!--mapper的路径名-->
<mapper resource = "com/rjxy/ex3/orderMapper.xml"/>
```

3)编写测试类

OrderTest.java

```
public class OrderTest{
	@Test
	public void getOrder(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();

		String statement = "com.rjxy.ex3.orderMapper.getOrder";
		Order order = session.selectOne(statement,2);
		System.out.println(order);
	}
}
```

运行结果为null，原因是属性名和字段名不一致

### 解决方法
- 1)可以取别名，和属性一一对应

```
select order_id id, order_no orderNo, order_price price from orders where order_id = #{id}
```

- 2)通过resultMap键值对取别名

resultMap:封装一些映射关系
     id:针对主键
     result：针对一般字段

|标签      | 属性   | 含义|
| --------   | -----  | ---  |
|resultMap | type  | 要定义别名的实体类|
|          | id    | 和select标签中的resultMap相同|


|子标签   | 属性 | 含义|
|---|---|---|
|id      |property| id为主键， java类属性|
|        |column  | 数据库字段|
|result  |property | result为普通字段， Java类属性|
|		|column   | 数据库字段|

```
<select id = "getOrder" parameterType="int" resultType="Order"
	resultMap = "orderResultMap">
	select * from orders where order_id=#{id}
</select>

<resultMap type="Order" id="orderResultMap">
	<!--id为主键
		property:java类属性
		column:数据库字段
		-->
	<id property="id" column="order_id"/>
	<result property="orderNo" column="order_no"/>
	<result property="price" column="order_proce"/>
</resultMap>
```
## Ex4 实现关联表查询
6.1. 一对一关联
1). 提出需求
根据班级id查询班级信息
(带老师的信息)

一个教师只带一个班
一个班只有一个老师
根据班级id查询班级信息(带老师的信息)

教师表

```
CREATE TABLE teacher(
	t_id INT PRIMARY KEY AUTO_INCREMENT, 
	t_name VARCHAR(20)
);
```

班级表

```
CREATE TABLE class(
	c_id INT PRIMARY KEY AUTO_INCREMENT, 
	c_name VARCHAR(20), 
	teacher_id INT
);
```
2). 创建表和数据

给class这个表的teacher_id字段加一个外键约束，名字叫fk_teacher_id ，依赖于teacher表的t_id字段

```
ALTER TABLE class ADD CONSTRAINT fk_teacher_id FOREIGN KEY (teacher_id) REFERENCES teacher(t_id);	
 
INSERT INTO teacher(t_name) VALUES('LS1');
INSERT INTO teacher(t_name) VALUES('LS2');
 
INSERT INTO class(c_name, teacher_id) VALUES('bj_a', 1);
INSERT INTO class(c_name, teacher_id) VALUES('bj_b', 2);

```

3). 定义实体类

注意:Classes类中有Teacher对象这样才能找到教师名

```
public class Teacher {
	private int id;
	private String name;
}
public class Classes {
	private int id;
	private String name;
	private Teacher teacher;
}
```

- 方式一：嵌套结果（联表查询》
  使用嵌套结果映射来处理重复的联合结果的子集封装联表查询的数据(去除重复的数据)

```
select * from class c, teacher t where c.teacher_id=t.t_id and  c.c_id=1
```

classMapper.xml

```
<mapper namespace="com.rjxy.ex4.classMapper">
	<select id="getClass" parameterType="int" resultMap="ClassResultMap">
		select * from class c, teacher t where c.teacher_id = t.t_id and c.c_id= #{id}
	</select>

	<resultMap type="Classes" id="ClassResultMap">
		<id property="id" column="c_id"/>
		<result property="name" column="c_name"/>

		<association property="teacher" javaType="Teacher">
			<id property="id" column="t_id"/>
			<result property="name" column="t_name"/>
		</association>
	</resultMap> 
</mapper>
```
注册：

```
<mapper resource="com/rjxy/ex4/classMapper.xml"/>
```

编写测试类(测试类不能名为Test，会和junit冲突）：

```
public class Test5{
	@Test
	public void getClasses(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();

		String statement = "com.rjxy.ex4.classMapper.getClass";

		Classes c = session.selectOne(statement,2);
		System.out.println(c);

		session.close();
	}
}
```
- 方式二：嵌套查询 执行两次查询
方式二：嵌套查询：通过执行另外一个SQL映射语句来返回预期的复杂类型
	SELECT * FROM class WHERE c_id=1;
	SELECT * FROM teacher WHERE t_id=1   //1 是上一个查询得到的teacher_id的值

```
<select id="getClass2" parameterType="int" resultMap="ClassResultMap2">
	select*from class where c_id=#{id}
</select>

<resultMap type="Classes" id="ClassResultMap2">
	<id property="id" column="c_id"/>
	<result property="name" column ="c_name"/>
	
	<association property="teacher" column="teacher_id" select="getTeacher">
	</association>

</resultMap>

<select id="getTeacher" parameterType="int" resultType="Teacher">
	select t_id id, t_name name from teacher where t_id = #{id}
</select>
```

测试类：

## Ex5 一对多关联
1). 提出需求
    根据classId查询对应的班级信息,包括学生,老师

2). 创建表和数据
新建一个学生表，class_id表示班级id，一个班级有多个学生

```
CREATE TABLE student(
	s_id INT PRIMARY KEY AUTO_INCREMENT, 
	s_name VARCHAR(20), 
	class_id INT
);

INSERT INTO student(s_name, class_id) VALUES('xs_A', 1);
INSERT INTO student(s_name, class_id) VALUES('xs_B', 1);
INSERT INTO student(s_name, class_id) VALUES('xs_C', 1);
INSERT INTO student(s_name, class_id) VALUES('xs_D', 2);
INSERT INTO student(s_name, class_id) VALUES('xs_E', 2);
INSERT INTO student(s_name, class_id) VALUES('xs_F', 2);
```
3). 定义实体类：

```
public class Student {
	private int id;
	private String name;
}
 
public class Classes {
	private int id;
	private String name;
	private Teacher teacher;
	private List<Student> students;
} 


```

4) 注册

```
<mapper resource="com/rjxy/ex5/classMapper.xml"/>
```

5) classMapper.xml

- 1. 联表查询
```
<select id="getClass" parameterType="int" resultMap="getClassMap">
	select * from class c, student s where c.c_id = s.class_id and c.c_id=#{id}
</select>

<resultMap id="getClassMap" type="Classes">
	<id property="id" column="c_id"/>
	<result property="name" column="c_name"/>
	<collection property="students" ofType="Student">
		<id property="id" column="s_id"/>
		<result property="name" column="s_name"/>
	</collection>
</resultMap>
```
测试类：
Test6.java

public class Test6{
	@Test
	public void getClasses(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();

		String statement = "com.rjxy.ex5.classMapper.getClass";

		Classes c = session.selectOne(statement,2);
		System.out.println(c);

		session.close();
}
}

- 2. 嵌套查询
