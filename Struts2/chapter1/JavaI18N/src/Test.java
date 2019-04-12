import java.util.Locale;
import java.util.ResourceBundle;

public class Test {
	public static void main(String[] args) {
		Locale locale = new Locale("zn","CN");
		ResourceBundle res = ResourceBundle.getBundle("MyResources",locale);
		//res.getString("");
		System.out.println(res.getString("msg"));
	}
}
