package InterfaceCases;

/**
 * 学校内部安装了黑白打印机或者彩色打印机，通过其所安装的打印机，既可以打印教员的详细信息，也可以打印学校内部的详细信息
 * @author Nornall
 *
 */
public class PrinterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//以多态的形式给继承类分别定义堆内存空间
		Printer colorPrinter = new ColorPrinter("惠普");
		colorPrinter.print("我是彩色打印机哦！！！");
		
		Printer blackPrinter = new BlackPrinter("戴尔");
		blackPrinter.print("我是黑白打印机哦！！！");
		
		School school = new School();
		school.setPrinter(blackPrinter);
		//school.print("我是教学中心的黑白打印机");
		
		school.setPrinter(colorPrinter);
		//school.print("我是教学中心的彩色打印机");
		
		//打印教员详细信息
		Teachers teacher = new Teachers("张三",30);
		school.print(teacher);
		
		//打印教学中心的详细信息
		school.print(school);
	}

}

abstract class Printer{
	private String brand;
	
	//构造方法初始化变量
	public Printer(String brand){
		this.brand = brand;
	}
	
	//因为brand为私有属性，不能在其他类中直接调用，为了方便其他类调用，创建getBrand()方法
	public String getBrand(){
		return brand;
	}
	
	//定义一个抽象方法，具体的实现由其子类实现
	public abstract void print(String content);
}

//定义一个彩色打印机
class ColorPrinter extends Printer{
	//调用父类的构造方法
	public ColorPrinter(String brand){
		super(brand);
	}
	
	//父类抽象方法的具体实现
	public void print(String content){
		System.out.println(getBrand()+"的打印机打印了如有的内容："+content);
	}
}

//定义一个黑白打印机
class BlackPrinter extends Printer{
	//调用父类的构造方法
	public BlackPrinter(String brand){
		super(brand);
	}
	
	//父类抽象方法的具体实现
	public void print(String content){
		System.out.println(getBrand()+"的打印机打印了右边的内容："+content);
	}
}

//定义一个school类，同时安装了黑白和彩色打印机
class School implements IInfo{
	//将Printer引用变量作为school类的私有属性并初始化
	private Printer printer = null;
	
	//定义一个安装打印机的方法
	public void setPrinter(Printer printer){
		this.printer = printer;
	}
	
	/*
	public void print(String content){
		//交给学校的打印机进行打印
		printer.print(content);
	}
	*/
	//将以上print方法以多态的形式进行实现
	//程序设计的时候主体框架使用接口或者抽象类，可以使程序有很好的扩展性和可维护性
	public void print(IInfo info){
		printer.print(info.detail());
	}
	
	//因为implements了IInfo接口，所以需要将其抽象方法detail进行具体实现
	public String detail(){
		return "你好，这里是Goyoo教学中心";
	}
}

//定义一个教员类
class Teachers implements IInfo{
	//定义教员的私有属性
	private String name;
	private int age;
	
	//构造方法初始化属性
	public Teachers(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	//因为implements了IInfo接口，所以需要将其detail抽象方法进行具体实现
	public String detail(){
		return "你好，我是Goyoo的名为： "+name+" 的教员，年龄为： "+age+" !!";
	}
}

//定义一个接口，用于输出详细信息（教员和中心两个类的）
interface IInfo{
	//接口中只允许定义抽象方法和公有的静态常量
	public abstract String detail();
}