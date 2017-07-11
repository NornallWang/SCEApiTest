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
	//�ӿ���ֻ�ܷŹ��еľ�̬�����ͳ��󷽷�
	public static int number=10;
	int number2 = 20;	//Ĭ�ϸñ���Ϊ���еľ�̬����
	
	//public abstract void show();
	//void show2();	//ǰ��ʡ�Ե���public abstractҲ�ǿ��е�
	
	void eat();
	
}

class Children implements IAbility{
	public void eat(){
		System.out.println("�Ը�ʳ");
	}

}

class Dog implements IAbility{
	
	public void eat(){
		System.out.println("�й�ͷ");
	}
}

class Person{
	/*
	public void feed(Children child){
		System.out.println("��С��׼����ʳ");
		child.eat();
	}
	
	public void feed(Dog dog){
		System.out.println("����׼����ͷ");
		dog.eat();
	}
	*/
	//�����ϴ����Խӿڵķ�ʽ���и���
	//�ӿڵ����ñ�������������ʵ����Ķ���
	//�ӿ�ʵ���˶�̬
	public void feed(IAbility ability){
		ability.eat();	//��̬��
	}
	
}
