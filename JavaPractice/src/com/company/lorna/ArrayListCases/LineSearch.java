package com.company.lorna.ArrayListCases;

import java.util.Scanner;

public class LineSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//顺序查找
		int []arrayNumbers = {5,8,3,9,2,10};
		/*
		System.out.println("请输入要查找的数：");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		*/
		int number = 9;
		/*
		//数组中查找到的数的坐标；当查找不到时返回-1
		int index = -1;
		for(int i=0; i<arrayNumbers.length; i++){
			if(arrayNumbers[i] == index){
				index = i;
				break;
			}
		}
		*/
		int index = -1;
		for(int i=0; i<arrayNumbers.length; i++){
			if(number == arrayNumbers[i]){
				index = i;
				break;
			}
		}
		if(index != -1){
			System.out.println("目标数在数组中的第"+index+"个位置");
		}
		
	}

}
