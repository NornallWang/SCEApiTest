package ArrayListCases;

public class CalendarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year=2017;
		int total_days = 0;
		int month = 5;
		boolean isRunYear;
		int days =0;	//保存指定月的天数
		System.out.println("***********欢迎使用万年历**********");
		//计算年的总天数
		for(int i=1900;i<year;i++){
			//判断是否为闰年(i取余400，如果等于0则表示为闰年)(另外一种判断方法为：年被4整除并且不被100整除)
			if(i%400 == 0 || (i%4 ==0 && i%100!=0)){
				isRunYear = true;
				//total_days = +366;
			}
			else{
				isRunYear = false;
				//total_days =+365;
			}
			if(isRunYear){
				System.out.println(isRunYear+" 是闰年");
			}else{
				System.out.println(isRunYear+" 不是闰年");
			}
		}
		
		//计算年的总天数
		for(int i=1990;i<year;i++){
			if(i%400 == 0 || (i%4==0&i%100!=0)){
				total_days =+366;
			}else{
				total_days =+365;
			}
		}
		
		//计算输入月份的天数和
		for(int i =1;i<month;i++){
			
		}
		
		/**
		//获得月份的天数的方法一：使用多重if...else实现
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
		 * 获取月份天数的方法二：使用switch
		 * 以上的等值判断可以使用switch进行替代
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
				System.out.println("输入的月份不正确！");
		}
		//输出年的月的天数
		System.out.println(year+"年"+month+"月份的天数为:"+days);


	}

}
