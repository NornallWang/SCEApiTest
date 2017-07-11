package com.company.lorna.ArrayListCases;

public class Yanghui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//声明行数
		int row = 8;
		//声明一个数组，8行8列
		int [][]arr = new int[row][row];
		//给二维数组的每一个数组进行赋值
		//外循环给第一维数组进行赋值
		for(int i=0;i<row;i++){
			//内循环给第一维数组指向的第二维数组进行赋值
			for(int j=0;j<=i;j++){
				//第一列和对角线列的元素的值恒等于1
				if(j==0||j==i){
					arr[i][j] = 1;
				}else{	//非对角线和第一列的元素的值，是其正上方和其左上方元素之和
					arr[i][j] = arr[i-1][j]+arr[i-1][j-1];	//正上方：行数减1，同一列，即arr[i-1][j]；左上方：arr[i-1][j-1]
				}	
			}
		}
		
		//打印输出
		for(int i=0;i<row;i++){
			for(int j=0;j<=i;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
