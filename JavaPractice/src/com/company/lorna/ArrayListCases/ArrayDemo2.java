package com.company.lorna.ArrayListCases;

public class ArrayDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//声明一个二维数组
		int [][]arr = new int[3][];
		//每个高维的数组指向一个低维的整形数组
		arr[0] = new int[2];
		arr[1] = new int[3];
		arr[2] = new int[4];
		//为低维的数组进行赋值
		arr[0][0] = 1;
		arr[0][1] = 2;
		
		arr[1][0] = 3;
		arr[1][1] = 4;
		arr[1][2] = 5;
		
		arr[2][0] = 6;
		arr[2][1] = 7;
		arr[2][2] = 8;
		arr[2][3] = 9;
		
		System.out.print("二维数组输入如下：\n"+"{");
		for(int i=0;i<arr.length;i++){
			System.out.print("{");
			for(int j=0;j<arr[i].length;j++){
				if(j!=arr[i].length-1){
					System.out.print(arr[i][j]+",");
				}else if(i!=arr.length-1){
					System.out.print(arr[i][j]+"},");
				}
				else{
					System.out.print(arr[i][j]+"}");
				}
			}
		}
		System.out.print("}");
		
	}

}
