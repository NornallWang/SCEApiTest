package ArrayListCases;

import java.util.Scanner;

public class ArrayDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���������󴴽�һ������
		int[] array = new int[3];	//array��ջ�п���һ���ռ䣬ͨ��new�ؼ����ڶ��￪����3��int�������ݴ�С����ֵ�ռ䣨��12���ֽڵĿռ䣺3*4��
		//int���͵�Ĭ��ֵΪ0
		System.out.println("����ĳ���Ϊ��"+array.length);
		
		for(int i=0;i<3;i++){
			System.out.println("�����еĵ�"+i+"������Ϊ��"+array[i]);
		}
		
		System.out.print("����������飬�����е�ֵȫ��Ϊ�Զ���ʼ����\n"+"{");
		for(int i=0;i<3;i++){
			if(i!=array.length-1){
				System.out.print(array[i]+",");
			}else{
				System.out.print(array[i]+"}");
			}
		}
		

		/**
		 * �������е�Ԫ�ؽ��и�ֵ��ͨ���±�������
		 * ��һ��Ԫ�ظ�ֵΪ66
		 * �ڶ���Ԫ�ظ�ֵΪ77
		 * ������Ԫ��ΪĬ�ϳ�ʼ��ֵ����Ϊ0
		 */
		array[0] =66;
		array[1] =77;
		
		System.out.print("\n��ֵ�Ժ������Ϊ����������Ԫ������ΪĬ�ϳ�ʼ��ֵ��\n"+"{");
		for(int i=0;i<3;i++){
			if(i!=array.length-1){
				System.out.print(array[i]+",");
			}
			else{
				System.out.print(array[i]+"}");
			}
		}
		
		/**
		 * ͨ��forѭ����ͳһ����
		 */
		System.out.println("\nͨ��forѭ��������");
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		
		/**
		 * ���������ͬʱ����ʼ��
		 * ��̬��ʼ��
		 */
		int[] array2 = {10,20,30};
		System.out.print("��̬��ʼ������Ϊ��"+"{");
		for(int i=0;i<array2.length;i++){
			if(i!=array2.length-1){
				System.out.print(array2[i]+",");
			}else{
				System.out.print(array2[i]+"}");
			}
		}
		
		/**
		 * ���ϱ߷�ʽһ�µĴ�����ʽ
		 */
		int[] array3 = new int[]{40,50,60};
		System.out.print("\narray3�����е��������£�"+"{");
		for(int i=0;i<array3.length;i++){
			if(i!=array3.length-1){
				System.out.print(array3[i]+",");
			}else{
				System.out.print(array3[i]+"}");
			}
		}
		
		/**
		 * ��̬��ֵ
		 */
		int[] array4 = new int[3];
		Scanner input = new Scanner(System.in);
		for(int i=0;i<array4.length;i++){
			array4[i] = input.nextInt();
		}
		System.out.print("\n array4�����е��������£�"+"{");
		for(int i=0;i<array4.length;i++){
			if(i!=array3.length-1){
				System.out.print(array4[i]+",");
			}else{
				System.out.print(array4[i]+"}");
			}
		}
		
		
	}

}
