package ObjectCases;

public class MethodDemo {
	
	//��ӡ����ķ�������������Ϊ�յ����޲���
	public void method1(){
		System.out.println("��������Ϊ�����޲���");
	}

	//���о��巵�����͵ķ�������������ΪString���޲���
	public String method2(){
		return "���о��巵���������޲����ķ���";	//���ص��������ͱ���������ķ�������������һ��
	}
	
	//��������Ϊ���Ҵ��в����ķ���
	public void method3(String name){
		System.out.println("��������Ϊ���Ҵ��в����ķ�����������ֵΪ��"+name);
	}
	
	//
	public String method4(String name, int age){
		return "���о��巵�������Ҵ��ж�������ķ�����������ֵΪ��name="+name+",ageΪ��"+age;
	}
	
	//���ݻ�����������
	public void opperateData(int age){
		age++;
		System.out.println(age);
	}
	
	//����������������
	public void operateArr(int[] array){
		array[0] = 100;
		System.out.println(array[0]);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MethodDemo methodDemo = new MethodDemo();
		methodDemo.method1();
		System.out.println(methodDemo.method2());
		methodDemo.method3("John");
		System.out.println(methodDemo.method4("Lorna", 8));
		
		int age =10;
		methodDemo.opperateData(age);
		System.out.println(age);
		
		//����
		int[] array = {1,2,3,4};
		methodDemo.operateArr(array);
		System.out.println(array[2]);
	
	}

}
