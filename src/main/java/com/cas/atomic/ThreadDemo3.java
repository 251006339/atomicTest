package com.cas.atomic;

import java.util.concurrent.locks.ReentrantLock;

class T{
    ReentrantLock reentrantLock=  new ReentrantLock();

    public   void  test(){
        reentrantLock.lock();
        System.out.println("执行同步方法");
        try {
            int i=1/0;

        }finally {
            reentrantLock.unlock();
        }
        System.out.println("异常会抛出锁吗");

    }
    public   void  test1(){
        reentrantLock.lock();
        System.out.println("执行同步方法2");
        reentrantLock.unlock();
    }

}

public  class ThreadDemo3{


     public static void main(String[] args) {
     /*    int j = 0;
         for (int i = 0; i < 100; i++) {
             new Thread(() ->
             {
                 //方法体:
                 System.out.println(Thread.currentThread().getName()+"当前线程");


             }).start();

         }
*/


             T t=new T();
             new Thread(()->t.test()).start();


           new Thread(()->t.test1()).start();






     }


}
