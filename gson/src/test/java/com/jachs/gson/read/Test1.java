package com.jachs.gson.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Test;

import com.google.gson.Gson;
import com.jachs.gson.entity.part1.M_Class;
import com.jachs.gson.entity.part1.Student;


/***
 * 
 * @author zhanchaohan
 *
 */
public class Test1 {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"T1.json";
	
	@Test
	public void test1() throws IOException {
		Reader read=new FileReader(PATH);
		
		BufferedReader br=new BufferedReader(read);
		
		String json= br.readLine();
		
		Gson gson=new Gson();
		M_Class mCls=gson.fromJson(json, M_Class.class);
		
		System.out.println(mCls.getTeacher());
		
		for (Student stu : mCls.getStuList()) {
			System.out.println(stu.getsName()+"\t"+stu.getsEmail()+"\t"+stu.getsAge());
		}
		
		br.close();
	}
}
