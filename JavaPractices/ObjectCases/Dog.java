package ObjectCases;

public class Dog {
	
	//Dog������
	public String brand;	//Ʒ��
	public int age;		//����
	
	
	//��ӡһ��Dog�ķ���
	public String getDogInfo(){	
		return "����һ��"+age+"���"+brand;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dog myDog = new Dog();
		myDog.brand = "��������Ȯ";
		myDog.age = 4;
		System.out.println(myDog.getDogInfo());
	}

}
