package ArrayListCases;

public class InsertSortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []insertArr = {20,15,7,9,2,0,18,22,19,8};
		//在未排序序列中取出第二个值作为要插入的数据，跟上个位置的数据进行比较，如果比上个位置的数据小，则交换位置
		for(int i=1;i<insertArr.length;i++){
			//定义一个临时变量，将第二个位置获取到的要插入的数据保存起来
			int temp = insertArr[i];
			//保存下标
			int j = i;
			//使用下标进行数值比对
			if(j>0&&temp<insertArr[j-1]){	//下标必须大于0并且要插入的数值比上个位置的数值小，则交换位置
				insertArr[j] = insertArr[j-1];
				//如果上边有多个数值，则j--
				j--;
				//插入数据，将temp中的值插入到下标为j的位置
				insertArr[j] = temp;
			}
			
		}

		//输出排好序的数组
		System.out.print("{");
		for(int i=0;i<insertArr.length;i++){
			if(i != insertArr.length-1){
				System.out.print(insertArr[i]+",");
			}
			else{
				System.out.print(insertArr[i]+"}");
			}
		}
	}

}
