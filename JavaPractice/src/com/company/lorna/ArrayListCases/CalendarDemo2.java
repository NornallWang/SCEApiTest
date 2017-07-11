package com.company.lorna.ArrayListCases;

public class CalendarDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int year = 2017;	//����yeaar����Ҫչʾ����
		int month = 5;		//����month����Ҫչʾ������·�
		int totalDays = 0;	//����totalDays����������������ȳ�ʼ��Ϊ0
		int days = 0;		//����days�����µ����������ȳ�ʼ��Ϊ0
		boolean isRun;		//������ΪTrue��ʱ��Ϊ���꣬false��ʱ��Ϊ������
		
		//�ж����Ƿ�Ϊ����Ĺ�ʽ��i%400==0 �����ߣ�i%4==0&&i%100!=0��
		if(year%400==0 ||(year%4==0&&year%100!=0)){
			isRun = true;
		}else{
			isRun = false;
		}
		
		//�������������
		for(int i=1990;i<year;i++){
			if(isRun){
				totalDays+=366;
			}else{
				totalDays+=365;
			}
		}
		
		//�����µ�������
		for(int i=1;i<=month;i++){
			//ʹ��switch����ֵ�ж�
			//����·�Ϊ1��3��5��7��8��10��12����ÿ������Ϊ31��
			//����·�Ϊ����2�·ݣ����������Ϊ29�������꣬���������Ϊ28��
			//����·�Ϊ4��6��9��11����ÿ������Ϊ30
			switch(i){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 2:
				if(isRun){
					days = 29;
				}
				else{
					days = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			default:
				System.out.println("Ŀ���·ݲ����ϳ���");
			}
			
			//�����µ��������浽days�����У����ۼӵ���������
			if(i!=month){
				totalDays +=days;
			}
			
		}
		
		//��������ڼ�����ʽ��ʵ����ǰ�ߵ��Ʊ��\t�ĸ���
		int beforeDays;	//�������ڼ����������\t�ĸ���
		//ȡ���ڼ��Ĺ�ʽ
		beforeDays = 1+totalDays%7;
		//������ǰ�ߵ�\tΪ0
		if(beforeDays == 7){
			beforeDays = 0;	//����������
		}
		//��ӡ�����ڼ������ո�ʽ
		System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");	//������ͷ
		for(int i=0;i<beforeDays;i++){
			//�ȴ�ӡ��\t
			System.out.print("\t");
		}
		//��ӡ����
		for(int i=1;i<=days;i++){
			System.out.print(i+"\t");
			//��7������
			if((i+beforeDays)%7==0){
				System.out.println();
			}
		}
		
	}

}
