package com.cas.shangguigu;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;


public class SpinLockDemo {
    AtomicReference<Thread >atomicReference=new AtomicReference<>();


    public  void myLock(){
      Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in  begin");
      while(!atomicReference.compareAndSet(null,thread)){
          //自旋锁.  循环执行,
      }

    }



    public  void myUnLock(){
        Thread thread=Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invoked myUnlock()");


    }
  //循环会消耗cpu  采用循环的方式去尝试获取锁;
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo=new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();//回收;

          try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();
        new Thread(()->{
            spinLockDemo.myLock();

            spinLockDemo.myUnLock();


        },"bb").start();


    }





}
