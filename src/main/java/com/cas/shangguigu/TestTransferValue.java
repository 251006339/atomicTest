package com.cas.shangguigu;

import com.cas.entity.Person;

public class TestTransferValue {
    public void changeValue1(int age){
        age=30;
    }
    public void changeValue2(Person person){
        person.setName("xxx");
    }
    public void changeValue3(String str ){
        str="xxx";
    }

    public static void main(String[] args) {
       // new ThreadPoolExecutor();//创建线程
        //栈运行, 堆存储
        TestTransferValue testTransferValue=new TestTransferValue();
        int age=20; //main---内存的20
        testTransferValue.changeValue1(age);//压栈
        System.out.println("age....."+age);

        Person person=new Person("age");//堆里面要刷新
        testTransferValue.changeValue2(person);
        System.out.println("personName   "+person.getName());

        String str="abc";//常量池
        testTransferValue.changeValue3(str);
        System.out.println("String---"+str);


    }


}
