package ObjectCases;

public class StaticDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account acc1 = new Account();	//当类加载的时候直接执行static语句块，仅执行一次；之后再调用了系统的默认构造方法
		//当number1、number2的修饰符为public的时候，该操作仅是修改了acc1指向的对象内存空间的值，不会影响acc2
		//当number1、number2为static的时候，则为类中所有对象共享，所以只要修改了acc1指向的对象内存空间值，则其他的也同时被修改
		//acc1.number1++;
		//以上也可以像以下形式进行书写
		Account.number1++;
		//acc1.printNumber1();
		System.out.println("static修饰的属性为所有对象共享，因为number1的值为："+Account.number1);
		Account.printNumber1();//静态方法可以被类直接调用，同理，如果方法为非静态的，则不能被对象调用
		acc1.printNumber2();	//因为number1为static，已被类中对象共享，所以number1的值也被共享给了public修饰的number2
		acc1.printNumber3();	//因为number3为private类型的，所以不会受number1的影响
		acc1.printNumber4();	//因为number3为protected类型的，所以不会受number1的影响
		
		System.out.println("\n以下为类的第二次对象引用");
		Account acc2 = new Account();	//再次调用系统的默认构造方法
		acc2.printNumber1();
		acc2.printNumber2();
		acc2.printNumber3();
		acc2.printNumber4();
	}

}

class Account{
//	private int number1 = 1;	//每个对象都有自己的独立的一份属性
//	private int number2 = 2;
	
//	public int number1 = 1;		//每个对象都有自己的独立的一份属性
//	public int number2 = 2;
	
	public static int number1 = 1;	//static修饰的变量为静态变量（类变量）。不属于任何对象，被多个对象共享
	public int number2 = 2;		//每个对象都有自己的独立的一份属性
	private int number3 = 3;	//每个对象都有自己的独立的一份属性
	protected int number4 = 4;
	
	//static语句块，类被加载的时候就会执行，仅被执行一次，用来对静态的变量进行赋值
	public Account(){
		System.out.println("这是系统的默认构造方法！");
	}
	//优先于构造方法被执行
	static{
		System.out.println("static语句块，");
		number1 = 100;
	}
	
	//静态方法中不能访问非静态的变量
	//静态方法中不能使用this
	//静态方法中只能方位外部的静态的东西
	public static void printNumber1(){
		System.out.println("为public和static修饰的number1的值为："+number1);
	}
	public void printNumber2(){
		System.out.println("为public修饰的number2的值为："+number2);
		System.out.println("在非静态方法中访问静态的属性number1："+number1);//在非静态的方法中访问静态的内容和费静态的内容
		System.out.print("在非静态的方法中访问静态的方法printNumber1：");
		printNumber1();
	}
	public void printNumber3(){
		System.out.println("为private修饰的number3的值为："+number3);
	}
	public void printNumber4(){
		System.out.println("为protected修饰的number4的值为："+number4);
	}
	
}
