package com.jachs.fastjson.entity.part1;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Wolf {
	private String name;
	private boolean isMen;
	
	public Wolf() {
		super();
	}
	public Wolf(String name, boolean isMen) {
		super();
		this.name = name;
		this.isMen = isMen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMen() {
		return isMen;
	}
	public void setMen(boolean isMen) {
		this.isMen = isMen;
	}
	
}
