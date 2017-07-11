package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/15.
 */
public class SameFunctionDemo {
    public static void main(String[] args){
        Son son = new Son();
        son.show();
        son.getShow();
    }
}

//定义一个抽象类，并声明一个抽象方法，方法名为show
abstract class Parent{
    public abstract void show();
}

//定义一个接口，并声明一个方法，方法名为show
interface IShow{
    public abstract void show();
}

//目标：实现同时调用接口和抽象类中的同名方法
//定义一个类，继承抽象类Parent
class Son extends Parent{
    //实现抽象类中的抽象方法
    public void show(){
        System.out.println("我是抽象类Parent中抽象方法show的具体实现");
    }

    //定义一个内部类，继承接口IShow并实现其show方法
    private class InnerClassA implements IShow{
        //实现继承自的接口中的方法
        public void show() {
            System.out.println("我是接口IShow中的方法show的具体实现");
        }
    }

    //定义一个方法getShow，以便主类调用内部类中的show方法
    public void getShow(){
        new InnerClassA().show();
    }
}