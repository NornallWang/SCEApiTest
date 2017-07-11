package com;

public class PersonDemo {
	
	private String personName;	//属性私有化，如果想让私有属性被外部方法访问，可以通过get和set实现
	private int personAge;
	
	//构造方法初始化属性
	public PersonDemo(String constructorName, int constructorAge){
		this.personName = constructorName;
		this.personAge = constructorAge;
	}
	
	public void eating(){
		System.out.println("Person类行为1：I am eating!!");
	}
	public void walking(){
		System.out.println("Person类行为2： I am walking!!");
	}

	//重写Object类的toString方法
	public String toString(){
		return "姓名："+personName+",年龄："+personAge;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentDemo stu = new StudentDemo("Jack Wang",15,"英语",78);
		stu.eating();
		stu.walking();
		stu.goSchool();
		stu.takeExam();
		System.out.println(stu);	//该语句默认为调用stu.toString()方法
	}

}

class StudentDemo extends PersonDemo{
	private String course;
	private int score;
	
	public StudentDemo(String sPersonName, int sPersonAge, String studentCourse, int studentScore){
		super(sPersonName,sPersonAge);
		this.course = studentCourse;
		this.score = studentScore;
	}
	
	public void goSchool(){
		System.out.println("Student类的行为1：I am go to school!!");
	}
	
	public void takeExam(){
		System.out.println("Student类的行为2： I am taking an exam!!!");
	}
	
	public String toString(){
		return super.toString()+"；该学生所学课程为："+course+"，该学生该课程上次考试成绩为："+score;		//super.toString()语句调用了父类Person类中的toString方法
	}
}
