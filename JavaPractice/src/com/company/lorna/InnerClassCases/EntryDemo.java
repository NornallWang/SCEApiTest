package com.company.lorna.InnerClassCases;

import java.util.Arrays;
import java.util.Map.Entry;


/**
 * Created by goyoo on 2017/6/15.
 * Ŀ�꣺����һ������������ż�ֵ�ԣ������Ӣ�����ƣ�ֵ����������ƣ��Լ�ֵ��ʹ���ڲ����з�װ
 * ������ƣ�ʹ�þ�̬�ڲ����ż�ֵ������
 *          ������СĬ��Ϊ5M����������չ��2��
 *          ͨ��entryArrays�������������е�����
 */
public class EntryDemo {
    public static void main(String[] args){
        MyContainer container = new MyContainer();
        container.put("apple","ƻ��");
        container.put("orange","����");
        container.put("lemon","����");
        container.put("watermelon","����");
        container.put("pineapple","����");
        container.put("grape","����");

        //���
        MyContainer.Entry[] entryArrays = container.entryArrays();
        //ȡ����������
        for (int i=0;i<entryArrays.length;i++){
            MyContainer.Entry entry = entryArrays[i];
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}

class MyContainer{
    //���entry���������
    private Entry[] entrys = new Entry[5];   //����һ������Ϊ5������
    private int count = 0;  //�±�

    //�����ṩһ���������������д�ŷ�װ�õ�entry��������(��Entry����)
    public void put(String key,String value){
        Entry entry = new Entry();  //����һ��Entry����
        entry.setKey(key);
        entry.setValue(value);

        //��entry�������ݴ�ŵ�����
        entrys[count++] = entry;
        //�����ŵ�entry�������ݴ���entrys�����С���ͽ�����������
        if (count>=entrys.length){

            int newCapacity = entrys.length*2;  //����һ��������newCapacity����entrys�����С��2��
            //���������е����ݿ�����������newCapacity��
            entrys = Arrays.copyOf(entrys,newCapacity);

        }

    }

    //�������е������ݵ����ݷ���
    public Entry[] entryArrays(){
        return Arrays.copyOfRange(entrys,0,count);
    }

    //�Ѽ�ֵ�Է�װ��Entry������
    public static class Entry{
        //������������key��value
        private String key;
        private String value;

        //get��set�������á���ȡ��ֵ
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
