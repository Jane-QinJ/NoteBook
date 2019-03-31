package com.util.db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/*
 * 封装工具类就是一个抽象的过程，我们可以把现在代码中非常公用的代码抽取出来，形成一个工具类。
第一步：抽象公共的代码到工具类。
第二步：为提高可以连接不同数据库的能力，将连接数据库的URL、用户名，密码等信息编写在一个属性文件（jdbc.properties）中，方便以后进行修改。
 */
/**
 * 数据库操作工具类
 * @author 秦佳
 *
 */
public class DBUtils {
	//数据库链接地址
	public static String URL;
	//用户名
	public static String USERNAME;
	//密码
	public static String PASSWORD;
	//mysql的驱动类
	public static String DRIVER;
	//很明显可以看到，我们是将连接数据库的URL、用户名，密码等信息编写在一个属性文件（jdbc.properties）中，稍后再来定义这个属性文件
	private static ResourceBundle rb = ResourceBundle.getBundle("db-config");
	
	//既然是工具类，一般不要实例化，此时可以采用单例设计模式，或者将构造方法私有化
	private DBUtils() {}
	//为避免重复代码，使用静态代码块：只会在类加载的时候执行一次。
		//使用静态块加载驱动程序
		static {
			URL = rb.getString("jdbc.url");
			USERNAME = rb.getString("jdbc.username");
			PASSWORD = rb.getString("jdbc.password");
			DRIVER = rb.getString("jdbc.driver");
			try {
				Class.forName(DRIVER);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		//定义一个获取数据库连接的方法
		public static Connection getConnection() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("获取连接失败");
			}
			return conn;
		}
		/**
		 * 关闭数据库连接
		 * @param rs
		 * @param stat
		 * @param conn
		 */
		public static void close(ResultSet rs, Statement stat,Connection conn) {
			try {
				if(rs!=null) rs.close();
				if(stat!=null) stat.close();
				if(conn!=null) conn.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	