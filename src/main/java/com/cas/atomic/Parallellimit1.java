package com.cas.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parallellimit1 {

    public static void main(String[] args) {

     CountDownLatch countDownLatch=new CountDownLatch(10);
        CountDemo countDemo = new CountDemo(countDownLatch);


        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <10 ; i++) {
            executorService.execute(countDemo);
        }





    }


  static class CountDemo implements  Runnable{
        private CountDownLatch countDownLatch;
        public CountDemo(CountDownLatch countDownLatch){
            this.countDownLatch=countDownLatch;
        }


      @Override
      public void run() {
            synchronized (countDownLatch) {
                System.out.println("子线程执行 :");
                System.out.println(Thread.currentThread().getName()+"执行完成时数量是 : " + countDownLatch.getCount());
                countDownLatch.countDown();
            }
          try {
              countDownLatch.await();//执行完成后再执行 当countDownLatch 等于零时,开始执行;
              System.out.println("执行完成时数量是 : "+countDownLatch.getCount());
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

      }
  }



}








