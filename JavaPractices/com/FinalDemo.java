package com;

public class FinalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A a = new A();
		a.showNumber1();
		a.showNumber2();
		
		System.out.println("************************");
		B b = new B();
		b.showNumber2();
		
		//常量变量
		final A  a2 = new A();		//a2指向的是new A()的对象所在的堆内存空间
		//a2 = new A();	//该语句报错，因为上一个语句中的a2被定义为了final，final用在引用变量上，代表次引用变量只能引用一开始所引用的对象，中途不能改变指向；
		a2.number3=33;
		a2.showNumber3();
	}

}

//常量类是不能被继承的
/*final*/class A{
	public final int number1 = 1;//常量不可被修改
	public int number2 = 2;
	public int number3 = 3;
	
	public void showNumber1(){
		//number1++;	//因为number1为final修饰，则为常量，常量值不可被修改，故此语句会报错
		System.out.println("number1="+number1);
	}
	
	public void showNumber2(){
		System.out.println("这是父类中被子类重写的方法showNumber2，number2="+number2);
	}
	
	//子类不能对父类中的常量方法进行重写
	public final void showNumber3(){
		System.out.println("这是父类中的showNumber3方法，number3="+number3);
	}
}

class B extends A{
	//重写父类A的方法showNumber2,即方法名相同，参数列表相同，返回值相同
	//重写的方法不能比被重写的方法访问权限更严格，即被重写的方法为父类中的showNumber2，访问权限为public，则子类中重写它的方法showNumber2的访问权限不能为private或者protected
	public void showNumber2(){
		System.out.println("以下为在子类中使用super关键字调用了父类中被重写的方法");
		super.showNumber2();
		System.out.println("这是子类中的重写方法showNumber2，number2="+number2);
	}	
}

