package com.company.lorna.EnumCases;

/**
 * Created by goyoo on 2017/6/20.
 */
public class EnumDemo {
    public static void main(String[] args){
        System.out.println(Color.BLACK);    //Color.BLACK��ΪColor.BLACK.toString()
        //����ö�����е�ÿ��ö��ֵ
        Color[] colors = Color.values();
        for(Color color:colors){
            System.out.println(color);
        }

        System.out.println("========================================");
        System.out.println(Person.EPERSON1);
        System.out.println("ʹ��for��ǿ��ѭ�����ö���������е�ö��ֵ��");
        Person[] persons=Person.values();
        for (Person person:persons){
            System.out.println(person);
        }

        System.out.println("*****************************************");
        System.out.println("ʹ��switch���ö�����е�Ŀ��ö��ֵ");
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

//��jvmȥ����ʹ��ö�����ʱ�򣬻�Ԥ�ȴ������ö�����͵Ķ����ⲿ�����

/**
 * ��ö�����ж����ö������Ҳ�����������ֱ��
 */
//public static final Color RED = new Color();
//public static final Color BLUE = new Color();
//public static final Color BLACK = new Color();
//public static final Color WHITE = new Color();
//public static final Color GREEN = new Color();
enum Color{
    //RED,BLUE,BLACK,WHITE,GREEN; //�޲ι��췽����Ҳ�������¶��壺
    RED(),BLUE(),BLACK(),WHITE(),GREEN();

    //��Ϊö�����е�ÿ��ö��ֵ������һ�����࣬������ö�����ж���Ĺ��췽�����ᱻÿ��ö��ֵ�����õ�ʱ�����
    private Color(){
        System.out.println("����ö����Ĺ��췽������");
    }

    /**
     * ���Colorö�������ö������ʱ�Ƿ������Object���toString()����
     * @return
     */
//    public String toString(){
//        return "��дObject���toString����";
//    }

}

enum Person{
    //����ö�����ÿ��ö��ֵ�Ĺ��췽��
    EPERSON1("����",30),EPERSON2("����",20),EPERSON3("John",10);

    private String name;
    private int age;

    private Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "��ְԱ����Ϊ��"+name+"������Ϊ��"+age;
    }
}