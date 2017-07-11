package InterfaceCases;

public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(IAbility.number);
		System.out.println(IAbility.number2);
		
		Person person = new Person();
		Children child = new Children();
		Dog dog = new Dog();
		
		person.feed(child);
		person.feed(dog);
	}

}

interface IAbility{
	//接口中只能放公有的静态常量和抽象方法
	public static int number=10;
	int number2 = 20;	//默认该变量为公有的静态常量
	
	//public abstract void show();
	//void show2();	//前边省略掉了public abstract也是可行的
	
	void eat();
	
}

class Children implements IAbility{
	public void eat(){
		System.out.println("吃辅食");
	}

}

class Dog implements IAbility{
	
	public void eat(){
		System.out.println("啃骨头");
	}
}

class Person{
	/*
	public void feed(Children child){
		System.out.println("给小孩准备辅食");
		child.eat();
	}
	
	public void feed(Dog dog){
		System.out.println("给狗准备骨头");
		dog.eat();
	}
	*/
	//将以上代码以接口的方式进行改造
	//接口的引用变量可以引用其实现类的对象
	//接口实现了多态
	public void feed(IAbility ability){
		ability.eat();	//动态绑定
	}
	
}
