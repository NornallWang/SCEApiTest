package com;

public class ObjectDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student std = new Student("Jack",20);	//stdͨ��new�ؼ����ڶ��ڴ��д����Ķ����ڴ��ַΪDFF1
		//��ӡstd����
		//System.out.println("std�����ڶ��ڴ��еĵ�ַΪ��"+std);		//std��std.toString()�ķ��ؽ����һ����
		
		//��ΪStudent��̳е���Object�࣬���Կ���ֱ�ӵ���Object��toString()����
		//System.out.println("ֱ�ӵ��ø���Object��toString������ȡstd�����ڶ��ڴ��еĵ�ַ��"+std.toString());
		System.out.println("��Student������д��Object���toString�����Ժ�std������ֱ�ӵ����Լ���toString���������ؽ��Ϊ��\n"+std.toString());
		
		Student std2 = new Student("Jack",20);	//std2ͨ��new�ؼ����ڶ��ڴ��д����Ķ����ڴ��ַΪDFF2
		//System.out.println(std.equals(std2));	//�ж�std�����std2�����Ƿ���ȣ�����ȣ���Ϊ��������ָ��Ķ��ڴ��еĶ����ڴ��ַ��һ�£���˷���false
		System.out.println(std.equals(std2));   //���õ��Ǹ�д���equals����
	}

}

class Student extends Object{
	String name;
	int age;
	
	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	//��дObject���е�toString()����
	public String toString(){
		return "����Ϊ "+name+" ��ѧ��������Ϊ��"+age;
	}
	
	//��дequals����
	public boolean equals(Object obj){
		//�����ǰ�����봫������ò���obj��ȣ�Ҳ�����Լ����Լ��ȣ��򷵻�true
		if(this == obj){
			return true;
		}
		//������Ķ���Ϊ�գ��򷵻�false
		if(obj == null){
			return false;
		}
		//�����ǰ���������ʱ���봫��Ķ�������ʱ�಻��ȣ��򷵻�false�����绨�ݸ������
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		//������������ʱ����ȣ��򽫴���Ķ���ǿ��ת��ΪStudent
		Student stdu = (Student)obj;
		//���赱ǰ����������봫���������䲻��ȣ��򷵻�false
		if(this.age!=age){
			return false;
		}
		//�����ǰ�����nameΪ�ղ��Ҵ�������name��Ϊ�գ��򷵻�false
		if(this.name==null){
			if(stdu.name!=null){
				return false;
			}
		}
		//�����ǰ�����name�����ڴ�������name���˴����õ�equalsΪ�ַ����Ƚϣ��ѱ���д���򷵻�false
		else if(!this.name.equals(stdu.name)){
			return false;
		}
		//���������������㣬�򷵻�true
		return true;
	}
}
