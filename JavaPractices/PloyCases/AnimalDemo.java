package PloyCases;

public class AnimalDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Animal("���е�Animal");
		a.eating();
		
		Animal a1 = new Dog("Tommy");	//a1����Dog����	//��Ϊ��dogָ����Animal��Ҳ��������ת����
		//����ת�ͱȽϰ�ȫ�������ܻᵼ�����෽���Ķ�ʧ
		a1.eating();	//��Ϊ������ת�ͣ����Ե���Dog���spiting()���з������ɱ�a1����
		
		
		Animal a2 = new Cat("ketty");	//a2����Cat����
		a2.eating();
		//����ת�ͣ��ǲ���ȫ��
		//Cat cat =(Cat)a1;	//����д�����벻�ᱨ���������е�ʱ��ᱨClassCastException���쳣
		
		//������ת�ͽ��а�ȫ����֤
		if(a1 instanceof Cat){
			System.out.println("a1��û��ָ��Catʵ��");
			Cat cat =(Cat)a1;
		}
		if(a2 instanceof Cat){
			System.out.println("\na2ָ����ڴ��е�Catʵ������˴˴�����ת�ͳɹ�");
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
	
	//ͨ�õķ���,û��̫�����ʵ���壬ֻ�Ǹ���ȥ��������Ӧ����ô�����ʵ����һ����
	public void eating(){
		System.out.println("����ͨ�õ���Ϊ���Զ���");
	}
	
}

class Dog extends Animal{
	private String dogName;
	
	public Dog(String construcDogName){
		super(construcDogName);
	}
	
	//��дAnimal���еķ���eating
	public void eating(){
		System.out.println("Dog�й�ͷ����");
	}
	
	//Dog�����еķ���
	public void spiting(){
		System.out.println("Dog��ҧ�ˣ���");
	}
}

class Cat extends Animal{
	private String catName;
	
	public Cat(String construcCatName){
		super(construcCatName);
	}
	
	public void eating(){
		System.out.println("Cat�����㣡��");
	}
	
	//cat���е�����
	public void catchMouse(){
		System.out.println("Catץ���󣡣�");
	}
}