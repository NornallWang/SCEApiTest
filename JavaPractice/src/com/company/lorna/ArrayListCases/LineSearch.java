package com.company.lorna.ArrayListCases;

import java.util.Scanner;

public class LineSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//˳�����
		int []arrayNumbers = {5,8,3,9,2,10};
		/*
		System.out.println("������Ҫ���ҵ�����");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		*/
		int number = 9;
		/*
		//�����в��ҵ����������ꣻ�����Ҳ���ʱ����-1
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
			System.out.println("Ŀ�����������еĵ�"+index+"��λ��");
		}
		
	}

}
