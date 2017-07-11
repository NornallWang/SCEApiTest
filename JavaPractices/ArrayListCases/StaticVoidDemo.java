package ArrayListCases;

public class StaticVoidDemo {
	
	//冒泡排序法:相邻的两个值进行比较
	/**
	 * @param bubbleArr
	 * 冒泡排序的特点：相邻的两个值进行比较，大的值下沉到最下边，小的上升；每一轮比较都会确定一个最大值，即：
	 * 外循环：比较次数为arr.length-1
	 * 内循环：比较次数为arr.length-i-1
	 */
	public static void bubbleSort(int[] bubbleArr){	
		for(int i=0;i<bubbleArr.length;i++){
			for(int j=0;j<bubbleArr.length-i-1;j++){
				if(bubbleArr[j]>bubbleArr[j+1]){
					int temp = bubbleArr[j]; //先将小的值存在临时变量temp中
					bubbleArr[j] = bubbleArr[j+1];	//由于bubbleArr[j+1]的值比bubbleArr[j]的值大，则将位置进行交换
					bubbleArr[j+1] = temp;	//然后将存储在temp中的bubbleArr[j]的值赋值给bubbleArr[j+1]的位置
				}
			}
		}
	}
	
	/**
	 * 插入排序法：通过构建有序序列，对于未排序数据，在已排序序列中向后往前扫描，找到相应位置并插入。在向后往前扫描的过程中，需要反复将已排序元素逐步往后挪动，为最新元素留出空间
	 */
	public static void insertSort(int[] insertArr){
		//从第二个位置取出数值作为要插入的数据，跟上边位置的数值进行比较
		for(int i=1;i<insertArr.length;i++){
			//定义一个变量将取出的要插入的数据保存起来
			int temp = insertArr[i];
			//保存下标
			int j = i;
			//如果下标大于0并且要插入的数据比上个位置的数据小，则交换位置
			if(j>0 && temp<insertArr[j-1]){
				//上边的数覆盖下边的数
				insertArr[j] = insertArr[j-1];
				//如果上边有多个数的话，则需要执行j--以让for循环进行遍历
				j--;
				//插入数据
				insertArr[j] = temp;
			}

		}

	}
	
	/**
	 * 选择排序法：首先在未排序的序列中找到最小值，存放到排序序列的第一位；
	 * 然后，再从未排序的序列中找到最小值，存放到排序序列的末尾
	 * 以此类推，直到所有数据排序完成
	 */
	public static void selectSort(int[] selectArr){
		//先声明一个变量，保存最小元素值的下标
		int min=0;
		//N个元素比较N-1轮
		for(int i=0;i<selectArr.length;i++){
			min = i;	//先假定最小值位于0的位置
			//查找最小数在数组中的下标
			for(int j=i+1;j<selectArr.length;j++){
				//
				if(selectArr[min]>selectArr[j]){
					//保存最小数的下标
					min = j;	
				}
			}
			//交换
			if(i!=min){
				int temp = selectArr[i];
				selectArr[i] = selectArr[min];
				selectArr[min] = temp;
			}
		}
	}
	
	/**
	 * 输出排序后的数组
	 * @param args
	 * 
	 */
	public static void printSortedArr(int[] sortedArr){
		System.out.print("{");
		for(int i=0;i<sortedArr.length;i++){
			if(i!=sortedArr.length-1){
				System.out.print(sortedArr[i]+",");
			}
			else{
				System.out.print(sortedArr[i]+"}");
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{9,1,2,0,4,3,8,7,10,5,6};
		
		System.out.println("\n冒泡排序后的数组为：");
		bubbleSort(arr);
		printSortedArr(arr);
		
		System.out.println("\n\n插入排序后的数组为：");
		insertSort(arr);
		printSortedArr(arr);
		
		System.out.println("\n\n选择排序后的数组为：");
		selectSort(arr);
		printSortedArr(arr);
	}

}
