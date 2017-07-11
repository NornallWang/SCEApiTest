package com;

public class ObjectDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student std = new Student("Jack",20);	//std通过new关键字在堆内存中创建的对象内存地址为DFF1
		//打印std对象
		//System.out.println("std对象在堆内存中的地址为："+std);		//std和std.toString()的返回结果是一样的
		
		//因为Student类继承的是Object类，所以可以直接调用Object的toString()方法
		//System.out.println("直接调用父类Object的toString方法获取std对象在堆内存中的地址："+std.toString());
		System.out.println("当Student类中重写了Object类的toString方法以后，std对象则直接调用自己的toString方法，返回结果为：\n"+std.toString());
		
		Student std2 = new Student("Jack",20);	//std2通过new关键字在堆内存中创建的对象内存地址为DFF2
		//System.out.println(std.equals(std2));	//判断std对象和std2对象是否相等，不相等，因为他们两个指向的堆内存中的对象内存地址不一致，因此返回false
		System.out.println(std.equals(std2));   //调用的是改写后的equals方法
	}

}

class Student extends Object{
	String name;
	int age;
	
	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	//重写Object类中的toString()方法
	public String toString(){
		return "姓名为 "+name+" 的学生，年龄为："+age;
	}
	
	//改写equals方法
	public boolean equals(Object obj){
		//如果当前对象与传入的引用参数obj恒等，也就是自己跟自己比，则返回true
		if(this == obj){
			return true;
		}
		//果传入的对象为空，则返回false
		if(obj == null){
			return false;
		}
		//如果当前对象的运行时类与传入的对象运行时类不相等，则返回false，比如花草跟动物比
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		//当两个的运行时类相等，则将传入的对象强制转化为Student
		Student stdu = (Student)obj;
		//假设当前对象的年龄与传入对象的年龄不相等，则返回false
		if(this.age!=age){
			return false;
		}
		//如果当前对象的name为空并且传入对象的name不为空，则返回false
		if(this.name==null){
			if(stdu.name!=null){
				return false;
			}
		}
		//如果当前对象的name不等于传入对象的name，此处调用的equals为字符串比较，已被改写，则返回false
		else if(!this.name.equals(stdu.name)){
			return false;
		}
		//以上条件都不满足，则返回true
		return true;
	}
}
