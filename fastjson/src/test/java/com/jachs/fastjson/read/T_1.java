package com.jachs.fastjson.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.jachs.fastjson.entity.part1.Monkey;
import com.jachs.fastjson.entity.part1.Zoom;

/***
 * 
 * @author zhanchaohan
 *@see com.jachs.fastjson.writer.T_1
 */
public class T_1 {
	private static final String PATH=T_1.class.getResource("/").getPath()+File.separator+"T1.json";
	
	private StringBuffer sb=new StringBuffer();
	
	@Before
	public void init() throws Exception {
		BufferedReader br=new BufferedReader(new FileReader(PATH));
		while(br.ready()) {
			sb.append(br.readLine());
		}
		br.close();
	}
	@Test
	public void test1() {
		Zoom zoom=JSONObject.parseObject(sb.toString(),Zoom.class);
		
		System.out.println(zoom.getZoomKeeper());
		for (Monkey mk : zoom.getMokList()) {
			System.out.println(mk.getName()+"\t"+mk.getColor());
		}
		System.out.println("------------line----------------");
		for (String key : zoom.getWolfMap().keySet()) {
			System.out.println(key+"\t"+zoom.getWolfMap().get(key).getName());
		}
	}
}
