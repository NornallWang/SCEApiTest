package ArrayListCases;

public class ArrayForYanghui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 8;
		int [][]arr = new int[row][row];	//8��8��
		
		for(int i=0;i<row;i++){	//��ѭ�������һά����
			for(int j=0;j<=i;j++){	//��ѭ�������һά����ָ��ĵڶ�ά���飬ÿһ�е��������������
				//��һ��(j=0)�ͶԽ�����(j=i)��ֵ��Ϊ1
				if(j==0 || j==i){
					arr[i][j] = 1;
				}
				//�ǵ�һ�кͶԽ����е�����Ԫ��ֵ���������Ϸ�����(arr[i-1][j])�������Ͻǵ���(arr[i-1][j-1])֮��
				else{
					arr[i][j] = arr[i-1][j]+arr[i-1][j-1];
				}
				
			}
		}
		
		//��ӡ���
		for(int i=0;i<row;i++){
			for(int j=0;j<=i;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

}
