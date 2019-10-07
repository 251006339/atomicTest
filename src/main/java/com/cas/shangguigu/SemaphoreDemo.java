package com.cas.shangguigu;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
  信息号主要用于两个目的.一个是用于多个共享资源的互斥使用,
  另一个用户并发线程数的控制;
  SemphoreDemo --争车位 .代码
 */
public class SemaphoreDemo {


    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);//模拟3个停车场
        for (int i = 0; i < 6; i++) { //模拟6部汽车;
            new Thread(()->
            {
                try {
                    semaphore.acquire();//执行成功  //acquire() 只有三个 线程可以抢到信号量
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ).start();



        }


    }



}
