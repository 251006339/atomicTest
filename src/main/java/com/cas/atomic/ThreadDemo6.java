package com.cas.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
  //原子类多个方法不能解决 原子性问题
class T3 {
  AtomicInteger atomicInteger=new AtomicInteger(0);

     int test(){
         //锁与锁之间会出现并发问题;
         atomicInteger.addAndGet(2);//增加1 获得1
         //当线程A带着信息.执行这个信息时. 线程B却执行把 1变成了2 ,而此时线程A还时带着1 就会出现并发问题;
        atomicInteger.addAndGet(3);
         /* atomicInteger.addAndGet(3);
         atomicInteger.addAndGet(4);*/
      //应该出现 整数.执行却多了个 1
         return  atomicInteger.get();
     }
     void test1(){

     }


}

public  class ThreadDemo6{


     public static void main(String[] args) throws InterruptedException {

        T3 t3=new T3();
        List<Thread> threads=new ArrayList<Thread>();

         for (int i = 0; i < 100; i++) {
             Thread thread = new Thread(()->System.out.println( t3.test()));
             threads.add(thread);
         }


         threads.forEach(thread -> thread.start());


     }


}
