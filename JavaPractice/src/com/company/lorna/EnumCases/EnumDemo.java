package com.company.lorna.EnumCases;

/**
 * Created by goyoo on 2017/6/20.
 */
public class EnumDemo {
    public static void main(String[] args){
        System.out.println(Color.BLACK);    //Color.BLACK即为Color.BLACK.toString()
        //输入枚举类中的每个枚举值
        Color[] colors = Color.values();
        for(Color color:colors){
            System.out.println(color);
        }

        System.out.println("========================================");
        System.out.println(Person.EPERSON1);
        System.out.println("使用for加强型循环输出枚举类中所有的枚举值：");
        Person[] persons=Person.values();
        for (Person person:persons){
            System.out.println(person);
        }

        System.out.println("*****************************************");
        System.out.println("使用switch输出枚举类中的目标枚举值");
        Person person = Person.EPERSON3;
        switch (person){
            case EPERSON1:
                System.out.println(Person.EPERSON1);
                break;
            case EPERSON2:
                System.out.println(Person.EPERSON2);
                break;
            case EPERSON3:
                System.out.println(Person.EPERSON3);
                break;
        }

    }
}

//当jvm去加载使用枚举类的时候，会预先创建多个枚举类型的对象供外部类调用

/**
 * 在枚举类中定义的枚举类型也就是如下这种表达
 */
//public static final Color RED = new Color();
//public static final Color BLUE = new Color();
//public static final Color BLACK = new Color();
//public static final Color WHITE = new Color();
//public static final Color GREEN = new Color();
enum Color{
    //RED,BLUE,BLACK,WHITE,GREEN; //无参构造方法，也可以如下定义：
    RED(),BLUE(),BLACK(),WHITE(),GREEN();

    //因为枚举类中的每个枚举值都是其一个子类，所以在枚举类中定义的构造方法都会被每个枚举值被调用的时候调用
    private Color(){
        System.out.println("我是枚举类的构造方法！！");
    }

    /**
     * 检测Color枚举类调用枚举类型时是否调用了Object类的toString()方法
     * @return
     */
//    public String toString(){
//        return "重写Object类的toString方法";
//    }

}

enum Person{
    //定义枚举类的每个枚举值的构造方法
    EPERSON1("张三",30),EPERSON2("李四",20),EPERSON3("John",10);

    private String name;
    private int age;

    private Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "此职员名称为："+name+"，年龄为："+age;
    }
}