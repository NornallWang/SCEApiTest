package com.company.lorna.ObjectCases;

/**
 * Employee����������
 * 1������
 * 2������
 * 
 * Employee���������ܣ�
 * 1��������˵���ϸ��Ϣ
 * 2��ͳ���ַ������ֵĸ���
 * @author Nornall
 *
 */
public class Employee {
	
	//�����Ա����
	public String name;
	public int age;
	
	//���ظ�����Ϣ�ķ���
	public String personInfo(){
		return "�ҵ����ֽ�"+name+";\n�ҵ�����Ϊ��"+age;
	}
	
	//ָ�����ַ������ҳ��ֵĴ���
	/**
	 * 
	 * @param str��ԭ�ַ���
	 * @param destStr��Ҫ���ҵ��ַ���
	 * 
	 * indexOf("����")
	 * 
	 * @return
	 */
	public int contentCount(String str,String destStr){

		int count = 0;	//������
		int index = 0;	//�ҵ����ѵ��±�
		
		//str = "���Ѱ����ѣ���������õ����ѣ�";
		//destStr = "����";
		
		//ʹ��indexOf���в���
		index = str.indexOf(destStr);	//�ҵ��Ļ���ֵ��ֵ��index
		//indexOf()�ҵ��򷵻س��γ��ֵ��±꣬�Ҳ����򷵻�-1
		
		while(index != -1){	
			count++;	//����ҵ��ˣ��������+1
			index += destStr.length();	//ָ�����ĸ�λ�õ��±�������
			index = str.indexOf(destStr,index);	//��ָ����λ��С��������
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee em = new Employee();
		em.name = "John";
		em.age = 30;
		
		System.out.println("���������ϢΪ��"+em.personInfo());
		
		//��������
		String str = "���Ѱ����ѣ���������õ����ѣ�";
		String destStr = "����";
		int count = em.contentCount(str, destStr);
		System.out.println(destStr+" ��ԭ�ַ����г��ֵĴ���Ϊ��"+count+"��");

	}

}
