package com.jachs.fastjson.entity.part1;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Monkey {
	private String name;
	private String color;
	
	public Monkey() {
		super();
	}
	public Monkey(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
