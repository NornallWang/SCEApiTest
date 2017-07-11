package ArrayListCases;

public class StaticVoidDemo {
	
	//ð������:���ڵ�����ֵ���бȽ�
	/**
	 * @param bubbleArr
	 * ð��������ص㣺���ڵ�����ֵ���бȽϣ����ֵ�³������±ߣ�С��������ÿһ�ֱȽ϶���ȷ��һ�����ֵ������
	 * ��ѭ�����Ƚϴ���Ϊarr.length-1
	 * ��ѭ�����Ƚϴ���Ϊarr.length-i-1
	 */
	public static void bubbleSort(int[] bubbleArr){	
		for(int i=0;i<bubbleArr.length;i++){
			for(int j=0;j<bubbleArr.length-i-1;j++){
				if(bubbleArr[j]>bubbleArr[j+1]){
					int temp = bubbleArr[j]; //�Ƚ�С��ֵ������ʱ����temp��
					bubbleArr[j] = bubbleArr[j+1];	//����bubbleArr[j+1]��ֵ��bubbleArr[j]��ֵ����λ�ý��н���
					bubbleArr[j+1] = temp;	//Ȼ�󽫴洢��temp�е�bubbleArr[j]��ֵ��ֵ��bubbleArr[j+1]��λ��
				}
			}
		}
	}
	
	/**
	 * �������򷨣�ͨ�������������У�����δ�������ݣ��������������������ǰɨ�裬�ҵ���Ӧλ�ò����롣�������ǰɨ��Ĺ����У���Ҫ������������Ԫ��������Ų����Ϊ����Ԫ�������ռ�
	 */
	public static void insertSort(int[] insertArr){
		//�ӵڶ���λ��ȡ����ֵ��ΪҪ��������ݣ����ϱ�λ�õ���ֵ���бȽ�
		for(int i=1;i<insertArr.length;i++){
			//����һ��������ȡ����Ҫ��������ݱ�������
			int temp = insertArr[i];
			//�����±�
			int j = i;
			//����±����0����Ҫ��������ݱ��ϸ�λ�õ�����С���򽻻�λ��
			if(j>0 && temp<insertArr[j-1]){
				//�ϱߵ��������±ߵ���
				insertArr[j] = insertArr[j-1];
				//����ϱ��ж�����Ļ�������Ҫִ��j--����forѭ�����б���
				j--;
				//��������
				insertArr[j] = temp;
			}

		}

	}
	
	/**
	 * ѡ�����򷨣�������δ������������ҵ���Сֵ����ŵ��������еĵ�һλ��
	 * Ȼ���ٴ�δ������������ҵ���Сֵ����ŵ��������е�ĩβ
	 * �Դ����ƣ�ֱ�����������������
	 */
	public static void selectSort(int[] selectArr){
		//������һ��������������СԪ��ֵ���±�
		int min=0;
		//N��Ԫ�رȽ�N-1��
		for(int i=0;i<selectArr.length;i++){
			min = i;	//�ȼٶ���Сֵλ��0��λ��
			//������С���������е��±�
			for(int j=i+1;j<selectArr.length;j++){
				//
				if(selectArr[min]>selectArr[j]){
					//������С�����±�
					min = j;	
				}
			}
			//����
			if(i!=min){
				int temp = selectArr[i];
				selectArr[i] = selectArr[min];
				selectArr[min] = temp;
			}
		}
	}
	
	/**
	 * �������������
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
		
		System.out.println("\nð������������Ϊ��");
		bubbleSort(arr);
		printSortedArr(arr);
		
		System.out.println("\n\n��������������Ϊ��");
		insertSort(arr);
		printSortedArr(arr);
		
		System.out.println("\n\nѡ������������Ϊ��");
		selectSort(arr);
		printSortedArr(arr);
	}

}
