package InterfaceCases;

public class FactoryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Factory���еľ�̬����������ֵ�ýӿڵ����ñ���������.��ֻҪʵ������ӿڵ�ˮ�����������Խ���
		IFruit fruit = Factory.getName("ƻ��");
		if(fruit!=null){
			System.out.println(fruit.get());
		}else{
			System.out.println("sorry����Ҫ��ƻ��������");
		}
		
		IFruit fruit2 = Factory.getName("����");
		if(fruit2!=null){
			System.out.println(fruit2.get());
		}else{
			System.out.println("Sorry,��Ҫ�����Ӳ�����");
		}
		
		IFruit fruit3 = Factory.getName("����");
		if(fruit3!=null){
			System.out.println(fruit3.get());
		}else{
			System.out.println("Sorry����Ҫ�����Ӳ�����");
		}
	}

}

//����һ���ӿ�Fruit
interface IFruit{
	//����һ�����󷽷�
	public abstract String get();
}

//����һ��Apple��
class Apple implements IFruit{
	//ʵ��IFruit�ӿ��еĳ��󷽷�get()
	public String get(){
		return "��ժƻ������";
	}
}

//����һ��Orange��
class Orange implements IFruit{
	//ʵ��IFruit�ӿ��еĳ��󷽷�get()
	public String get(){
		return "��ժ���ӣ���";
	}
}

//����һ�������࣬��������������ľ���ʵ��
class Factory{
	public static IFruit getName(String name){
		if(name.equals("ƻ��")){
			//IFruit�Ķ�̬ʵ��
			return new Apple();
		}else if(name.equals("����")){
			return new Orange();
		}else{
			return null;
		}
	}
}
