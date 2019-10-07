package com.cas.atomic;

public class Demo1 {

     int count=0;
    synchronized  void m1(){
        count++;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


        void  m2(){   //给需要的代码加上锁;
       synchronized (this){
           count++;
       }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Demo1 demo=new Demo1();
        new Thread(()->demo.m1()  ).start();

        new Thread(()->demo.m2()  ).start();

    }







}
