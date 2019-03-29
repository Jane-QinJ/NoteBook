package sxau.rjxy;

import java.util.Map;

public class SchClass {
	
	private String className;
	private Map<String,String> classStudent;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Map<String, String> getClassStudent() {
		return classStudent;
	}
	public void setClassStudent(Map<String, String> classStudent) {
		this.classStudent = classStudent;
	}
	
	public SchClass(String name, Map<String,String> student) {
		this.className = name;
		this.classStudent = student;
	}

}
