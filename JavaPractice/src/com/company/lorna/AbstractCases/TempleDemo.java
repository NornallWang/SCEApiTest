package AbstractCases;

public class TempleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher dbTeacher = new DBTeacher();
		dbTeacher.work();
		
		Teacher cTeacher = new CTeacher();
		cTeacher.work();

	}
}

abstract class Teacher{
	private int tnumber;
	private double tsalary;
	private String tname;
	
	public void prepared(){
		System.out.println("��ͶӰ��");
		System.out.println("����");
	}
	
	public void endClass(){
		System.out.println("�ر�ͶӰ��");
		System.out.println("���ÿκ���ҵ");
	}
	
	//���󷽷���������ʵ��
	public abstract void teaching();
	
	//��ʦ������������һ�����̣������̾���һ��ģ��
	public void work(){
		//1���ڿ�ǰ׼��
		prepared();
		//2�������ڿ�
		teaching();
		//3�������Ͽ�();
		endClass();
	}
}

//����Teacher������DBTeacher
class DBTeacher extends Teacher{
	//�Գ�����Teacher�еĳ��󷽷�teaching�ľ���ʵ��
	public void teaching(){
		System.out.println("��DB����");
		System.out.println("DB��ʦ��ʼ��ѧ����дsqlָ��");
		System.out.println("DB��ʦ���ڿν�����ݿ����֪ʶ");
	}
}

//����Teacher������JavaTeacher
class CTeacher extends Teacher{
	//�Գ�����Teacher�еĳ��󷽷�teaching�ľ���ʵ��
	public void teaching(){
		System.out.println("��Eclipse����");
		System.out.println("JAVA��ʦ��ʼ��ѧ��java���˼��");
		System.out.println("JAV��ʦ���ڿν��JAVA������֪ʶ");
	}
}