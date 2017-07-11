package com.company.lorna.ObjectCases;

public class Dog {
	
	//Dog??????
	public String brand;	//???
	public int age;		//????
	
	
	//??????Dog?????
	public String getDogInfo(){	
		return "???????"+age+"???"+brand;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog myDog = new Dog();
		myDog.brand = "?????????";
		myDog.age = 4;
		System.out.println(myDog.getDogInfo());
	}

}
