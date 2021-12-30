package com.jachs.gson.entity.part1;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Student {
	private String sName;
	private String sEmail;
	private int sAge;
	
	
	public Student() {
		super();
	}
	public Student(String sName, String sEmail, int sAge) {
		super();
		this.sName = sName;
		this.sEmail = sEmail;
		this.sAge = sAge;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	
}
