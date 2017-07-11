package ArrayListCases;

public class BubbleSortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {3,1,8,10,5,2,4,5,9,7,6};
		
		//N个元素比较的轮数为N-1
		for(int i=0;i<arr.length-1;i++){
			//每一轮比较的次数为N-1-i
			for(int j=0;j<arr.length-1-i;j++){
				//比较两个相邻的数，小的上升排序位置
				if(arr[j]>arr[j+1]){
					//两个数做交换，通过设置临时变量
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		//输出排序后的数组
		System.out.print("{");
		for(int i=0;i<arr.length;i++){
			if(i!=arr.length-1){
				System.out.print(arr[i]+",");
			}
			else{
				System.out.println(arr[i]+"}");
			}
		}
		
	}

}
