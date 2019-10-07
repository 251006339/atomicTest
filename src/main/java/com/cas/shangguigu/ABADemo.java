package com.cas.shangguigu;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {

    static AtomicReference<Integer> atomicReference=new AtomicReference<>(100);
    //原始值为100  版本号是1
   static AtomicStampedReference atomicStampedReference=new AtomicStampedReference(100,1);
    public static void main(String[] args) {
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1" ).start();
        //t2 停止1秒钟t2线程,保证上面的t1线程完成了一个aba操作.
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get());
        },"t2" ).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("以下是aba问题的解决---------------");

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);

            //第一次版本号;
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号"+stamp);
            try { //暂停3秒钟 4线程
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          },"t3").start();
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            //第一次版本号;
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号"+stamp);
            try { //暂停3秒钟 4线程
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 1001, stamp, stamp + 1);

            System.out.println(Thread.currentThread().getName()+"修改成功否:" +result+"\t当前最新实际版本号:"+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t当前实际最新值:"+atomicStampedReference.getReference());
        },"t4").start();
    }



}
