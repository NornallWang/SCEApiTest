package com.company.lorna.ObjectCases;

public class ConstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Person person = new Person();
		//System.out.println(person.personInfo());
		
//		person.setName("张三");
//		person.setAge(19);
		//person.setCity("北京");	//如果构造方法中的参数没有被初始化，则报错
		
		Person person = new Person("张三",20,"北京市");
		//1、在堆中开辟空间，给属性分配默认的初始值
		//2、加入属性一开始就赋值了，就进行赋值工作
		//3、调用构造方法来对属性进行初始化
		System.out.println(person.personInfo());	
		
	}

}

//当一个类没有显式声明一个构造方法的时候，系统会有一个默认的无参构造方法

class Person{
	private String name="李四";
	private int age;
	private String city;
	
	//系统默认的构造方法，无参并且没有返回类型
//	public Person(){
//		System.out.println("这是一个无参并且没有返回类型的系统默认的构造方法");
//	}
//	
	//显式声明一个构造方法，明确类中所有的属性，确保被初始化的属性都有值
	/*
	 * 形参和成员变量不同名，将形参赋值给属性即可
	public Person(String herName,int herAge, String herCity){
		name = herName;	//将形参赋值给属性
		age = herAge;
		city = herCity;
	}
	*/
	
	//构造方法的重载
	public Person(){
		System.out.println("这是一个无参构造方法！");
	}
	
	//形参和成员变量同名时，使用this关键字指向类中的对象引用，形参赋值给该对象的引用
	public Person(String name, int age, String city){
		this();//使用this关键字调用类中的无参构造方法，并且该语句必须置于第一个位置
		System.out.println("以上为在带参构造方法中调用无参构造方法\n");
		System.out.println("以下执行带参的构造方法！");
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
			System.out.println(name+"为未成年！");
			this.age = age;
		}
		else{
			System.out.println(name+"已成年！");
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
	
	//输出个人信息
	public String personInfo(){
		//方法的调用
		System.out.println(this.getAge());
		return "名字为："+this.name+"的人，年龄为："+this.age+"，家住"+this.city;
	}
	
}
