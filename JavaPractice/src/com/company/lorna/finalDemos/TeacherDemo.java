package com.company.lorna.finalDemos;

public class TeacherDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Son son = new Son();
		son.showYourSon();
		son.showA();
		
		System.out.println("********************");
		EnglishTeacher engTeacher = new EnglishTeacher("Jane", "Stanford");
		engTeacher.teaching();
		
		MathTeacher mathTeacher = new MathTeacher("Jerry","Stanford");
		mathTeacher.teaching();
	}

}

class Father{
	public Father(){
		System.out.println("����Ǹ���Ĺ��췽������");
	}
	
	public void showMe(){
		System.out.println("����Ǹ���ķ�������");
	}
	
	public void showA(){
		System.out.println("������������ͬ����showA��������������");
	}
}

class Son extends Father{
	public Son(){
		super();	//���ø����޲εĹ��췽��������ʡ�ԣ����ұ���Ҫ�������๹�췽���еĵ�һ�����
		System.out.println("���������Ĺ��췽������");
	}
	
	public void showYourSon(){
		System.out.println("���������ķ�������");
		//��ȻҲ�����������е��ø���ķ����������п��Ե��÷����з�˽�еķ���
		super.showMe();//����д����showMe();��д��Ч����һ����
	}

	public void showA(){
		System.out.println("�����е�showA��������������");
		//������������д���ͬ������������������Ҫ���ø����еĸ�ͬ������������ʹ��super�ؼ���ָ��
		super.showA();
	}
}

class Teacher{
	private String name;
	private String school;
	
	//���췽����ʼ����Ա����
	public Teacher(String name, String school){
		System.out.println("Teacher�Ǹ��࣬�˴�ΪTeacher���вι��췽������");
	}
	
	//Teacher��ķ���
	public void teaching(){
		System.out.println("����ı��Σ���");
	}
}

class EnglishTeacher extends Teacher{
	//������������ʱ��Ҫ������������ȥ������Ҫ��һ������Ĺ���������
	public EnglishTeacher(String name, String school){
		//���ø���Ĺ��췽����һ�������д����вεĹ��췽������Ӧ�õ��ø����еĴ��ι��췽��
		super(name,school);
	}
	
	//Teacher������
	public void teaching(){
		System.out.println("����ΪEnglishTeacher����ʹ��super�ؼ��ֵ����丸��Teacher��teaching������");
		super.teaching();
		System.out.println("����ΪEnglishTeacher�����Լ��ķ����е����ԣ�");
		System.out.println("��������дӢ�����");
		System.out.println("��֯Ӣ��ǻ����");
	}
}

class MathTeacher extends Teacher{
	public MathTeacher(String name, String school){
		super(name,school);
	}
	
	public void teaching(){
		System.out.println("����ΪMathTeacher����ʹ��super�ؼ��ֵ����丸��Teacher��teaching������");
		super.teaching();
		System.out.println("����ΪMathTeacher�����Լ��ķ����е����ԣ�");
		System.out.println("������ѧ�ڿΣ���");
		System.out.println("΢�������ݣ���");
	}
}
