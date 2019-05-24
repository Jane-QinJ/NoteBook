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
**SqlSessionFactory** sessionFactory = new **SqlSessionFactoryBuilder**().build(reader);
		//创建能执行映射文件中sql的sqlSession
		**SqlSession** session = sessionFactory.openSession();
		
		//映射sql的标识字符串
		String statement = "com.rjxy.ex1.userMapper"+".getUser";
		//执行查询返回一个唯一user对象的sql
		User user = session.**selectOne**(statement, 1);
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
		int delete = session.insert(statement1, 6);
		System.out.println(delete);
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