package com.company.lorna.InnerClassCases;

import java.util.Arrays;
import java.util.Map.Entry;


/**
 * Created by goyoo on 2017/6/15.
 * 目标：开发一个容器用来存放键值对，键存放英文名称，值存放中文名称，对键值对使用内部进行封装
 * 案例设计：使用静态内部类存放键值对数据
 *          容器大小默认为5M，超过就扩展其2倍
 *          通过entryArrays方法返回容器中的数据
 */
public class EntryDemo {
    public static void main(String[] args){
        MyContainer container = new MyContainer();
        container.put("apple","苹果");
        container.put("orange","橘子");
        container.put("lemon","柠檬");
        container.put("watermelon","西瓜");
        container.put("pineapple","菠萝");
        container.put("grape","葡萄");

        //输出
        MyContainer.Entry[] entryArrays = container.entryArrays();
        //取出数组数据
        for (int i=0;i<entryArrays.length;i++){
            MyContainer.Entry entry = entryArrays[i];
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}

class MyContainer{
    //存放entry对象的数组
    private Entry[] entrys = new Entry[5];   //定义一个容量为5的数组
    private int count = 0;  //下标

    //对外提供一个方法，向容器中存放封装好的entry对象数据(即Entry对象)
    public void put(String key,String value){
        Entry entry = new Entry();  //产生一个Entry对象
        entry.setKey(key);
        entry.setValue(value);

        //将entry对象数据存放到数组
        entrys[count++] = entry;
        //如果存放的entry对象数据大于entrys数组大小，就将其扩容两倍
        if (count>=entrys.length){

            int newCapacity = entrys.length*2;  //定义一个新数组newCapacity，是entrys数组大小的2倍
            //将老数组中的数据拷贝到新数组newCapacity中
            entrys = Arrays.copyOf(entrys,newCapacity);

        }

    }

    //把容器中的有数据的内容返回
    public Entry[] entryArrays(){
        return Arrays.copyOfRange(entrys,0,count);
    }

    //把键值对封装在Entry对象中
    public static class Entry{
        //声明两个变量key、value
        private String key;
        private String value;

        //get、set方法设置、获取键值
        public void setKey(String key){
            this.key = key;
        }
        public String getKey(){
            return key;
        }

        public void setValue(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }

    }

}
