package com.company.lorna.ObjectCases;

public class Teacher {
	
	private String name;
	private int age;
	
	public String getName(){
		return name;
	}
	
	public String setName(String myName){
		if(myName.contains("ҫ��")){
			System.out.println("��ҫ����ѧ��"+myName+"��ʦ��");
		}
		else{
			System.out.println(myName+"����ҫ����ѧ����ʦ����");
		}
		return myName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Teacher teacher = new Teacher();
		String name = "ҫ����John";
		System.out.println(teacher.setName(name));
		System.out.println(teacher.getName());
	}

}
