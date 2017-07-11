package ArrayListCases;

public class ArrayForYanghui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 8;
		int [][]arr = new int[row][row];	//8行8列
		
		for(int i=0;i<row;i++){	//外循环构造第一维数组
			for(int j=0;j<=i;j++){	//内循环构造第一维数组指向的第二维数组，每一行的列数和行数相等
				//第一列(j=0)和对角线列(j=i)的值都为1
				if(j==0 || j==i){
					arr[i][j] = 1;
				}
				//非第一列和对角线列的数组元素值，是其正上方的数(arr[i-1][j])和其左上角的数(arr[i-1][j-1])之和
				else{
					arr[i][j] = arr[i-1][j]+arr[i-1][j-1];
				}
				
			}
		}
		
		//打印输出
		for(int i=0;i<row;i++){
			for(int j=0;j<=i;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

}
