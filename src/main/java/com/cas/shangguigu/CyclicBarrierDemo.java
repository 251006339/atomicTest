package com.cas.shangguigu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        //到了7就输出syst
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()-> System.out.println("--------召唤神龙"));

        for (int i = 0; i <8 ; i++) {
            final int tempInt=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 收集到第"+tempInt+"龙珠");

                try {
                    cyclicBarrier.await();//线程前7次都等待在这里 执行7次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("没有执行");

            },String.valueOf(i)).start();


        }


    }


}
