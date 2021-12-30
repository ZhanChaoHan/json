package com.jachs.fastjson.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.jachs.fastjson.entity.part1.Monkey;
import com.jachs.fastjson.entity.part1.Wolf;
import com.jachs.fastjson.entity.part1.Zoom;

/***
 * 
 * @author zhanchaohan
 *
 */
public class T_1 {
	private static final String PATH=T_1.class.getResource("/").getPath()+File.separator+"T1.json";
	Zoom zoom=new Zoom();
	
	@Before
	public void init() {
		RandomStringUtils rsu=new RandomStringUtils();
		List<Monkey>monList=new ArrayList<Monkey>();
		Map<String,Wolf>wMap=new HashMap<String, Wolf>();
		
		for (int kk = 0; kk < 20; kk++) {
			Monkey mKey=new Monkey(rsu.random(5, "吉吉國王,毛毛"), rsu.random(5, "rea,blue"));
			monList.add(mKey);
		}
		for (int kk = 0; kk < 15; kk++) {
			wMap.put(rsu.random(5, "大灰狼，小綿羊，笑哈哈"), new Wolf(rsu.random(5, "紅毛怪，白毛怪，綠毛怪"), kk%2==0));
		}
		zoom.setZoomKeeper("jachs.curator");
		zoom.setMokList(monList);
		zoom.setWolfMap(wMap);
	}
	@Test
	public void test1() throws IOException {
		Writer writer=new FileWriter(PATH);
		
		JSONObject jObj=new JSONObject();
		
		String json=jObj.toJSON(zoom).toString();
		
		writer.write(json);
		
		writer.close();
	}
}
