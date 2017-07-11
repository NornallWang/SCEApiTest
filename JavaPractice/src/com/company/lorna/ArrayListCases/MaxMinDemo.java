package com.company.lorna.ArrayListCases;

public class MaxMinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//数组线性查找（顺序查找）：找最大值和最小值
		
		int []arr = {9,0,1,4,2,3,5,10};
		//初始化一个最大值
		int max = arr[0];
		//初始化一个最小值
		int min = arr[0];
		
		for(int i=0;i<arr.length;i++){
			if(max<arr[i]){
				max = arr[i];
			}
			
			if(min>arr[i]){
				min = arr[i];
			}
		}
		
		System.out.println("数组中最大值为："+max);
		System.out.println("数组中最小值为："+min);

	}

}
