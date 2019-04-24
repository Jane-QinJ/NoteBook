package converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import domain.Point;

public class PointConverter extends StrutsTypeConverter{
//表单中的数据在这个方法中被转换，返回值是目标对象
	
	/*
	 * Map context:用于指定执行转换的上下文
	 * Object value:用于指定将被转换的值
	 * Class toType:用于指定值被转换到的类型
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// TODO Auto-generated method stub
		System.out.println("将String转换为指定的类型");
		String value = values[0];
		Point point = new Point();
		//(3,4)
		//x:第二个开始，到逗号结束
		/*
		 *1. substring: 
		 * Returns a string that is a substring of this string. 
		 * The substring begins at the specified beginIndex andextends to the character at index endIndex - 1.
		 * Thus the length of the substring is endIndex-beginIndex.
		 * 返回指定下标的子串
		 * 2. indexof(str):
		 * Returns the index within this string of the first occurrence of the specified substring. 
		 * 返回指定子串第一次出现的下标
		 */ 
		
		point.setX(Integer.parseInt(value.substring(1, value.indexOf(","))));
		point.setY(Integer.parseInt(value.substring(value.indexOf(","), value.length()-1)));
		return point;
	}
	//使用ognl表达式获取值时会调用该方法
	@Override
	public String convertToString(Map content, Object obj) {
		// TODO Auto-generated method stub
		System.out.println("将指定的类型转换为String");
		Point p = (Point)obj;
		return p.toString();
	}

}
