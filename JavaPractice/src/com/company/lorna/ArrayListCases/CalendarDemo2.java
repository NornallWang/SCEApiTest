package com.company.lorna.ArrayListCases;

public class CalendarDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int year = 2017;	//变量yeaar保存要展示的年
		int month = 5;		//变量month保存要展示的年的月份
		int totalDays = 0;	//变量totalDays保存年的总天数，先初始化为0
		int days = 0;		//变量days保存月的总天数，先初始化为0
		boolean isRun;		//当变量为True的时候为闰年，false的时候为非闰年
		
		//判断年是否为闰年的公式（i%400==0 ）或者（i%4==0&&i%100!=0）
		if(year%400==0 ||(year%4==0&&year%100!=0)){
			isRun = true;
		}else{
			isRun = false;
		}
		
		//计算年的总天数
		for(int i=1990;i<year;i++){
			if(isRun){
				totalDays+=366;
			}else{
				totalDays+=365;
			}
		}
		
		//计算月的天数和
		for(int i=1;i<=month;i++){
			//使用switch做等值判断
			//如果月份为1、3、5、7、8、10、12，则每月天数为31；
			//如果月份为闰年2月份，则该月天数为29；非闰年，则该月天数为28；
			//如果月份为4、6、9、11，则每月天数为30
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
				System.out.println("目标月份不符合常理！");
			}
			
			//输入月的天数保存到days变量中，不累加到总天数中
			if(i!=month){
				totalDays +=days;
			}
			
		}
		
		//求出是星期几，公式其实就是前边的制表符\t的个数
		int beforeDays;	//保存星期几，保存的是\t的个数
		//取星期几的公式
		beforeDays = 1+totalDays%7;
		//星期天前边的\t为0
		if(beforeDays == 7){
			beforeDays = 0;	//代表星期天
		}
		//打印出星期几，按照格式
		System.out.println("星期天\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");	//日历的头
		for(int i=0;i<beforeDays;i++){
			//先打印出\t
			System.out.print("\t");
		}
		//打印天数
		for(int i=1;i<=days;i++){
			System.out.print(i+"\t");
			//满7个换行
			if((i+beforeDays)%7==0){
				System.out.println();
			}
		}
		
	}

}
