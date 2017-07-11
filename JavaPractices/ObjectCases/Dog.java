package ObjectCases;

public class Dog {
	
	//Dog的属性
	public String brand;	//品种
	public int age;		//年龄
	
	
	//打印一条Dog的方法
	public String getDogInfo(){	
		return "这是一条"+age+"岁的"+brand;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog myDog = new Dog();
		myDog.brand = "拉布拉多犬";
		myDog.age = 4;
		System.out.println(myDog.getDogInfo());
	}

}
