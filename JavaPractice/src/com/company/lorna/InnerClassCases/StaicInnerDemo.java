package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/15.
 */
public class StaicInnerDemo {
    public static void main(String[] args){

        Outer outer = new Outer();
        outer.showOuter();

        //创建内部类对象
        Outer.Inner inner = new Outer.Inner();
        inner.showInner();

    }
}

class Outer{
    private String oName = "外部类";
    private int oAge = 20;
    //定义一个外部类的静态变量
    private static String oInfo = "我是外部类中的静态变量";

    public void showOuter(){
        System.out.println("我是"+oName+"，年龄为："+oAge);

        //在外部类访问静态内部类中的非静态变量
        Inner inner = new Inner();
        System.out.println("在外部类访问内部类中的非静态变量iName，先创建静态内部类对象，然后使用对象进行调用，结果为：\n"+inner.iName);

        //在外部类访问静态内部类中的静态变量
        System.out.println("在外部类访问内部类中的静态变量iInfo，采用内部类.静态变量名的方式，结果为：\n"+Inner.iInfo);
    }

    //定义一个静态内部类
    static class Inner{
        private String iName = "内部类";
        private int iAge = 10;
        //定义一个内部类的静态变量
        private static String iInfo = "我是内部类中的静态变量";

        public void showInner(){
            System.out.println("我是"+iName+"，年龄为："+iAge);

            //静态内部类中访问外部类的非静态变量
            System.out.println("从静态内部类试图访问外部类非静态变量oAge,访问方式为Outer.this.oName，访问失败。"+"静态内部类不能访问外部类中的非静态变量");

            //静态内部类中访问外部类的静态变量
            System.out.println("在静态内部类采用Outer.oInfo的方式，访问外部类中的静态变量。结果为：\n"+Outer.oInfo);
        }
    }

}