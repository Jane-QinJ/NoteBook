package com.rjxy.bean;

import java.util.List;

public class Classes {
	private int id;
	private String name;
	private Teacher teacher;
	
	private List<Student> students;
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Classes(int id, String name, Teacher teacher, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", teacher=" + teacher + ", toString()=" + super.toString()
				+ "]";
	}
	
}
