package com.company.lorna.ArrayListCases;

public class MaxMinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�������Բ��ң�˳����ң��������ֵ����Сֵ
		
		int []arr = {9,0,1,4,2,3,5,10};
		//��ʼ��һ�����ֵ
		int max = arr[0];
		//��ʼ��һ����Сֵ
		int min = arr[0];
		
		for(int i=0;i<arr.length;i++){
			if(max<arr[i]){
				max = arr[i];
			}
			
			if(min>arr[i]){
				min = arr[i];
			}
		}
		
		System.out.println("���������ֵΪ��"+max);
		System.out.println("��������СֵΪ��"+min);

	}

}
