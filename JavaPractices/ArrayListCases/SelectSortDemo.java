package ArrayListCases;

public class SelectSortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {3,1,10,8,9,4,6,5,2,7};
		
		//����һ��������������Сֵ���±�
		int min=0;
		//N�����Ƚ�N-1�֣�NΪ����ĳ���arr.length
		for(int i=0; i<arr.length-1;i++){
			min = i; //�ȼٶ���һ��ֵΪ��Сֵ
			
			//����Сֵ��Ӧ���±�
			for(int j=i+1;j<arr.length;j++){
				if(arr[min]>arr[j]){
					min = j; //������Сֵ���±�
				}
			}
			
			//��i����Сֵ������λ�ò���i�ϣ�����н������ҵ�����λ�ý���
			if(i != min){
				int temp = arr[i];
				arr[i] = arr[min]; //����Сֵ����
				arr[min] = temp; 
			}	
		}
		
		//�������������
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
