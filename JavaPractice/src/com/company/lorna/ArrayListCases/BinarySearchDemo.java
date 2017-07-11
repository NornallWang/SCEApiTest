package com.company.lorna.ArrayListCases;

public class BinarySearchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//二分查找法必须是有序数组，也叫折半查找
		int []arr = {1,2,3,4,5,8,9,10,11};
		//目标查找的数字
		int number = 8;
		//保存在数组中找到的数所在的下标；如果找不到，则返回-1
		int index = -1;
		//起始下标
		int start = 0;
		//终止下标
		int end = arr.length-1;
		int middle;
		
		while(start<=end){
			//找到中间下标所对应的元素值
			middle = (start+end)/2;
			if(number == middle){
				//刚好找到，则保存找到的位置
				index = middle;
				break;
			}
			//假如要查找的数大于middle，则去掉左边数组
			if(number > middle){
				index = middle+1;
			}
			
			//假如要查找的数小于middle，则去掉右边的数组
			if(number < middle){
				index = middle-1;
			}
			
			//假设index=-1，则说明没有找到；反之找到
			if(index == -1){
				System.out.println("Not Found!");
			}else{
				System.out.println("找到了，在数组的第"+index+"个位置！");
			}
		}
		
		
	}

}
