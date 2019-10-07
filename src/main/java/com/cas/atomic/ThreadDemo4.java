package com.cas.atomic;

import java.util.concurrent.atomic.AtomicInteger;

class T1{
    int count=0;
    AtomicInteger atomicInteger=new AtomicInteger(0);

    synchronized void m(){
        count ++;
    }

    public   void  test(){
        //先加1 后获得 ++1
       atomicInteger.incrementAndGet();
        //   atomicInteger.getAndIncrement();//每次加1

    }

    public   void  test1() {
        //当原始值和期望值一致时, 更新值; 0 -0 更新为1
        //当原始值为0.期望值为1.更新值不变,1
        atomicInteger.getAndIncrement(); //decrement--减少 //Increment 增加
        long end = System.currentTimeMillis();

    }

}

public  class ThreadDemo4{


     public static void main(String[] args) throws InterruptedException {

       T1 t=new T1();
         long start = System.currentTimeMillis();
         for (int i = 0; i <10000 ; i++) {

             Thread thread = new Thread(() -> t.m());
             thread.start();
             thread.join();//等待thread执行完成后,在执行主线程;
         }
         long ent = System.currentTimeMillis();
         System.out.println("m 所耗用时间---"+(ent-start));

         long start1 = System.currentTimeMillis();
         for (int i = 0; i <10000 ; i++) {
             Thread thread = new Thread(t::test);
             thread.start();
             thread.join();//上join 后.先多线程执行完成后再执行主线程;

         }
         long ent1 = System.currentTimeMillis();
         System.out.println("test cas无锁机制 所耗用时间---"+(ent1-start1));


     }


}
