package com.jachs.jackson.entity;

import java.util.Date;

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
public class User {
	private String name;  
    private Integer age;  
    private Date birthday;  
    private String email;  
}
