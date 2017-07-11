package test.jsonTest;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class TestJson {
	
	public static void main(String[] args){
		//设置result的数据，包括一个int数据和一个Person对象的集合
		Result result = new Result();
		result.setResult(1);
		List<Person> listPersons = new ArrayList<Person>();
		
		//设置result类中的第一个Person对象，包括name，age，url和一个SchoolInfo对象的集合
		Person person1 = new Person();
		person1.setName("Tom Green");
		person1.setAge(22);
		person1.setUrl("https://img.alicdn.com/imgextra/i2/2578685019/TB21XA7iXXXXXbxXpXXXXXXXXXX_!!2578685019.jpg");

		//设置Person类中的SchoolInfo，包括一个scholl_name
		List<SchoolInfo> listSchoolInfo1 = new ArrayList<SchoolInfo>();
		
		SchoolInfo schoolInfo1 = new SchoolInfo();
		schoolInfo1.setSchool_name("Cambridge");
		
		SchoolInfo schoolInfo2 = new SchoolInfo();
		schoolInfo2.setSchool_name("Oxford");
		
		listSchoolInfo1.add(schoolInfo1);
		listSchoolInfo1.add(schoolInfo2);
		
		//将SchoolInfo的对象集合添加到Person中
		person1.setSchoolInfo(listSchoolInfo1);	
		
		//设置Person类中的第二个Person对象，包含name，age，url和一个SchoolInfo对象的集合
		Person person2 = new Person();
		person2.setName("Bill Gates");
		person2.setAge(66);
		person2.setUrl("https://img.alicdn.com/tps/TB1PebaLXXXXXX3XpXXXXXXXXXX-990-500.jpg");
		
		//设置Person类中的SchoolInfo，包括一个school_name
		List<SchoolInfo> listSchoolInfo2 = new ArrayList<SchoolInfo>();
		
		SchoolInfo schoolInfo3 = new SchoolInfo();
		schoolInfo3.setSchool_name("北京大学");
		
		SchoolInfo schoolInfo4 = new SchoolInfo();
		schoolInfo4.setSchool_name("清华大学");
		
		listSchoolInfo2.add(schoolInfo3);
		listSchoolInfo2.add(schoolInfo4);
	
		//将SchoolInfo的对象集合添加到Person中
		person2.setSchoolInfo(listSchoolInfo2);
	
		//将Person对象的集合添加到Result中
		listPersons.add(person1);
		listPersons.add(person2);
		
		result.setPersonData(listPersons);
		
		Gson gson = new Gson();
		//将上述代码转换为json
		System.out.println(gson.toJson(result));
	
	
	
	
	}

}
