package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/14.
 */
public class MemberInnerClass {
    public static void main(String[] args){
        //创建外部类的对象
        OuterOne outerOne = new OuterOne();

        /*
        //创建内部类的对象
        OuterOne.InnerOne innerOne = outerOne.new InnerOne();
        //访问内部类中的方法
        innerOne.innerShow();
        */

        outerOne.outerShow();

    }
}

//创建一个类，作为外部类
class OuterOne{
    //属性和方法
    private String name = "外部类";
    private int age = 12;

    public void outerShow(){
        System.out.println("我是"+name+",年龄为："+age);
        //外部类访问内部类，需要创建内部类的对象
        InnerOne innerOne = new InnerOne();
        innerOne.innerShow();
    }

    //创建内部类
    public class InnerOne{
        //内部类的属性和方法
        private String name = "内部类";
        private int age2 = 13;
        private static final int number = 88;        //成员内部类中可以声明静态的常量

        //在成员内部类中不能声明静态的成员（包括静态的属性和方法）
        //private static int staticAge = 20;

        public void innerShow(){
            System.out.println("我是"+name+",年龄为："+age2+"；我有一个静态常量属性number，值为："+number);

            //在内部类中访问外部类的成员变量
            System.out.println("我是在内部类中访问到的"+OuterOne.this.name+",年龄为"+OuterOne.this.age);

            //成员内部类可以直接访问外部类的方法和属性
            System.out.println("成员内部类可以直接访问外部类的方法和属性，以下为访问外部类的方法");
            System.out.print("我是成员内部类，我直接访问到的外部类方法，访问结果为：");
            //outerShow();
            System.out.println();
            System.out.println("我是在成员内部类中直接访问到的外部类属性name，访问结果为："+age);



        }
    }
}
