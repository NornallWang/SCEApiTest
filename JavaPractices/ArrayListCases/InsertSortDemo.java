package ArrayListCases;

public class InsertSortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []insertArr = {20,15,7,9,2,0,18,22,19,8};
		//��δ����������ȡ���ڶ���ֵ��ΪҪ��������ݣ����ϸ�λ�õ����ݽ��бȽϣ�������ϸ�λ�õ�����С���򽻻�λ��
		for(int i=1;i<insertArr.length;i++){
			//����һ����ʱ���������ڶ���λ�û�ȡ����Ҫ��������ݱ�������
			int temp = insertArr[i];
			//�����±�
			int j = i;
			//ʹ���±������ֵ�ȶ�
			if(j>0&&temp<insertArr[j-1]){	//�±�������0����Ҫ�������ֵ���ϸ�λ�õ���ֵС���򽻻�λ��
				insertArr[j] = insertArr[j-1];
				//����ϱ��ж����ֵ����j--
				j--;
				//�������ݣ���temp�е�ֵ���뵽�±�Ϊj��λ��
				insertArr[j] = temp;
			}
			
		}

		//����ź��������
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
