package com.company.lorna.ArrayListCases;

public class BinarySearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//���ֲ��ҷ��������������飬Ҳ���۰����
		int []arr = {1,2,3,4,5,8,9,10,11};
		//Ŀ����ҵ�����
		int number = 8;
		//�������������ҵ��������ڵ��±ꣻ����Ҳ������򷵻�-1
		int index = -1;
		//��ʼ�±�
		int start = 0;
		//��ֹ�±�
		int end = arr.length-1;
		int middle;
		
		while(start<=end){
			//�ҵ��м��±�����Ӧ��Ԫ��ֵ
			middle = (start+end)/2;
			if(number == middle){
				//�պ��ҵ����򱣴��ҵ���λ��
				index = middle;
				break;
			}
			//����Ҫ���ҵ�������middle����ȥ���������
			if(number > middle){
				index = middle+1;
			}
			
			//����Ҫ���ҵ���С��middle����ȥ���ұߵ�����
			if(number < middle){
				index = middle-1;
			}
			
			//����index=-1����˵��û���ҵ�����֮�ҵ�
			if(index == -1){
				System.out.println("Not Found!");
			}else{
				System.out.println("�ҵ��ˣ�������ĵ�"+index+"��λ�ã�");
			}
		}
		
		
	}

}
