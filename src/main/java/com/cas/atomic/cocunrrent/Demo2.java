package com.cas.atomic.cocunrrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

class D{
    CountDownLatch countDownLatch = new CountDownLatch(5); //线程之间通讯
     final List<Object> lists=new ArrayList<>();
    void m1(){
        synchronized (lists) {
            for (int i = 0; i <10 ; i++) {
                lists.add(new Random().nextInt());
                countDownLatch.countDown();//执行一次减1;  线

                 System.out.println("线程1的容器为5了."+lists);
            }


        }
    }
    void m2() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //为0时执行
        System.out.println("线程2的容器为5了.提示一下结束线程");
    }

}

public class Demo2 {


    public static void main(String[] args) {
        D  d=new D();
        new Thread(d::m1).start();

        new Thread(d::m2).start();

    }








}
