package ArrayListCases;

public class CalendarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=2017;
		int total_days = 0;
		int month = 5;
		boolean isRunYear;
		int days =0;	//����ָ���µ�����
		System.out.println("***********��ӭʹ��������**********");
		//�������������
		for(int i=1900;i<year;i++){
			//�ж��Ƿ�Ϊ����(iȡ��400���������0���ʾΪ����)(����һ���жϷ���Ϊ���걻4�������Ҳ���100����)
			if(i%400 == 0 || (i%4 ==0 && i%100!=0)){
				isRunYear = true;
				//total_days = +366;
			}
			else{
				isRunYear = false;
				//total_days =+365;
			}
			if(isRunYear){
				System.out.println(isRunYear+" ������");
			}else{
				System.out.println(isRunYear+" ��������");
			}
		}
		
		//�������������
		for(int i=1990;i<year;i++){
			if(i%400 == 0 || (i%4==0&i%100!=0)){
				total_days =+366;
			}else{
				total_days =+365;
			}
		}
		
		//���������·ݵ�������
		for(int i =1;i<month;i++){
			
		}
		
		/**
		//����·ݵ������ķ���һ��ʹ�ö���if...elseʵ��
		if(month==1 ||month==3 ||month==5|| month==7 ||month==8 ||month==10 ||month==12){
			days = 31;
		}else if(month == 2){
			if(isRunYear=true){
				days = 29;
			}else{
				days = 28;
			}
		}else if(month==4 ||month==6 ||month==9|| month==11){
			days = 30;
		}
		**/
		/**
		 * ��ȡ�·������ķ�������ʹ��switch
		 * ���ϵĵ�ֵ�жϿ���ʹ��switch�������
		 */
		switch(month){
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
				if(isRunYear=true){
					days = 29;
				}else{
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
				System.out.println("������·ݲ���ȷ��");
		}
		//�������µ�����
		System.out.println(year+"��"+month+"�·ݵ�����Ϊ:"+days);


	}

}
