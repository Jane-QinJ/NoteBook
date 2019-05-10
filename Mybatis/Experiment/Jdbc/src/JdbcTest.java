import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 1.注册加载一个驱动
2.创建数据库连接（Connection）
3.构造SQL语句
4.创建statement，发送sql语句
5.执行sql语句
6.处理sql结果
7.关闭statement和connection 
 * @author 秦佳
 *
 */
public class JdbcTest {
	//数据库连接地址
	private final static String URL = "jdbc:mysql://localhost:3306/mybatis";
	//用户名
	public final static String USERNAME = "root";
	//密码
	public final static String PASSWORD = "123456";
	//加载驱动类
	public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	public static void main(String[] args) {
		delete();
	}
	//1. 插入数据 insert
	public static void insert() {
		try {
			//1.加载数据库驱动程序
			Class.forName(DRIVER);
			
			//2.获取数据库连接
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//3.构造Sql语句
			String sql = "insert into users(id,name,age) values (3,'Jane',20)"; //id是自增的，所以随便输入
			
			//4.构造一个Statement实例（用来发送SQL语句的载体)
			Statement state = connection.createStatement();
			
			//5.执行SQL语句（向数据库中发送sql语句）
			state.executeUpdate(sql);
			
			//6.关闭连接（释放资源）
			state.close();
			connection.close();
			System.out.println("insert success");
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//2. 更新数据 update
	public static void update() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "update users set name='JaneQin' where id = 3";
			Statement state = connection.createStatement();
			state.executeUpdate(sql);
			state.close();
			connection.close();
			System.out.println("update success");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//3.删除 delete
	public static void delete() {
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "delete from users where id = 1";
			Statement state = connection.createStatement();
			state.executeUpdate(sql);
			state.close();
			connection.close();
			System.out.println("delete success");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
