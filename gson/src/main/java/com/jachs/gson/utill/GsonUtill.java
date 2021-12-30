package com.jachs.gson.utill;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/***
 * 
 * @author zhanchaohan
 *
 */
public class GsonUtill {
	Gson gson=new Gson();
	
	/***
	 * 自带的json格式化输出
	 * @return
	 */
	public Gson setPrettyPrinting() {
		return new GsonBuilder()
		        .setPrettyPrinting()
		        .create();
	}
	/***
	 * 对象转json
	 * @param obj 对象
	 * @return json
	 */
	public String PoToJson(Object obj) {
		return gson.toJson(obj);
	}
}
