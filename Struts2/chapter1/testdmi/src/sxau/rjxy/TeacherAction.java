package sxau.rjxy;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport{
	/*
	 * 动态方法调用
	 * 在配置文件中增加<constant>配置
	 */
	public String add() {
		return "addTeachersuccess";
	}
	public String delete() {
		return "deleteTeachersuccess";
	}
}
