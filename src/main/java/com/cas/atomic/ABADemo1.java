package com.cas.atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo1 {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

  static  AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {


        System.out.println("===以下是ABA问题的产生===");
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);

        }, "t1").start();

        new Thread(() -> {
            atomicReference.compareAndSet(100, 11);
            atomicReference.compareAndSet(11, 12);
        }, "t2").start();

        System.out.println("原子类reference获得 " + atomicReference.get());

    /* new Thread(()->{
                    int stamp=stampedReference.getStamp();
                    System.out.println(Thread.currentThread().getName()+"\t 第1次版本号"+stamp+"\t值是"+stampedReference.getReference());
                    //暂停1秒钟t3线程
                    try {
                TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e){e.printStackTrace();}

                    stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
                    System.out.println(Thread.currentThread().getName()+"\t 第2次版本号"+stampedReference.getStamp()+"\t值是"+stampedReference.getReference());
                    stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
                    System.out.println(Thread.currentThread().getName()+"\t 第3次版本号"+stampedReference.getStamp()+"\t值是"+stampedReference.getReference());
                },"t3").start();

                new Thread(()->{
                    int stamp1=stampedReference.getStamp();
                    System.out.println(Thread.currentThread().getName()+"\t 第1次版本号"+stamp+"\t值是"+stampedReference.getReference());
                    //保证线程3完成1次ABA
                    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e){e.printStackTrace();}
                    boolean result=stampedReference.compareAndSet(100, 2019,stamp,stamp+ 1);
                    System.out.println(Thread.currentThread().getName()+"\t 修改成功否"+result+"\t最新版本号"+stampedReference.getStamp());
                    System.out.println("最新的值\t"+stampedReference.getReference());
                },"t4").start();*/

    }
}