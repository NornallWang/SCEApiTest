package com;

public class PersonDemo {
	
	private String personName;	//����˽�л����������˽�����Ա��ⲿ�������ʣ�����ͨ��get��setʵ��
	private int personAge;
	
	//���췽����ʼ������
	public PersonDemo(String constructorName, int constructorAge){
		this.personName = constructorName;
		this.personAge = constructorAge;
	}
	
	public void eating(){
		System.out.println("Person����Ϊ1��I am eating!!");
	}
	public void walking(){
		System.out.println("Person����Ϊ2�� I am walking!!");
	}

	//��дObject���toString����
	public String toString(){
		return "������"+personName+",���䣺"+personAge;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentDemo stu = new StudentDemo("Jack Wang",15,"Ӣ��",78);
		stu.eating();
		stu.walking();
		stu.goSchool();
		stu.takeExam();
		System.out.println(stu);	//�����Ĭ��Ϊ����stu.toString()����
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
		System.out.println("Student�����Ϊ1��I am go to school!!");
	}
	
	public void takeExam(){
		System.out.println("Student�����Ϊ2�� I am taking an exam!!!");
	}
	
	public String toString(){
		return super.toString()+"����ѧ����ѧ�γ�Ϊ��"+course+"����ѧ���ÿγ��ϴο��Գɼ�Ϊ��"+score;		//super.toString()�������˸���Person���е�toString����
	}
}
