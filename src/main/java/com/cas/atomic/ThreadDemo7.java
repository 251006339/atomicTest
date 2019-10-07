package com.cas.atomic;

//原子类多个方法不能解决 原子性问题
//一个run方法执行一个原子类方法操作
class T7 {


   synchronized void test(){
       System.out.println("方法1执行");
     }
    synchronized  void test1(){
        System.out.println("方法2执行");
    }

}

public  class ThreadDemo7{


     public static void main(String[] args) throws InterruptedException {
          T7 t=new T7();
          new Thread(()->{t.test();t.test1();}).start();
         new Thread(()->{t.test1();t.test();}).start();



     }


}
