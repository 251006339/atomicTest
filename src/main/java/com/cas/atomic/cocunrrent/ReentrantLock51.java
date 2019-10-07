package com.cas.atomic.cocunrrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock51 extends Thread {

    private ReentrantLock reentrantLock=new ReentrantLock(false);//true->设置公平锁  fasle->为非公平锁
  void test(){
      for (int i = 0; i <10 ; i++) {
          reentrantLock.lock();
          try {
              //公平锁 true. 会交替执行
              System.out.println("子线程执行--->"+Thread.currentThread().getName());

          } catch (Exception e) {
              e.printStackTrace();
          }finally {
              reentrantLock.unlock();
          }


      }


  }




    public static void main(String[] args) {
        ReentrantLock51 lock51=new ReentrantLock51();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <2 ; i++) {

            executorService.execute(lock51::test);

        }
    //三个线程交替执行

    }






}
