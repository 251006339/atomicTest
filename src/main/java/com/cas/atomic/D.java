package com.cas.atomic;

public class D {

    public static void main(String[] args) {
        DemoRunabale demoRunabale = new DemoRunabale();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(demoRunabale);
            thread.start();
        }

    }


}

class DemoRunabale implements  Runnable{


    @Override
    public void run() {
        System.out.println("执行子线程 6  "+Thread.currentThread().getName()+"数量");
        test(); //可重入锁



    }

    synchronized  void test(){
        System.out.println("执行子线程0  "+Thread.currentThread().getName()+"数量");
        test1();
    }
    synchronized  void test1(){
        System.out.println("执行子线程1"+Thread.currentThread().getName()+"数量");
    }
}