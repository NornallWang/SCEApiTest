package InterfaceCases;

/**
 * ѧУ�ڲ���װ�˺ڰ״�ӡ�����߲�ɫ��ӡ����ͨ��������װ�Ĵ�ӡ�����ȿ��Դ�ӡ��Ա����ϸ��Ϣ��Ҳ���Դ�ӡѧУ�ڲ�����ϸ��Ϣ
 * @author Nornall
 *
 */
public class PrinterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�Զ�̬����ʽ���̳���ֱ�����ڴ�ռ�
		Printer colorPrinter = new ColorPrinter("����");
		colorPrinter.print("���ǲ�ɫ��ӡ��Ŷ������");
		
		Printer blackPrinter = new BlackPrinter("����");
		blackPrinter.print("���Ǻڰ״�ӡ��Ŷ������");
		
		School school = new School();
		school.setPrinter(blackPrinter);
		//school.print("���ǽ�ѧ���ĵĺڰ״�ӡ��");
		
		school.setPrinter(colorPrinter);
		//school.print("���ǽ�ѧ���ĵĲ�ɫ��ӡ��");
		
		//��ӡ��Ա��ϸ��Ϣ
		Teachers teacher = new Teachers("����",30);
		school.print(teacher);
		
		//��ӡ��ѧ���ĵ���ϸ��Ϣ
		school.print(school);
	}

}

abstract class Printer{
	private String brand;
	
	//���췽����ʼ������
	public Printer(String brand){
		this.brand = brand;
	}
	
	//��ΪbrandΪ˽�����ԣ���������������ֱ�ӵ��ã�Ϊ�˷�����������ã�����getBrand()����
	public String getBrand(){
		return brand;
	}
	
	//����һ�����󷽷��������ʵ����������ʵ��
	public abstract void print(String content);
}

//����һ����ɫ��ӡ��
class ColorPrinter extends Printer{
	//���ø���Ĺ��췽��
	public ColorPrinter(String brand){
		super(brand);
	}
	
	//������󷽷��ľ���ʵ��
	public void print(String content){
		System.out.println(getBrand()+"�Ĵ�ӡ����ӡ�����е����ݣ�"+content);
	}
}

//����һ���ڰ״�ӡ��
class BlackPrinter extends Printer{
	//���ø���Ĺ��췽��
	public BlackPrinter(String brand){
		super(brand);
	}
	
	//������󷽷��ľ���ʵ��
	public void print(String content){
		System.out.println(getBrand()+"�Ĵ�ӡ����ӡ���ұߵ����ݣ�"+content);
	}
}

//����һ��school�࣬ͬʱ��װ�˺ڰ׺Ͳ�ɫ��ӡ��
class School implements IInfo{
	//��Printer���ñ�����Ϊschool���˽�����Բ���ʼ��
	private Printer printer = null;
	
	//����һ����װ��ӡ���ķ���
	public void setPrinter(Printer printer){
		this.printer = printer;
	}
	
	/*
	public void print(String content){
		//����ѧУ�Ĵ�ӡ�����д�ӡ
		printer.print(content);
	}
	*/
	//������print�����Զ�̬����ʽ����ʵ��
	//������Ƶ�ʱ��������ʹ�ýӿڻ��߳����࣬����ʹ�����кܺõ���չ�ԺͿ�ά����
	public void print(IInfo info){
		printer.print(info.detail());
	}
	
	//��Ϊimplements��IInfo�ӿڣ�������Ҫ������󷽷�detail���о���ʵ��
	public String detail(){
		return "��ã�������Goyoo��ѧ����";
	}
}

//����һ����Ա��
class Teachers implements IInfo{
	//�����Ա��˽������
	private String name;
	private int age;
	
	//���췽����ʼ������
	public Teachers(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	//��Ϊimplements��IInfo�ӿڣ�������Ҫ����detail���󷽷����о���ʵ��
	public String detail(){
		return "��ã�����Goyoo����Ϊ�� "+name+" �Ľ�Ա������Ϊ�� "+age+" !!";
	}
}

//����һ���ӿڣ����������ϸ��Ϣ����Ա������������ģ�
interface IInfo{
	//�ӿ���ֻ��������󷽷��͹��еľ�̬����
	public abstract String detail();
}