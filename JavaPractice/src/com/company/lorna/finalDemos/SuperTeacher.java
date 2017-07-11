package com.company.lorna.finalDemos;


public class SuperTeacher extends Teacher {
	
	public SuperTeacher(String name, String school){
		super(name, school);	//super调用的是父类Teacher的构造方法
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperTeacher st = new SuperTeacher("张老师","耀华高中");
		
	}

}
