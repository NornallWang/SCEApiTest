package com.company.lorna.ObjectCases;

public class SinglonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�����췽��SinglonΪpublic��ʱ��
//		Singlon singlon1 = new Singlon();	//����Singlon���췽��һ��
//		Singlon singlon2 = new Singlon();	//�ٴε���Singlon���췽��
		
		//�����췽��SinglonΪprivate��ʱ�����������Ϸ�ʽ���е���
		Singlon singlon1 = Singlon.getInstance();
		Singlon singlon2 = Singlon.getInstance();
	}

}

//������
class Singlon{
	
	//���췽��
//	public Singlon(){
//		System.out.println("����һ��������Ĺ��췽��");
//	}
	
	
	private Singlon(){
		System.out.println("����һ��public�ĵ����๹�췽����");
	}
	
	//�����췽��SinglonΪprivate��ʱ�����ڵ�ǰ���й���������е���
	//private static Singlon singlon = new Singlon();	//���ַ�ʽ�ܺ���Դ����Ϊÿ���ô����newһ������
	private static Singlon singlon = null;
	//���϶��󹹽��Ժ�ʹ�����·������е���
	public static Singlon getInstance(){
		if(singlon == null){
			singlon = new Singlon();	//�����ڴ���û��Singlon�����ʱ����ȥnewһ�����������ֱ��return
		}
		return singlon;
	}
}