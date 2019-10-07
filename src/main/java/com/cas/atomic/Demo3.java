package com.cas.atomic;

public class Demo3 {
      //实际上使用的是同一把锁;
    String  name1="Hello";
    String  name2="Hello";
     //使用的同一地址;
      void test(){
          synchronized(name1){
              System.out.println("子线程+  --->"+Thread.currentThread().getName()+" ");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }

    }

    void test1(){
        synchronized(name2){
            System.out.println("子线程+"+Thread.currentThread().getName());
        }

    }

    public static void main(String[] args) {
        Demo3 demo=new Demo3();
      new Thread(demo::test).start();
        new Thread(demo::test1).start();
    }


}
