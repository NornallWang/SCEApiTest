package com.company.lorna.ArrayListCases;

public class Yanghui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		int row = 8;
		//����һ�����飬8��8��
		int [][]arr = new int[row][row];
		//����ά�����ÿһ��������и�ֵ
		//��ѭ������һά������и�ֵ
		for(int i=0;i<row;i++){
			//��ѭ������һά����ָ��ĵڶ�ά������и�ֵ
			for(int j=0;j<=i;j++){
				//��һ�кͶԽ����е�Ԫ�ص�ֵ�����1
				if(j==0||j==i){
					arr[i][j] = 1;
				}else{	//�ǶԽ��ߺ͵�һ�е�Ԫ�ص�ֵ���������Ϸ��������Ϸ�Ԫ��֮��
					arr[i][j] = arr[i-1][j]+arr[i-1][j-1];	//���Ϸ���������1��ͬһ�У���arr[i-1][j]�����Ϸ���arr[i-1][j-1]
				}	
			}
		}
		
		//��ӡ���
		for(int i=0;i<row;i++){
			for(int j=0;j<=i;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
