package com.cas.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

class T2{
     //设置  boolean初始值为true  主内存
  AtomicBoolean atomicBoolean=new AtomicBoolean(true);



    public   void  test(){
                  while(atomicBoolean.get()){
                      //方法内存的值
                      System.out.println("循环执行true");


                  }



    }

    public   void  test1() {
        //当原始值和期望值一致时, 更新值; 0 -0 更新为1
        //当原始值为0.期望值为1.更新值不变,1

        long end = System.currentTimeMillis();

    }

}

public  class ThreadDemo5{


     public static void main(String[] args) throws InterruptedException {
             T2 t2=new T2();
         Thread thread = new Thread(t2::test);
         thread.start();
         Thread.sleep(5000);
         //如果可以设置到主内存, 导致程序停止; 则说明是可见性; 原子类-volatile +cas 非阻塞线程;
         t2.atomicBoolean.set(false);

     }


}
