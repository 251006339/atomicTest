package com.cas.atomic;

public class DemoT{
      //子类执行父类的方法是否是重入锁;

     synchronized   void  m1(){
         System.out.println("父类子线程执行:  ");
    }

    public static void main(String[] args) {
        DemoT2 demoT2 = new DemoT2();
        new Thread(()-> demoT2.m1()).start();

    }

}


class DemoT2 extends  DemoT{


     //重入锁--> 递归锁;
    synchronized void  m1(){
        System.out.println("子线程执行:  ");
     super.m1();
   }

}

