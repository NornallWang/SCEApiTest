package ObjectCases;

public class StaticDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account acc1 = new Account();	//������ص�ʱ��ֱ��ִ��static���飬��ִ��һ�Σ�֮���ٵ�����ϵͳ��Ĭ�Ϲ��췽��
		//��number1��number2�����η�Ϊpublic��ʱ�򣬸ò��������޸���acc1ָ��Ķ����ڴ�ռ��ֵ������Ӱ��acc2
		//��number1��number2Ϊstatic��ʱ����Ϊ�������ж���������ֻҪ�޸���acc1ָ��Ķ����ڴ�ռ�ֵ����������Ҳͬʱ���޸�
		//acc1.number1++;
		//����Ҳ������������ʽ������д
		Account.number1++;
		//acc1.printNumber1();
		System.out.println("static���ε�����Ϊ���ж�������Ϊnumber1��ֵΪ��"+Account.number1);
		Account.printNumber1();//��̬�������Ա���ֱ�ӵ��ã�ͬ���������Ϊ�Ǿ�̬�ģ����ܱ��������
		acc1.printNumber2();	//��Ϊnumber1Ϊstatic���ѱ����ж���������number1��ֵҲ���������public���ε�number2
		acc1.printNumber3();	//��Ϊnumber3Ϊprivate���͵ģ����Բ�����number1��Ӱ��
		acc1.printNumber4();	//��Ϊnumber3Ϊprotected���͵ģ����Բ�����number1��Ӱ��
		
		System.out.println("\n����Ϊ��ĵڶ��ζ�������");
		Account acc2 = new Account();	//�ٴε���ϵͳ��Ĭ�Ϲ��췽��
		acc2.printNumber1();
		acc2.printNumber2();
		acc2.printNumber3();
		acc2.printNumber4();
	}

}

class Account{
//	private int number1 = 1;	//ÿ���������Լ��Ķ�����һ������
//	private int number2 = 2;
	
//	public int number1 = 1;		//ÿ���������Լ��Ķ�����һ������
//	public int number2 = 2;
	
	public static int number1 = 1;	//static���εı���Ϊ��̬����������������������κζ��󣬱����������
	public int number2 = 2;		//ÿ���������Լ��Ķ�����һ������
	private int number3 = 3;	//ÿ���������Լ��Ķ�����һ������
	protected int number4 = 4;
	
	//static���飬�౻���ص�ʱ��ͻ�ִ�У�����ִ��һ�Σ������Ծ�̬�ı������и�ֵ
	public Account(){
		System.out.println("����ϵͳ��Ĭ�Ϲ��췽����");
	}
	//�����ڹ��췽����ִ��
	static{
		System.out.println("static���飬");
		number1 = 100;
	}
	
	//��̬�����в��ܷ��ʷǾ�̬�ı���
	//��̬�����в���ʹ��this
	//��̬������ֻ�ܷ�λ�ⲿ�ľ�̬�Ķ���
	public static void printNumber1(){
		System.out.println("Ϊpublic��static���ε�number1��ֵΪ��"+number1);
	}
	public void printNumber2(){
		System.out.println("Ϊpublic���ε�number2��ֵΪ��"+number2);
		System.out.println("�ڷǾ�̬�����з��ʾ�̬������number1��"+number1);//�ڷǾ�̬�ķ����з��ʾ�̬�����ݺͷѾ�̬������
		System.out.print("�ڷǾ�̬�ķ����з��ʾ�̬�ķ���printNumber1��");
		printNumber1();
	}
	public void printNumber3(){
		System.out.println("Ϊprivate���ε�number3��ֵΪ��"+number3);
	}
	public void printNumber4(){
		System.out.println("Ϊprotected���ε�number4��ֵΪ��"+number4);
	}
	
}
