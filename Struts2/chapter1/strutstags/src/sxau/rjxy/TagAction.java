package sxau.rjxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TagAction extends ActionSupport implements SessionAware{
	private Map<String,Object> mSession;
	private List<SchClass> classes = new ArrayList<>();

	/*Action中写属性，注意要有set(接受数据)  get(取出数据) 方法*/
	public List<SchClass> getClasses() {
		return classes;
	}

	
	
	public void init() {
		/*学生的姓名和性别用Map映射键值*/
		Map<String,String> cStudent1 = new HashMap<String,String>();
		cStudent1.put("stuName", "zs");
		cStudent1.put("stuSex", "女");
		Map<String,String> cStudent2 = new HashMap<String, String>();
		cStudent2.put("stuName", "linyi");
		cStudent2.put("stuSex", "女");
		Map<String,String> cStudent3 = new HashMap<String,String>();
		cStudent3.put("stuName", "wuyi");
		cStudent3.put("stuSex", "男");
		
		/*classes用ArrayList装起来*/
		SchClass class1 = new SchClass("09 计本 1",cStudent1);
		SchClass class2 = new SchClass("09 计本 2",cStudent2);
		SchClass class3 = new SchClass("09 计本 3",cStudent3);
		classes.add(class1);
		classes.add(class2);
		classes.add(class3);
	}
	
	
	public String execute() {
		init();
		mSession.put("ClassName", classes.get(0).getClassName());
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.mSession = session;
	}
}
