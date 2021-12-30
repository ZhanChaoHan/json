package com.jachs.gson.entity.part1;

import java.util.Set;

/***
 * 
 * @author zhanchaohan
 *
 */
public class M_Class {
	private String teacher;
	private Set<Student>stuList;
	
	public M_Class() {
		super();
	}
	public M_Class(String teacher, Set<Student> stuList) {
		super();
		this.teacher = teacher;
		this.stuList = stuList;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public Set<Student> getStuList() {
		return stuList;
	}
	public void setStuList(Set<Student> stuList) {
		this.stuList = stuList;
	}
	
}
