package com.cas.atomic;

import java.util.concurrent.TimeUnit;

public class Demo2 {
    Object o=new Object(); //改变对象地址,锁会释放
     void test(){
         synchronized (o) {
             while (true) { //切换o的地址会导致多个子线程进入程序中,执行
                 System.out.println("子线程-@-->" + Thread.currentThread().getName());


                 try {  //睡眠两秒
                     TimeUnit.SECONDS.sleep(1);//让主内存里o 地址换成 新的地址;

                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        new Thread(()->{demo2.test();},"t1-->").start();



        Thread thread = new Thread(() -> {
            demo2.test();
        }, "t2-->");
        demo2.o=new Object();
        thread.start();
    }










}
