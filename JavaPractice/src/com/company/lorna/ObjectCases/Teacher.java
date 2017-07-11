package com.company.lorna.ObjectCases;

public class Teacher {
	
	private String name;
	private int age;
	
	public String getName(){
		return name;
	}
	
	public String setName(String myName){
		if(myName.contains("耀华")){
			System.out.println("是耀华中学的"+myName+"老师！");
		}
		else{
			System.out.println(myName+"不是耀华中学的老师！！");
		}
		return myName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Teacher teacher = new Teacher();
		String name = "耀华·John";
		System.out.println(teacher.setName(name));
		System.out.println(teacher.getName());
	}

}
