package com.jachs.json.fastjson;

import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jachs.po.Init;
import com.jachs.po.garage.Car;
import com.jachs.po.school.School;

/***
 * 
 * @author zhanchaohan
 *
 */
public class FastJsonUtillTest {
	
	@Test
	public void test() throws JsonProcessingException {
		Init init = new Init();

		Car car = init.initCar();
		List<Car> carList = init.initCarList();
		School school = init.initSchool();
		
		
		JSONObject jo=new JSONObject();
		
		
		String json=jo.toJSONString(school, true);//对象转json
		System.out.println(json);
		System.out.println("----------------------------------------");
		System.out.println(new ObjectMapper().writeValueAsString(school));//反序列化输出
	}
}
