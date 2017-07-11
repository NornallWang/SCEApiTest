package ArrayListCases;

public class SelectSortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {3,1,10,8,9,4,6,5,2,7};
		
		//声明一个变量，保存最小值的下标
		int min=0;
		//N个数比较N-1轮，N为数组的长度arr.length
		for(int i=0; i<arr.length-1;i++){
			min = i; //先假定第一个值为最小值
			
			//找最小值对应的下标
			for(int j=i+1;j<arr.length;j++){
				if(arr[min]>arr[j]){
					min = j; //保存最小值的下标
				}
			}
			
			//第i个最小值的数，位置不在i上，则进行交换。找到后做位置交换
			if(i != min){
				int temp = arr[i];
				arr[i] = arr[min]; //跟最小值交换
				arr[min] = temp; 
			}	
		}
		
		//输出排序后的数组
		System.out.print("{");
		for(int i=0;i<arr.length;i++){
			if(i != arr.length-1){
				System.out.print(arr[i]+",");
			}
			else{
				System.out.print(arr[i]+"}");
			}
		}

	}

}
