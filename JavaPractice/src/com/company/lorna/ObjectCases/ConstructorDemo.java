package com.company.lorna.ObjectCases;

public class ConstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Person person = new Person();
		//System.out.println(person.personInfo());
		
//		person.setName("����");
//		person.setAge(19);
		//person.setCity("����");	//������췽���еĲ���û�б���ʼ�����򱨴�
		
		Person person = new Person("����",20,"������");
		//1���ڶ��п��ٿռ䣬�����Է���Ĭ�ϵĳ�ʼֵ
		//2����������һ��ʼ�͸�ֵ�ˣ��ͽ��и�ֵ����
		//3�����ù��췽���������Խ��г�ʼ��
		System.out.println(person.personInfo());	
		
	}

}

//��һ����û����ʽ����һ�����췽����ʱ��ϵͳ����һ��Ĭ�ϵ��޲ι��췽��

class Person{
	private String name="����";
	private int age;
	private String city;
	
	//ϵͳĬ�ϵĹ��췽�����޲β���û�з�������
//	public Person(){
//		System.out.println("����һ���޲β���û�з������͵�ϵͳĬ�ϵĹ��췽��");
//	}
//	
	//��ʽ����һ�����췽������ȷ�������е����ԣ�ȷ������ʼ�������Զ���ֵ
	/*
	 * �βκͳ�Ա������ͬ�������βθ�ֵ�����Լ���
	public Person(String herName,int herAge, String herCity){
		name = herName;	//���βθ�ֵ������
		age = herAge;
		city = herCity;
	}
	*/
	
	//���췽��������
	public Person(){
		System.out.println("����һ���޲ι��췽����");
	}
	
	//�βκͳ�Ա����ͬ��ʱ��ʹ��this�ؼ���ָ�����еĶ������ã��βθ�ֵ���ö��������
	public Person(String name, int age, String city){
		this();//ʹ��this�ؼ��ֵ������е��޲ι��췽�������Ҹ����������ڵ�һ��λ��
		System.out.println("����Ϊ�ڴ��ι��췽���е����޲ι��췽��\n");
		System.out.println("����ִ�д��εĹ��췽����");
		this.name = name;
		this.age = age;
		this.city = city;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setAge(int age){
		if(age<18){
			System.out.println(name+"Ϊδ���꣡");
			this.age = age;
		}
		else{
			System.out.println(name+"�ѳ��꣡");
			this.age = age;
		}
	}
	public int getAge(){
		return age;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return city;
	}
	
	//���������Ϣ
	public String personInfo(){
		//�����ĵ���
		System.out.println(this.getAge());
		return "����Ϊ��"+this.name+"���ˣ�����Ϊ��"+this.age+"����ס"+this.city;
	}
	
}
