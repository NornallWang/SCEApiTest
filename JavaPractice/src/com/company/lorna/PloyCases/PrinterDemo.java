package com.company.lorna.PloyCases;

public class PrinterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ColorPrinter colorPinter = new ColorPrinter("惠普");
		//colorPinter.print("这是打印内容！！！");
				
		School school = new School();
		//先安装彩色打印机
		//school.setColorPrinter(colorPinter);
		//school.print("打印内容！！");
		
		System.out.println("********************");
		//BlackPrinter blackp = new BlackPrinter("戴尔");
		//school.setBlackPrinter(blackp);
		//school.print("打印内容");
		
		//ZhenPrinter zhenp = new ZhenPrinter("针式");
		//school.setZhenPrinter(zhenp);
		//school.print("打印内容");
		
		/*
		 * 多态的使用，低耦合，可维护性高，后续添加其他的打印机，不需要再School类中添加额外的代码，比如添加3D打印机
		 */
		Printer printer2c = new ColorPrinter("惠普");
		printer2c.print("This is Content\n");
		
		Printer printer2b = new BlackPrinter("戴尔");
		printer2b.print("This is content\n");
		
		Printer printer2z = new ZhenPrinter("针式");
		printer2z.print("This is content\n");
		
		//使用多态机制，将另外增加的3D打印机打印内容输出
		Printer printer3D = new Printer3D("普拉斯");
		printer3D.print("This is content");
	}

}

//定义一个父类打印机
class Printer{
	private String brand;
	
	public Printer(String brand){
		System.out.println("父类Printer的构造方法！！");
		this.brand = brand;
	}
	
	public void print(String content){
		System.out.println("父类Printer的方法！");
	}
	
	//因为brand属性是私有的，所以不能被其他的类的方法直接使用，所以使用set方法将其返回
	public String getBrand(){
		return brand;
	}
}

/*
//学校和黑白、彩色打印机两个类是主和关系
class School{
	//使用引用对象作为属性
	private ColorPrinter colorp = null;
	private BlackPrinter blackp = null;
	//因为另外增加了一台针式打印机，所以还需要添加该属性
	private ZhenPrinter zhenp = null;
	
	//安装彩色打印机
	public void setColorPrinter(ColorPrinter cp){
		this.colorp = cp;
	}
	
	//安装黑白打印机
	public void setBlackPrinter(BlackPrinter bp){
		this.blackp = bp;
	}
	
	//增加针式打印机
	public void setZhenPrinter(ZhenPrinter zp){
		this.zhenp = zp;
	}
	
	//使用学校安装的打印机进行打印
	public void print(String content){
		//比如：使用学校安装的彩色打印机进行打印
		//colorp.print(content);
		//使用学校安装的黑白打印机进行打印
		//blackp.print(content);
		zhenp.print(content);
	}

}
*/

/*
 * 如果以后还有其他打印机，就需要增加该打印机的类、并向School类中增加它的属性和方法，耦合性非常低，不便于维护，扩展性和维护性非常差
 * 
 * 开闭原则：对修改是封闭的，对扩展是开放的；一个类从一开始被设计好，就不能被修改
 * 
 * 可以使用多态来解决问题：父类的引用变量可以引用其子类的对象
 * 
 * 因此以上代码中的School类可以这样实现
 */
class School{
	//安装打印机，使用父类对象
	private Printer printer = null;
	
	//给学校安装打印机的方法，拿父类的引用变量作为参数，好处就是可以接受其任何子类的对象
	public void setPrinter(Printer p){
		this.printer = p;
	}
	
	//使用学校的打印机
	public void printer(String content){
		printer.print(content);
	}
}

//彩色打印机
class ColorPrinter extends Printer{
	public ColorPrinter(String brand){
		super(brand);
	}
	
	public void print(String content){
		System.out.println(getBrand()+"彩色打印机："+content);
	}
}

//黑白打印机
class BlackPrinter extends Printer{
	public BlackPrinter(String brand){
		super(brand);
	}
	
	public void print(String content){
		System.out.println(getBrand()+"黑白打印机："+content);
	}
}

//添加一台针式打印机
class ZhenPrinter extends Printer{
	public ZhenPrinter(String brand){
		super(brand);
	}
	
	public void print(String content){
		System.out.println(getBrand()+"针式打印机："+content);
	}
}

//使用多态以后，再添加一台3D打印机
class Printer3D extends Printer{
	public Printer3D(String brand){
		super(brand);
	}
	
	public void print(String content){
		System.out.println(getBrand()+"3D打印机："+content);
	}
}