package com.cas.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

//原子类多个方法不能解决 原子性问题
//一个run方法执行一个原子类方法操作
class T8 {
    CountDownLatch countDownLatch=new CountDownLatch(5);
AtomicInteger atomicInteger =new AtomicInteger(0);
    void test(){


        System.out.println("test线程"+ atomicInteger.incrementAndGet());
        countDownLatch.countDown();
    }
    void test1(){
        System.out.println("test1线程");
    }

}

public  class ThreadDemo8{
  //CountDownLatch;
 static CountDownLatch countDownLatch=new CountDownLatch(100);
     public static void main(String[] args) throws InterruptedException {

                 T8 t=new T8();
         for (int i = 0; i <100 ; i++) {
             Thread thread = new Thread(() -> t.test());
             thread.start();

         }
         //等待主线程执行完成;
         countDownLatch.await();
         System.out.println("主线程完成");

     }


}
