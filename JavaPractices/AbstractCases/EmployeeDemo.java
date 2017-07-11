package AbstractCases;
/**
 * @author Nornall
 *
 * �������󣺹�˾�����е�Ա����Ա���š�������нˮ����ΪΪ��������
 * ��ְ���ܼ���߱�Ա���������ص����⣬���߱������������Ϊ
 * 
 */

public class EmployeeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JavaTeacher jteacher = new JavaTeacher(1001, 8000, "Tom");
		jteacher.work();
		
		Leader leader = new Leader(100,10000,"Jerry",30000);
		leader.work();
		
		//��̬
		Employee em = new JavaTeacher(10002, 8000, "Henry");
		em.work();
		
		//�����಻��ʵ����
		//Employee emp = new Employee(1000,5000,"Lattern");
	}

}

//������
abstract class Employee{
	private int enumber;	//����
	private double esalary;	//нˮ
	private String ename;	//����
	
	public Employee(int enumber, double esalary, String ename){
		this.enumber = enumber;
		this.esalary = esalary;
		this.ename = ename;
	}
	
	//���󷽷�������
	public abstract void work();
	
}

//�������
class JavaTeacher extends Employee{
	//JavaTeacher�Լ�������
	public JavaTeacher(int enumber,double esalary, String ename){
		super(enumber,esalary,ename);	//����������г�ʼ��
	}
	
	//һ��һ����̳��˳����࣬��ô�����Ҫôȥʵ�ֳ������еĳ��󷽷���Ҫô����������ȥ
	/**
	 * ���󷽷���ʵ��
	 */
	public void work(){
		System.out.println("��Java�γ�");
	}
}

//�������
class Leader extends Employee{
	private double allowance;	//����
	public Leader(int enumber, double esalary, String ename, double allowance){
		super(enumber,esalary,ename);
		this.allowance = allowance;
	}
	/**
	 * ���󷽷���ʵ��
	 */
	public void work(){
		System.out.println("��ѵ��Ա��");
		System.out.println("��ƿγ���ϵ");
	}
}