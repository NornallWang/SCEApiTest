package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/15.
 */
public class LocalInnerDemo {

    public static void main(String[] args){
        LocalOuter outer = new LocalOuter();
        outer.showOuter();

    }

}

class LocalOuter{
    private String name = "外部类中的变量name";
    private static String info = "外部类中的静态变量info";
    private int age = 10;

    public void showOuter(){
        //定义变量
        String name = "方法体内的变量name";
        int age = 20;
        final String info = "方法体内的常量info";

        //声明一个局部内部类
        class LocalInner{
            //声明变量
            private String name = "局部内部类中的变量name";
            private int age = 30;

            //声明局部内部类的方法
            public void showInner(){
                System.out.println("局部内部类中的方法showInner");
                System.out.println(name);   //局部内部类中的方法将执行其作用域内的变量
                System.out.println("在局部内部类中打印外部类中的变量name====>"+LocalOuter.this.name);
                System.out.println("在局部内部类中打印外部类中的静态变量info====>"+LocalOuter.info);
                System.out.println("局部内部类只能访问声明其的方法体中的常量=====>"+info);
            }
        }

        //局部内部类声明完成后，方可创建其对象，从而调用其方法
        LocalInner inner = new LocalInner();
        inner.showInner();
    }

}
