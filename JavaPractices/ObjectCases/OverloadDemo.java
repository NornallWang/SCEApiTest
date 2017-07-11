package ObjectCases;

public class OverloadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Printer p = new Printer();
//		p.print("字符串");
//		p.print(80);
//		p.print("字符串", 80);
		
		//构造方法调用
		Printer p = new Printer();
		p.print(1000);
		p.print("惠普");
		p.print("戴尔", 888);
		
	}

}

class Printer{
	private String brand;
	private double price;
	
	//系统默认构造方法
	public Printer(){
		System.out.println("这是系统默认构造方法！");
	}
	//构造方法
	public Printer(String brand){
		this.brand = brand;
	}
	//上边构造方法的重载方法
	public Printer(String brand, double price){
		this.brand = brand;
		this.price = price;
	}
	
	public void print(String content){
		System.out.println("参数列表为一个string类型的内容："+content);
	}
	public void print(int number){
		System.out.println("参数列表为一个int类型的内容："+number);
	}
	public void print(String content, int number){
		System.out.println("参数列表为string类型的content："+content+"，和int类型的number"+number);
	}
}
