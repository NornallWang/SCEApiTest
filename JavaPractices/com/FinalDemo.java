package com;

public class FinalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A a = new A();
		a.showNumber1();
		a.showNumber2();
		
		System.out.println("************************");
		B b = new B();
		b.showNumber2();
		
		//��������
		final A  a2 = new A();		//a2ָ�����new A()�Ķ������ڵĶ��ڴ�ռ�
		//a2 = new A();	//����䱨����Ϊ��һ������е�a2������Ϊ��final��final�������ñ����ϣ���������ñ���ֻ������һ��ʼ�����õĶ�����;���ܸı�ָ��
		a2.number3=33;
		a2.showNumber3();
	}

}

//�������ǲ��ܱ��̳е�
/*final*/class A{
	public final int number1 = 1;//�������ɱ��޸�
	public int number2 = 2;
	public int number3 = 3;
	
	public void showNumber1(){
		//number1++;	//��Ϊnumber1Ϊfinal���Σ���Ϊ����������ֵ���ɱ��޸ģ��ʴ����ᱨ��
		System.out.println("number1="+number1);
	}
	
	public void showNumber2(){
		System.out.println("���Ǹ����б�������д�ķ���showNumber2��number2="+number2);
	}
	
	//���಻�ܶԸ����еĳ�������������д
	public final void showNumber3(){
		System.out.println("���Ǹ����е�showNumber3������number3="+number3);
	}
}

class B extends A{
	//��д����A�ķ���showNumber2,����������ͬ�������б���ͬ������ֵ��ͬ
	//��д�ķ������ܱȱ���д�ķ�������Ȩ�޸��ϸ񣬼�����д�ķ���Ϊ�����е�showNumber2������Ȩ��Ϊpublic������������д���ķ���showNumber2�ķ���Ȩ�޲���Ϊprivate����protected
	public void showNumber2(){
		System.out.println("����Ϊ��������ʹ��super�ؼ��ֵ����˸����б���д�ķ���");
		super.showNumber2();
		System.out.println("���������е���д����showNumber2��number2="+number2);
	}	
}

