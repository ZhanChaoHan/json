package com.jachs.jackson;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jachs.jackson.entity.Friend;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ObjectMapperTest {
	@Test
	public void test1() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Friend friend = new Friend("yitian", 25);

		// 写为字符串
		String text = mapper.writeValueAsString(friend);
		// 写为文件
		mapper.writeValue(new File("friend.json"), friend);
		// 写为字节流
		byte[] bytes = mapper.writeValueAsBytes(friend);
		System.out.println(text);
		// 从字符串中读取
		Friend newFriend = mapper.readValue(text, Friend.class);
		// 从字节流中读取
		newFriend = mapper.readValue(bytes, Friend.class);
		// 从文件中读取
		newFriend = mapper.readValue(new File("friend.json"), Friend.class);
		System.out.println(newFriend);
	}
	@Test
	public void test2() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("age", 25);
        map.put("name", "yitian");
        map.put("interests", new String[]{"pc games", "music"});

        String text = mapper.writeValueAsString(map);
        System.out.println(text);

        Map<String, Object> map2 = mapper.readValue(text, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(map2);

        JsonNode root = mapper.readTree(text);
        String name = root.get("name").asText();
        int age = root.get("age").asInt();

        System.out.println("name:" + name + " age:" + age);
	}
	@Test
	public void test3() {
		ObjectMapper mapper = new ObjectMapper();
		// 美化输出
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		// 允许序列化空的POJO类
		// （否则会抛出异常）
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		// 把java.util.Date, Calendar输出为数字（时间戳）
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		// 在遇到未知属性的时候不抛出异常
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// 强制JSON 空字符串("")转换为null对象值:
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

		// 在JSON中允许C/C++ 样式的注释(非标准，默认禁用)
		mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		// 允许没有引号的字段名（非标准）
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		// 允许单引号（非标准）
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		// 强制转义非ASCII字符
		mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
		// 将内容包裹为一个JSON属性，属性名由@JsonRootName注解指定
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
	}
}
