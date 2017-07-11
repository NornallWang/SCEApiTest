package com.company.lorna.ObjectCases;

/**
 * Employee有两个属性
 * 1、姓名
 * 2、年龄
 * 
 * Employee有两个功能：
 * 1、输出个人的详细信息
 * 2、统计字符串出现的个数
 * @author Nornall
 *
 */
public class Employee {
	
	//定义雇员属性
	public String name;
	public int age;
	
	//返回个人信息的方法
	public String personInfo(){
		return "我的名字叫"+name+";\n我的年龄为："+age;
	}
	
	//指定的字符串查找出现的次数
	/**
	 * 
	 * @param str：原字符串
	 * @param destStr：要查找的字符串
	 * 
	 * indexOf("朋友")
	 * 
	 * @return
	 */
	public int contentCount(String str,String destStr){

		int count = 0;	//计数器
		int index = 0;	//找到朋友的下标
		
		//str = "朋友啊朋友，你是我最好的朋友！";
		//destStr = "朋友";
		
		//使用indexOf进行查找
		index = str.indexOf(destStr);	//找到的话讲值赋值给index
		//indexOf()找到则返回初次出现的下标，找不到则返回-1
		
		while(index != -1){	
			count++;	//如果找到了，则计数器+1
			index += destStr.length();	//指定从哪个位置的下标往后找
			index = str.indexOf(destStr,index);	//从指定的位置小标往后找
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee em = new Employee();
		em.name = "John";
		em.age = 30;
		
		System.out.println("输入个人信息为："+em.personInfo());
		
		//声明变量
		String str = "朋友啊朋友，你是我最好的朋友！";
		String destStr = "朋友";
		int count = em.contentCount(str, destStr);
		System.out.println(destStr+" 在原字符串中出现的次数为："+count+"次");

	}

}
