package com.company.lorna.InnerClassCases;

/**
 * Created by goyoo on 2017/6/15.
 */
public class AnonymousInnerDemo {
    public static void main(String[] args){

        //��ͳ�ķ�ʽ
        Person person = new Person();
//        Animal dog = new Dog();
//        person.feed(dog);

        /**
         * �����ڲ���ʵ�ֶ��󷽷�����
         */


        //ι��ͬ�Ĺ�
        System.out.println("=======ι��ͬ�Ĺ�=========");
        person.feed(new Animal(){
            public void eat(){
                System.out.println("�������ڲ����е��ø����������󷽷�:"+"��ë�й�ͷ");
            }
        });


        person.feed(new Animal() {
            @Override
            public void eat() {
                System.out.println("�������ڲ����е��ø����������󷽷�:"+"̩�Ͽй�ͷ");
            }
        });


        //ι��ͬ�Ĺ�
        System.out.println("========ιͬһ����=======");
        Animal dog = new Animal() {
            @Override
            public void eat() {
                System.out.println("�������ڲ����е��ø����������󷽷�:"+"�����й�ͷ");
            }
        };
        person.feed(dog);
        person.feed(dog);

        System.out.println("========ιè==========");
        person.feed(new Animal() {
            @Override
            public void eat() {
                System.out.println("�������ڲ����е��ø����������󷽷�:"+"è����");
            }
        });

        System.out.println("=============�������ڲ��ඨ�������Լ��ķ���==============");
        new Animal(){
            public void eat(){
                System.out.println("�����ڲ����еĸ���ķ���");
            }

            //���������ڲ��������Լ�������
            private String sonInfo = "���������ڲ��������Լ�������";
            //���������ڲ��������Լ��ķ���
            private void sonFun(){
                System.out.println("���������ڲ�������ķ���������ӡ�����Լ�������ֵ��"+sonInfo);

            }
        }.sonFun();

        //�������ڲ�����ʹ������ʵ�����Գ�ʼ��
        System.out.println("==========�������ڲ��������ж�������ʵ���������Գ�ʼ��==============");
        new Animal(){
            @Override
            public void eat() {
                System.out.println("�����ڲ����еĸ���ķ���");
            }

            //���������ڲ������������
            private String sonInfo="���������ڲ�����������Ե�ԭʼֵ";
            //����һ�����飨�����鼴Ϊ�����ڲ�������Ĺ��췽����ʵ���ϱߵ����Գ�ʼ��
            {
                sonInfo="���������ڲ�������������������и��º��ֵ";
            }
            //���������ڲ�������ķ���
            private void printSonFun(){
                System.out.println("���������ڲ�������ķ���������ӡ���������������sonInfo="+sonInfo);
            }
        }.printSonFun();

        //�����ڲ���̳нӿ�
        System.out.println("=======�����ڲ������һ��ʵ�֣��̳нӿ�=======");
        person.iFeed(new IAnimal(){
            public void eat(){
                System.out.println("�����ڲ���̳е��ǽӿڣ����ǽӿ��еĳ��󷽷��ľ���ʵ��");
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

//ʹ������̳и���ķ�ʽ������eat����
//class Dog extends Animal{
//    public void eat(){
//        System.out.println("�й�ͷ");
//    }
//}

//����һ���ӿ����������ڲ���̳�
interface IAnimal{
    public abstract void eat();
}