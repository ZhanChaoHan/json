package com.jachs.jackson;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jachs.jackson.entity.UserAnn;

/***
 * 
 * @author zhanchaohan
 *
 */
public class UserAnnTest {
	//对象转json
	@Test
	public void test1() throws ParseException, JsonProcessingException {
		UserAnn user = new UserAnn();  
        user.setName("会唱歌的鸟");   
        user.setEmail("gugubird@163.com");  
        user.setAge(20);
          
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");  
        user.setBirthday(dateformat.parse("1996-10-01"));         
          
        ObjectMapper mapper = new ObjectMapper();  
        String json = mapper.writeValueAsString(user);  
        System.out.println(json);
	}
}
