package com.cas.test;

import com.cas.singleton.Singleton;
import com.cas.singleton.Singleton1;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {

        Singleton1 singleton1 = Singleton1.singleton1;
        Singleton1 singleton2 = Singleton1.singleton1;
        AtomicInteger atomicInteger=new AtomicInteger(5);
        boolean b = atomicInteger.compareAndSet(2, 3);//比较并交换
        int i1 = atomicInteger.get();
        System.out.println("交换值"+i1+"true "+b);

        System.out.println(singleton1==singleton2);


        for (int i = 0; i <5 ; i++) {
             //给线程起名字  Singleton.getInstance();String.valueOf(i)
            new Thread(  ()->{ Singleton.getInstance1(); },String.valueOf(i)).start(); //



        }



    }
}
