package InterfaceCases;

public class FactoryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//调用Factory类中的静态方法，返回值用接口的引用变量来接收.即只要实现这个接口的水果，它都可以接收
		IFruit fruit = Factory.getName("苹果");
		if(fruit!=null){
			System.out.println(fruit.get());
		}else{
			System.out.println("sorry，您要的苹果不存在");
		}
		
		IFruit fruit2 = Factory.getName("橘子");
		if(fruit2!=null){
			System.out.println(fruit2.get());
		}else{
			System.out.println("Sorry,您要的橘子不存在");
		}
		
		IFruit fruit3 = Factory.getName("梨子");
		if(fruit3!=null){
			System.out.println(fruit3.get());
		}else{
			System.out.println("Sorry，您要的梨子不存在");
		}
	}

}

//定义一个接口Fruit
interface IFruit{
	//定义一个抽象方法
	public abstract String get();
}

//定义一个Apple类
class Apple implements IFruit{
	//实现IFruit接口中的抽象方法get()
	public String get(){
		return "采摘苹果！！";
	}
}

//定义一个Orange类
class Orange implements IFruit{
	//实现IFruit接口中的抽象方法get()
	public String get(){
		return "采摘橘子！！";
	}
}

//定义一个工厂类，用来创建其他类的具体实例
class Factory{
	public static IFruit getName(String name){
		if(name.equals("苹果")){
			//IFruit的多态实现
			return new Apple();
		}else if(name.equals("橘子")){
			return new Orange();
		}else{
			return null;
		}
	}
}
