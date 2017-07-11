package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/15.
 */
public class AnonymousInnerDemo {
    public static void main(String[] args){

        //传统的方式
        Person person = new Person();
//        Animal dog = new Dog();
//        person.feed(dog);

        /**
         * 匿名内部类实现对象方法调用
         */


        //喂不同的狗
        System.out.println("=======喂不同的狗=========");
        person.feed(new Animal(){
            public void eat(){
                System.out.println("在匿名内部类中调用父类的子类对象方法:"+"金毛啃骨头");
            }
        });


        person.feed(new Animal() {
            @Override
            public void eat() {
                System.out.println("在匿名内部类中调用父类的子类对象方法:"+"泰迪啃骨头");
            }
        });


        //喂不同的狗
        System.out.println("========喂同一条狗=======");
        Animal dog = new Animal() {
            @Override
            public void eat() {
                System.out.println("在匿名内部类中调用父类的子类对象方法:"+"法斗啃骨头");
            }
        };
        person.feed(dog);
        person.feed(dog);

        System.out.println("========喂猫==========");
        person.feed(new Animal() {
            @Override
            public void eat() {
                System.out.println("在匿名内部类中调用父类的子类对象方法:"+"猫吃鱼");
            }
        });

        System.out.println("=============在匿名内部类定义子类自己的方法==============");
        new Animal(){
            public void eat(){
                System.out.println("匿名内部类中的父类的方法");
            }

            //定义匿名内部类子类自己的属性
            private String sonInfo = "我是匿名内部类子类自己的属性";
            //定义匿名内部类子类自己的方法
            private void sonFun(){
                System.out.println("我是匿名内部类子类的方法，将打印子类自己的属性值："+sonInfo);

            }
        }.sonFun();

        //在匿名内部类中使用语句块实现属性初始化
        System.out.println("==========在匿名内部类子类中定义语句块实现子类属性初始化==============");
        new Animal(){
            @Override
            public void eat() {
                System.out.println("匿名内部类中的父类的方法");
            }

            //定义匿名内部类子类的属性
            private String sonInfo="我是匿名内部类子类的属性的原始值";
            //定义一个语句块（该语句块即为匿名内部类子类的构造方法）实现上边的属性初始化
            {
                sonInfo="我是匿名内部类子类的属性在语句块中更新后的值";
            }
            //定义匿名内部类子类的方法
            private void printSonFun(){
                System.out.println("我是匿名内部类子类的方法，将打印匿名类子类的属性sonInfo="+sonInfo);
            }
        }.printSonFun();

        //匿名内部类继承接口
        System.out.println("=======匿名内部类的另一种实现：继承接口=======");
        person.iFeed(new IAnimal(){
            public void eat(){
                System.out.println("匿名内部类继承的是接口，我是接口中的抽象方法的具体实现");
            }
        });
    }
}

class Person{

    public void feed(Animal animal){
        animal.eat();
    }

    public void iFeed(IAnimal iAnimal){
        iAnimal.eat();
    }
}

abstract class Animal{
    public abstract void eat();
}

//使用子类继承父类的方式，调用eat方法
//class Dog extends Animal{
//    public void eat(){
//        System.out.println("啃骨头");
//    }
//}

//定义一个接口用于匿名内部类继承
interface IAnimal{
    public abstract void eat();
}