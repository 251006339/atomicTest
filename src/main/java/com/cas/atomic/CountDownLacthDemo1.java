package com.cas.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLacthDemo1 {


        public static void main(String[] args) throws InterruptedException {
          CountDownLatch count=new CountDownLatch(100);
            ExecutorService executorService = Executors.newFixedThreadPool(100);

            for (int i = 0; i <100 ; i++) {
                executorService.execute(()-> {System.out.println("子线程执行"+Thread.currentThread().getName());   count.countDown();  }     );


            }
              //创建线程完毕后.关闭资源;
            executorService.shutdown();
            count.await();
            System.out.println("主线程执行完毕");






        }

}
