## Ex 1
cmd命令：
打开注册表
ctrl + D -> regedit

管理服务：
右键我的电脑->管理->服务和应用程序->服务

### 传统数据库连接：
[Reference:JDBC入门及简单增删改数据库的操作](https://www.cnblogs.com/qianguyihao/p/4050825.html)

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
set global time_zone = ‘+8:00‘; ##修改mysql全局时区为北京时间，即我们所在的东8区
set time_zone = ‘+8:00‘; ##修改当前会话时区
flush privileges; #立即生效
```

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