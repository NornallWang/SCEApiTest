package InterfaceCases;

public class StrategyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array={5,9,0,1,8,3,4,7,6};
			
		ISort selectSort = new SelectSort();
		Context contextSelect = new Context(selectSort);
		contextSelect.sort(array);
		//contextSelect.print(array);
		contextSelect.printArray(array);
		
		System.out.println();
		
		ISort bubbleSort = new BubbleSort();
		Context contextBubble = new Context(bubbleSort);
		contextBubble.sort(array);
		//context.print(array);
		contextBubble.printArray(array);
		
		System.out.println();
		
		ISort insertSort = new InsertSort();
		Context contextInsert = new Context(insertSort);
		contextInsert.sort(array);
		contextInsert.printArray(array);

	}

}

//抽象的策略，责任
interface ISort{
	//对数组进行排序
	public abstract void sort(int[] array);
}

//具体的策略类一：封装冒牌排序法
class BubbleSort implements ISort{
	//重写接口的抽象方法，实现接口的方法
	public void sort(int[] array){
		System.out.println("冒泡排序法");
		//外部循环n-1次
		for(int i=0;i<array.length-1;i++){
			//内循环n-1-i次
			for(int j=0;j<array.length-1-i;j++){
				if(array[j]>array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}

//具体的策略类二：封装选择排序法
class SelectSort implements ISort{
	//重写接口的抽象方法，实现接口的方法
	public void sort(int[] array){
		System.out.println("选择排序法");
		//先假设第一个是最小的,下标是0
		int min = 0;
		
		for(int i=0;i<array.length;i++){
			//保存下标
			min = i;
			//判断
			for(int j=i+1;j<array.length;j++){
				if(array[min]>array[j]){
					min = j;
				}
			}
			//假设最小的数不在第一位
			if(i!=min){
				//两个数进行交换
				int temp=array[i];
				array[i]=array[min];
				array[min]=temp;
			}
			
		}
	}
}

//具体的策略类三：插入排序法
class InsertSort implements ISort{
	//重写抽象类的方法
	public void sort(int[] array){
		System.out.println("插入排序法");
		for(int i=1;i<array.length;i++){
			//定义一个临时变量，将第二个位置获取到的要插入的数据保存起来
			int temp = array[i];
			//保存下标
			int j = i;
			//使用下标进行数值比对
			if(j>0&&temp<array[j-1]){	//下标必须大于0并且要插入的数值比上个位置的数值小，则交换位置
				array[j] = array[j-1];
				//如果上边有多个数值，则j--
				j--;
				//插入数据，将temp中的值插入到下标为j的位置
				array[j] = temp;
			}
			
		}
	}
}

//使用策略
class Context{
	//持有策略
	private ISort iSort= null;
	
	//构造方法
	public Context(ISort iSort){
		this.iSort = iSort;
	}
	
	//对数组进行排序
	public void sort(int[] array){
		//交给具体接收到的策略类进行排序
		//调用具体的sort方法
		iSort.sort(array);
	}
	
	//打印排序完成后的数组
	public void print(int[] array){
		//打印数组中的内容
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	
	//正式的数组的打印方法
	
	public void printArray(int[] array){
		System.out.print("{");
		for(int i=0;i<array.length;i++){
			if(i!=array.length-1){
				System.out.print(array[i]+",");
			}else{
				System.out.println(array[i]+"}");
			}
		}
	}
}