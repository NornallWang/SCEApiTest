package test.jsonTest;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class TestJson {
	
	public static void main(String[] args){
		//����result�����ݣ�����һ��int���ݺ�һ��Person����ļ���
		Result result = new Result();
		result.setResult(1);
		List<Person> listPersons = new ArrayList<Person>();
		
		//����result���еĵ�һ��Person���󣬰���name��age��url��һ��SchoolInfo����ļ���
		Person person1 = new Person();
		person1.setName("Tom Green");
		person1.setAge(22);
		person1.setUrl("https://img.alicdn.com/imgextra/i2/2578685019/TB21XA7iXXXXXbxXpXXXXXXXXXX_!!2578685019.jpg");

		//����Person���е�SchoolInfo������һ��scholl_name
		List<SchoolInfo> listSchoolInfo1 = new ArrayList<SchoolInfo>();
		
		SchoolInfo schoolInfo1 = new SchoolInfo();
		schoolInfo1.setSchool_name("Cambridge");
		
		SchoolInfo schoolInfo2 = new SchoolInfo();
		schoolInfo2.setSchool_name("Oxford");
		
		listSchoolInfo1.add(schoolInfo1);
		listSchoolInfo1.add(schoolInfo2);
		
		//��SchoolInfo�Ķ��󼯺���ӵ�Person��
		person1.setSchoolInfo(listSchoolInfo1);	
		
		//����Person���еĵڶ���Person���󣬰���name��age��url��һ��SchoolInfo����ļ���
		Person person2 = new Person();
		person2.setName("Bill Gates");
		person2.setAge(66);
		person2.setUrl("https://img.alicdn.com/tps/TB1PebaLXXXXXX3XpXXXXXXXXXX-990-500.jpg");
		
		//����Person���е�SchoolInfo������һ��school_name
		List<SchoolInfo> listSchoolInfo2 = new ArrayList<SchoolInfo>();
		
		SchoolInfo schoolInfo3 = new SchoolInfo();
		schoolInfo3.setSchool_name("������ѧ");
		
		SchoolInfo schoolInfo4 = new SchoolInfo();
		schoolInfo4.setSchool_name("�廪��ѧ");
		
		listSchoolInfo2.add(schoolInfo3);
		listSchoolInfo2.add(schoolInfo4);
	
		//��SchoolInfo�Ķ��󼯺���ӵ�Person��
		person2.setSchoolInfo(listSchoolInfo2);
	
		//��Person����ļ�����ӵ�Result��
		listPersons.add(person1);
		listPersons.add(person2);
		
		result.setPersonData(listPersons);
		
		Gson gson = new Gson();
		//����������ת��Ϊjson
		System.out.println(gson.toJson(result));
	
	
	
	
	}

}
