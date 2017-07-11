package AbstractCases;
/**
 * @author Nornall
 *
 * 功能需求：公司中所有的员工有员工号、姓名、薪水，行为为“工作”
 * 而职工总监则具备员工的所有特点以外，还具备管理津贴的行为
 * 
 */

public class EmployeeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JavaTeacher jteacher = new JavaTeacher(1001, 8000, "Tom");
		jteacher.work();
		
		Leader leader = new Leader(100,10000,"Jerry",30000);
		leader.work();
		
		//多态
		Employee em = new JavaTeacher(10002, 8000, "Henry");
		em.work();
		
		//抽象类不能实例化
		//Employee emp = new Employee(1000,5000,"Lattern");
	}

}

//抽象类
abstract class Employee{
	private int enumber;	//工号
	private double esalary;	//薪水
	private String ename;	//姓名
	
	public Employee(int enumber, double esalary, String ename){
		this.enumber = enumber;
		this.esalary = esalary;
		this.ename = ename;
	}
	
	//抽象方法的声明
	public abstract void work();
	
}

//具体的类
class JavaTeacher extends Employee{
	//JavaTeacher自己的属性
	public JavaTeacher(int enumber,double esalary, String ename){
		super(enumber,esalary,ename);	//交给父类进行初始化
	}
	
	//一旦一个类继承了抽象类，那么这个类要么去实现抽象类中的抽象方法，要么继续抽象下去
	/**
	 * 抽象方法的实现
	 */
	public void work(){
		System.out.println("上Java课程");
	}
}

//具体的类
class Leader extends Employee{
	private double allowance;	//津贴
	public Leader(int enumber, double esalary, String ename, double allowance){
		super(enumber,esalary,ename);
		this.allowance = allowance;
	}
	/**
	 * 抽象方法的实现
	 */
	public void work(){
		System.out.println("培训新员工");
		System.out.println("设计课程体系");
	}
}