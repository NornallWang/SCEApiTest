package ObjectCases;

public class OverloadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Printer p = new Printer();
//		p.print("�ַ���");
//		p.print(80);
//		p.print("�ַ���", 80);
		
		//���췽������
		Printer p = new Printer();
		p.print(1000);
		p.print("����");
		p.print("����", 888);
		
	}

}

class Printer{
	private String brand;
	private double price;
	
	//ϵͳĬ�Ϲ��췽��
	public Printer(){
		System.out.println("����ϵͳĬ�Ϲ��췽����");
	}
	//���췽��
	public Printer(String brand){
		this.brand = brand;
	}
	//�ϱ߹��췽�������ط���
	public Printer(String brand, double price){
		this.brand = brand;
		this.price = price;
	}
	
	public void print(String content){
		System.out.println("�����б�Ϊһ��string���͵����ݣ�"+content);
	}
	public void print(int number){
		System.out.println("�����б�Ϊһ��int���͵����ݣ�"+number);
	}
	public void print(String content, int number){
		System.out.println("�����б�Ϊstring���͵�content��"+content+"����int���͵�number"+number);
	}
}
