package ArrayListCases;

public class BubbleSortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {3,1,8,10,5,2,4,5,9,7,6};
		
		//N��Ԫ�رȽϵ�����ΪN-1
		for(int i=0;i<arr.length-1;i++){
			//ÿһ�ֱȽϵĴ���ΪN-1-i
			for(int j=0;j<arr.length-1-i;j++){
				//�Ƚ��������ڵ�����С����������λ��
				if(arr[j]>arr[j+1]){
					//��������������ͨ��������ʱ����
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		//�������������
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
