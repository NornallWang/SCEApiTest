package AbstractCases;

public class TempleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher dbTeacher = new DBTeacher();
		dbTeacher.work();
		
		Teacher cTeacher = new CTeacher();
		cTeacher.work();

	}
}

abstract class Teacher{
	private int tnumber;
	private double tsalary;
	private String tname;
	
	public void prepared(){
		System.out.println("打开投影仪");
		System.out.println("点名");
	}
	
	public void endClass(){
		System.out.println("关闭投影仪");
		System.out.println("布置课后作业");
	}
	
	//抽象方法由其子类实现
	public abstract void teaching();
	
	//老师工作方法，是一个流程，该流程就是一个模板
	public void work(){
		//1、授课前准备
		prepared();
		//2、进行授课
		teaching();
		//3、结束上课();
		endClass();
	}
}

//创建Teacher的子类DBTeacher
class DBTeacher extends Teacher{
	//对抽象父类Teacher中的抽象方法teaching的具体实现
	public void teaching(){
		System.out.println("打开DB工具");
		System.out.println("DB老师开始教学生书写sql指令");
		System.out.println("DB老师在授课解惑数据库相关知识");
	}
}

//创建Teacher的子类JavaTeacher
class CTeacher extends Teacher{
	//对抽象父类Teacher中的抽象方法teaching的具体实现
	public void teaching(){
		System.out.println("打开Eclipse工具");
		System.out.println("JAVA老师开始教学生java编程思想");
		System.out.println("JAV老师在授课解惑JAVA编程相关知识");
	}
}