package com.company.lorna.ObjectCases;

public class SinglonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//当构造方法Singlon为public的时候
//		Singlon singlon1 = new Singlon();	//调用Singlon构造方法一次
//		Singlon singlon2 = new Singlon();	//再次调用Singlon构造方法
		
		//当构造方法Singlon为private的时候，则不能用以上方式进行调用
		Singlon singlon1 = Singlon.getInstance();
		Singlon singlon2 = Singlon.getInstance();
	}

}

//单例类
class Singlon{
	
	//构造方法
//	public Singlon(){
//		System.out.println("这是一个单例类的构造方法");
//	}
	
	
	private Singlon(){
		System.out.println("这是一个public的单例类构造方法！");
	}
	
	//当构造方法Singlon为private的时候，则在当前类中构建对象进行调用
	//private static Singlon singlon = new Singlon();	//该种方式很耗资源，因为每调用此意就new一个对象
	private static Singlon singlon = null;
	//以上对象构建以后，使用如下方法进行调用
	public static Singlon getInstance(){
		if(singlon == null){
			singlon = new Singlon();	//当堆内存中没有Singlon对象的时候，再去new一个，如果有则直接return
		}
		return singlon;
	}
}