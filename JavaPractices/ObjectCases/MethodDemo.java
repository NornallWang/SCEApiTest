package ObjectCases;

public class MethodDemo {
	
	//打印数组的方法，返回类型为空的且无参数
	public void method1(){
		System.out.println("返回类型为空且无参数");
	}

	//带有具体返回类型的方法，返回类型为String且无参数
	public String method2(){
		return "带有具体返回类型且无参数的方法";	//返回的数据类型必须和声明的方法的数据类型一致
	}
	
	//返回类型为空且带有参数的方法
	public void method3(String name){
		System.out.println("返回类型为空且带有参数的方法，参数的值为："+name);
	}
	
	//
	public String method4(String name, int age){
		return "带有具体返回类型且带有多个参数的方法，参数的值为：name="+name+",age为："+age;
	}
	
	//传递基本数据类型
	public void opperateData(int age){
		age++;
		System.out.println(age);
	}
	
	//传递引用数据类型
	public void operateArr(int[] array){
		array[0] = 100;
		System.out.println(array[0]);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MethodDemo methodDemo = new MethodDemo();
		methodDemo.method1();
		System.out.println(methodDemo.method2());
		methodDemo.method3("John");
		System.out.println(methodDemo.method4("Lorna", 8));
		
		int age =10;
		methodDemo.opperateData(age);
		System.out.println(age);
		
		//调用
		int[] array = {1,2,3,4};
		methodDemo.operateArr(array);
		System.out.println(array[2]);
	
	}

}
