package com.jachs.fastjson.entity.part1;

import java.util.List;
import java.util.Map;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Zoom {
	private String zoomKeeper;
	private List<Monkey>mokList;
	private Map<String,Wolf>wolfMap;
	
	public Zoom() {
		super();
	}
	public Zoom(String zoomKeeper, List<Monkey> mokList, Map<String, Wolf> wolfMap) {
		super();
		this.zoomKeeper = zoomKeeper;
		this.mokList = mokList;
		this.wolfMap = wolfMap;
	}
	public String getZoomKeeper() {
		return zoomKeeper;
	}
	public void setZoomKeeper(String zoomKeeper) {
		this.zoomKeeper = zoomKeeper;
	}
	public List<Monkey> getMokList() {
		return mokList;
	}
	public void setMokList(List<Monkey> mokList) {
		this.mokList = mokList;
	}
	public Map<String, Wolf> getWolfMap() {
		return wolfMap;
	}
	public void setWolfMap(Map<String, Wolf> wolfMap) {
		this.wolfMap = wolfMap;
	}
	
}
