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

//����Ĳ��ԣ�����
interface ISort{
	//�������������
	public abstract void sort(int[] array);
}

//����Ĳ�����һ����װð������
class BubbleSort implements ISort{
	//��д�ӿڵĳ��󷽷���ʵ�ֽӿڵķ���
	public void sort(int[] array){
		System.out.println("ð������");
		//�ⲿѭ��n-1��
		for(int i=0;i<array.length-1;i++){
			//��ѭ��n-1-i��
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

//����Ĳ����������װѡ������
class SelectSort implements ISort{
	//��д�ӿڵĳ��󷽷���ʵ�ֽӿڵķ���
	public void sort(int[] array){
		System.out.println("ѡ������");
		//�ȼ����һ������С��,�±���0
		int min = 0;
		
		for(int i=0;i<array.length;i++){
			//�����±�
			min = i;
			//�ж�
			for(int j=i+1;j<array.length;j++){
				if(array[min]>array[j]){
					min = j;
				}
			}
			//������С�������ڵ�һλ
			if(i!=min){
				//���������н���
				int temp=array[i];
				array[i]=array[min];
				array[min]=temp;
			}
			
		}
	}
}

//����Ĳ�����������������
class InsertSort implements ISort{
	//��д������ķ���
	public void sort(int[] array){
		System.out.println("��������");
		for(int i=1;i<array.length;i++){
			//����һ����ʱ���������ڶ���λ�û�ȡ����Ҫ��������ݱ�������
			int temp = array[i];
			//�����±�
			int j = i;
			//ʹ���±������ֵ�ȶ�
			if(j>0&&temp<array[j-1]){	//�±�������0����Ҫ�������ֵ���ϸ�λ�õ���ֵС���򽻻�λ��
				array[j] = array[j-1];
				//����ϱ��ж����ֵ����j--
				j--;
				//�������ݣ���temp�е�ֵ���뵽�±�Ϊj��λ��
				array[j] = temp;
			}
			
		}
	}
}

//ʹ�ò���
class Context{
	//���в���
	private ISort iSort= null;
	
	//���췽��
	public Context(ISort iSort){
		this.iSort = iSort;
	}
	
	//�������������
	public void sort(int[] array){
		//����������յ��Ĳ������������
		//���þ����sort����
		iSort.sort(array);
	}
	
	//��ӡ������ɺ������
	public void print(int[] array){
		//��ӡ�����е�����
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	
	//��ʽ������Ĵ�ӡ����
	
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