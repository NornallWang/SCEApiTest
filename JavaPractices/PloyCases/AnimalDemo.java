package PloyCases;

public class AnimalDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Animal("所有的Animal");
		a.eating();
		
		Animal a1 = new Dog("Tommy");	//a1引用Dog对象	//因为将dog指向了Animal，也就是向上转型了
		//向上转型比较安全，但可能会导致子类方法的丢失
		a1.eating();	//因为是向上转型，所以导致Dog类的spiting()特有方法不可被a1调用
		
		
		Animal a2 = new Cat("ketty");	//a2引用Cat对象
		a2.eating();
		//向下转型，是不安全的
		//Cat cat =(Cat)a1;	//这种写法编译不会报错，但是运行的时候会报ClassCastException的异常
		
		//对向下转型进行安全性验证
		if(a1 instanceof Cat){
			System.out.println("a1并没有指向Cat实例");
			Cat cat =(Cat)a1;
		}
		if(a2 instanceof Cat){
			System.out.println("\na2指向堆内存中的Cat实例，因此此次向下转型成功");
			Cat cat =(Cat)a2;
			cat.catchMouse();
		}
		
	}

}

class Animal{
	
	private String name;
	
	public Animal(String aName){
		this.name = aName;
	}
	
	//通用的方法,没有太大的现实意义，只是父类去告诉子类应该怎么具体地实现这一方法
	public void eating(){
		System.out.println("动物通用的行为：吃东西");
	}
	
}

class Dog extends Animal{
	private String dogName;
	
	public Dog(String construcDogName){
		super(construcDogName);
	}
	
	//重写Animal类中的方法eating
	public void eating(){
		System.out.println("Dog啃骨头！！");
	}
	
	//Dog类自有的方法
	public void spiting(){
		System.out.println("Dog会咬人！！");
	}
}

class Cat extends Animal{
	private String catName;
	
	public Cat(String construcCatName){
		super(construcCatName);
	}
	
	public void eating(){
		System.out.println("Cat爱吃鱼！！");
	}
	
	//cat独有的特性
	public void catchMouse(){
		System.out.println("Cat抓老鼠！！");
	}
}