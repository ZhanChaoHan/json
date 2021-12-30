package com.jachs.gson.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
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
	M_Class cls=new M_Class();
	
	@Before
	public void init() {
		RandomStringUtils rsu=new RandomStringUtils();
		cls.setTeacher("jachs");
		
		Set<Student>stuList=new HashSet<Student>();
		
		for (int kk = 0; kk < 20; kk++) {
			Student stu=new Student();
			stu.setsAge(kk);
			stu.setsName(rsu.random(5, "漲種趙罵黃霑網離還發纔嚄為"));
			stu.setsEmail(rsu.random(12, "ABHCVGGYGY@AJO.COMDUFH"));
			
			stuList.add(stu);
		}
		cls.setStuList(stuList);
	}
	
	@Test
	public void test1() throws IOException {
		Gson gson=new Gson();
		
		String str=gson.toJson(cls);
		
		Writer wr=new FileWriter(PATH);
		wr.write(str);
		wr.close();
	}
}
