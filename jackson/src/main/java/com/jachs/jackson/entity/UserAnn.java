package com.jachs.jackson.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 
 * @author zhanchaohan
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAnn {
	//不JSON序列化年龄属性  
    @JsonIgnore   
    private Integer age;  
    @JsonProperty("name")
	private String name;
	//格式化日期属性  
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date birthday;
    @JsonProperty("mail")
    private String email;  
}
