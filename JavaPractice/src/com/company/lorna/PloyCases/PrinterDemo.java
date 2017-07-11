package com.company.lorna.PloyCases;

public class PrinterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ColorPrinter colorPinter = new ColorPrinter("����");
		//colorPinter.print("���Ǵ�ӡ���ݣ�����");
				
		School school = new School();
		//�Ȱ�װ��ɫ��ӡ��
		//school.setColorPrinter(colorPinter);
		//school.print("��ӡ���ݣ���");
		
		System.out.println("********************");
		//BlackPrinter blackp = new BlackPrinter("����");
		//school.setBlackPrinter(blackp);
		//school.print("��ӡ����");
		
		//ZhenPrinter zhenp = new ZhenPrinter("��ʽ");
		//school.setZhenPrinter(zhenp);
		//school.print("��ӡ����");
		
		/*
		 * ��̬��ʹ�ã�����ϣ���ά���Ըߣ�������������Ĵ�ӡ��������Ҫ��School������Ӷ���Ĵ��룬�������3D��ӡ��
		 */
		Printer printer2c = new ColorPrinter("����");
		printer2c.print("This is Content\n");
		
		Printer printer2b = new BlackPrinter("����");
		printer2b.print("This is content\n");
		
		Printer printer2z = new ZhenPrinter("��ʽ");
		printer2z.print("This is content\n");
		
		//ʹ�ö�̬���ƣ����������ӵ�3D��ӡ����ӡ�������
		Printer printer3D = new Printer3D("����˹");
		printer3D.print("This is content");
	}

}

//����һ�������ӡ��
class Printer{
	private String brand;
	
	public Printer(String brand){
		System.out.println("����Printer�Ĺ��췽������");
		this.brand = brand;
	}
	
	public void print(String content){
		System.out.println("����Printer�ķ�����");
	}
	
	//��Ϊbrand������˽�еģ����Բ��ܱ���������ķ���ֱ��ʹ�ã�����ʹ��set�������䷵��
	public String getBrand(){
		return brand;
	}
}

/*
//ѧУ�ͺڰס���ɫ��ӡ�������������͹�ϵ
class School{
	//ʹ�����ö�����Ϊ����
	private ColorPrinter colorp = null;
	private BlackPrinter blackp = null;
	//��Ϊ����������һ̨��ʽ��ӡ�������Ի���Ҫ��Ӹ�����
	private ZhenPrinter zhenp = null;
	
	//��װ��ɫ��ӡ��
	public void setColorPrinter(ColorPrinter cp){
		this.colorp = cp;
	}
	
	//��װ�ڰ״�ӡ��
	public void setBlackPrinter(BlackPrinter bp){
		this.blackp = bp;
	}
	
	//������ʽ��ӡ��
	public void setZhenPrinter(ZhenPrinter zp){
		this.zhenp = zp;
	}
	
	//ʹ��ѧУ��װ�Ĵ�ӡ�����д�ӡ
	public void print(String content){
		//���磺ʹ��ѧУ��װ�Ĳ�ɫ��ӡ�����д�ӡ
		//colorp.print(content);
		//ʹ��ѧУ��װ�ĺڰ״�ӡ�����д�ӡ
		//blackp.print(content);
		zhenp.print(content);
	}

}
*/

/*
 * ����Ժ���������ӡ��������Ҫ���Ӹô�ӡ�����ࡢ����School���������������Ժͷ���������Էǳ��ͣ�������ά������չ�Ժ�ά���Էǳ���
 * 
 * ����ԭ�򣺶��޸��Ƿ�յģ�����չ�ǿ��ŵģ�һ�����һ��ʼ����ƺã��Ͳ��ܱ��޸�
 * 
 * ����ʹ�ö�̬��������⣺��������ñ�����������������Ķ���
 * 
 * ������ϴ����е�School���������ʵ��
 */
class School{
	//��װ��ӡ����ʹ�ø������
	private Printer printer = null;
	
	//��ѧУ��װ��ӡ���ķ������ø�������ñ�����Ϊ�������ô����ǿ��Խ������κ�����Ķ���
	public void setPrinter(Printer p){
		this.printer = p;
	}
	
	//ʹ��ѧУ�Ĵ�ӡ��
	public void printer(String content){
		printer.print(content);
	}
}

//��ɫ��ӡ��
class ColorPrinter extends Printer{
	public ColorPrinter(String brand){
		super(brand);
	}
	
	public void print(String content){
		System.out.println(getBrand()+"��ɫ��ӡ����"+content);
	}
}

//�ڰ״�ӡ��
class BlackPrinter extends Printer{
	public BlackPrinter(String brand){
		super(brand);
	}
	
	public void print(String content){
		System.out.println(getBrand()+"�ڰ״�ӡ����"+content);
	}
}

//���һ̨��ʽ��ӡ��
class ZhenPrinter extends Printer{
	public ZhenPrinter(String brand){
		super(brand);
	}
	
	public void print(String content){
		System.out.println(getBrand()+"��ʽ��ӡ����"+content);
	}
}

//ʹ�ö�̬�Ժ������һ̨3D��ӡ��
class Printer3D extends Printer{
	public Printer3D(String brand){
		super(brand);
	}
	
	public void print(String content){
		System.out.println(getBrand()+"3D��ӡ����"+content);
	}
}