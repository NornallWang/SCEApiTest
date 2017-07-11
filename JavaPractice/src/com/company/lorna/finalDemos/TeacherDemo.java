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
		System.out.println("这个是父类的构造方法！！");
	}
	
	public void showMe(){
		System.out.println("这个是父类的方法！！");
	}
	
	public void showA(){
		System.out.println("父类中与子类同名的showA方法！！！！！");
	}
}

class Son extends Father{
	public Son(){
		super();	//调用父类无参的构造方法，可以省略，并且必须要放在子类构造方法中的第一条语句
		System.out.println("这个是子类的构造方法！！");
	}
	
	public void showYourSon(){
		System.out.println("这个是子类的方法！！");
		//当然也可以在子类中调用父类的方法，子类中可以调用分类中非私有的方法
		super.showMe();//这种写法和showMe();的写法效果是一样的
	}

	public void showA(){
		System.out.println("子类中的showA方法！！！！！");
		//当父类和子类中存在同名方法，并且子类想要调用父类中的该同名方法，必须使用super关键字指定
		super.showA();
	}
}

class Teacher{
	private String name;
	private String school;
	
	//构造方法初始化成员变量
	public Teacher(String name, String school){
		System.out.println("Teacher是父类，此处为Teacher的有参构造方法！！");
	}
	
	//Teacher类的方法
	public void teaching(){
		System.out.println("充足的备课！！");
	}
}

class EnglishTeacher extends Teacher{
	//构建子类对象的时候要传两个参数过去，所以要有一个子类的构建方法。
	public EnglishTeacher(String name, String school){
		//调用父类的构造方法，一旦父类中存在有参的构造方法，则应该调用父类中的带参构造方法
		super(name,school);
	}
	
	//Teacher的特性
	public void teaching(){
		System.out.println("以下为EnglishTeacher子类使用super关键字调用其父类Teacher的teaching方法：");
		super.teaching();
		System.out.println("以下为EnglishTeacher子类自己的方法中的特性：");
		System.out.println("听、读、写英语！！！");
		System.out.println("组织英语角活动！！");
	}
}

class MathTeacher extends Teacher{
	public MathTeacher(String name, String school){
		super(name,school);
	}
	
	public void teaching(){
		System.out.println("以下为MathTeacher子类使用super关键字调用其父类Teacher的teaching方法：");
		super.teaching();
		System.out.println("以下为MathTeacher子类自己的方法中的特性：");
		System.out.println("几何数学授课！！");
		System.out.println("微积分数据！！");
	}
}
