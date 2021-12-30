package com.jachs.json.gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jachs.po.Init;
import com.jachs.po.garage.Car;
import com.jachs.po.school.School;

/***
 * 
 * @author zhanchaohan
 *
 */
public class GsonUtillTest {
	private static GsonUtill gsonUtill = new GsonUtill();
	private Gson pGson;

	String testFilePath = GsonUtillTest.class.getResource("").getPath();// 测试文件路径

	String carPwPath = testFilePath + File.separator + "carPw.txt";
	String carListPwPath = testFilePath + File.separator + "carListPw.txt";
	String schoolListPwPath = testFilePath + File.separator + "schoolListPw.txt";

	@Before
	public void init() throws FileNotFoundException {
		pGson = gsonUtill.setPrettyPrinting();
	}

	/***
	 * 对象转json测试,并持久化
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void test() throws FileNotFoundException {
		PrintWriter carPw = new PrintWriter(carPwPath);
		PrintWriter carListPw = new PrintWriter(carListPwPath);
		PrintWriter schoolListPw = new PrintWriter(schoolListPwPath);

		Init init = new Init();

		Car car = init.initCar();
		List<Car> carList = init.initCarList();
		School school = init.initSchool();

		System.out.println(pGson.toJson(car));
		System.out.println("----------------------------------------");
		System.out.println(pGson.toJson(carList));
		System.out.println("----------------------------------------");
		System.out.println(pGson.toJson(school));

		carPw.write(pGson.toJson(car));
		carListPw.write(pGson.toJson(carList));
		schoolListPw.write(pGson.toJson(school));

		carPw.close();
		carListPw.close();
		schoolListPw.close();
	}
	/***
	 * 读取物理文件再解析为对象
	 * @throws JsonSyntaxException
	 * @throws IOException
	 */
	@Test
	public void test1() throws JsonSyntaxException, IOException {
		Gson pGson = gsonUtill.setPrettyPrinting();

		BufferedReader carBr = new BufferedReader(new FileReader(carPwPath));
		BufferedReader carListBr = new BufferedReader(new FileReader(carListPwPath));
		BufferedReader schoolBr = new BufferedReader(new FileReader(schoolListPwPath));

		Car car = pGson.fromJson(getFileInfo(carBr).toString(), Car.class);
		List<Car> carList = pGson.fromJson(getFileInfo(carListBr).toString(), List.class);
		School school = pGson.fromJson(getFileInfo(schoolBr).toString(), School.class);
		
		
		System.out.println(pGson.toJson(car));
//		System.out.println("------------------------------");
//		System.out.println(pGson.toJson(carList));
		System.out.println("------------------------------");
//		System.out.println(pGson.toJson(school));
	}

	private StringBuffer getFileInfo(BufferedReader br) throws IOException {
		StringBuffer sb = new StringBuffer();
		while (br.ready()) {
			sb.append(br.readLine());
		}
		br.close();
		return sb;
	}
}
