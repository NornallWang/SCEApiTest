package ArrayListCases;

import java.util.Scanner;

public class ArrayDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//先声明、后创建一个数组
		int[] array = new int[3];	//array在栈中开辟一个空间，通过new关键字在堆里开辟了3个int类型数据大小的数值空间（即12个字节的空间：3*4）
		//int类型的默认值为0
		System.out.println("数组的长度为："+array.length);
		
		for(int i=0;i<3;i++){
			System.out.println("数组中的第"+i+"个数据为："+array[i]);
		}
		
		System.out.print("输出整个数组，数组中的值全部为自动初始化：\n"+"{");
		for(int i=0;i<3;i++){
			if(i!=array.length-1){
				System.out.print(array[i]+",");
			}else{
				System.out.print(array[i]+"}");
			}
		}
		

		/**
		 * 对数组中的元素进行赋值，通过下标来操作
		 * 第一个元素赋值为66
		 * 第二个元素赋值为77
		 * 第三个元素为默认初始化值，即为0
		 */
		array[0] =66;
		array[1] =77;
		
		System.out.print("\n赋值以后的数组为：（第三个元素依旧为默认初始化值）\n"+"{");
		for(int i=0;i<3;i++){
			if(i!=array.length-1){
				System.out.print(array[i]+",");
			}
			else{
				System.out.print(array[i]+"}");
			}
		}
		
		/**
		 * 通过for循环来统一遍历
		 */
		System.out.println("\n通过for循环遍历：");
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		
		/**
		 * 创建数组的同时做初始化
		 * 静态初始化
		 */
		int[] array2 = {10,20,30};
		System.out.print("静态初始化数组为："+"{");
		for(int i=0;i<array2.length;i++){
			if(i!=array2.length-1){
				System.out.print(array2[i]+",");
			}else{
				System.out.print(array2[i]+"}");
			}
		}
		
		/**
		 * 与上边方式一致的创建方式
		 */
		int[] array3 = new int[]{40,50,60};
		System.out.print("\narray3数组中的数据如下："+"{");
		for(int i=0;i<array3.length;i++){
			if(i!=array3.length-1){
				System.out.print(array3[i]+",");
			}else{
				System.out.print(array3[i]+"}");
			}
		}
		
		/**
		 * 动态赋值
		 */
		int[] array4 = new int[3];
		Scanner input = new Scanner(System.in);
		for(int i=0;i<array4.length;i++){
			array4[i] = input.nextInt();
		}
		System.out.print("\n array4数组中的数据如下："+"{");
		for(int i=0;i<array4.length;i++){
			if(i!=array3.length-1){
				System.out.print(array4[i]+",");
			}else{
				System.out.print(array4[i]+"}");
			}
		}
		
		
	}

}
