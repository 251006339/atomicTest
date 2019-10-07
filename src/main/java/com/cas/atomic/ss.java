package com.cas.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ss {



        /**
         * volatile 关键字，使一个变量在多个线程间可见
         * volatile并不能保证多个线程共同修改running变量所带来的不一致的问题，也就是说volatile不能替代synchronized
         * 即 volatile只能保证可见性，不能保证原子性
         */


      volatile int count = 0;
       AtomicInteger count1 = new AtomicInteger(0);
         //加锁,.或者 使用原子类;
     /*synchronized*/ void m() {  //其实只有一个线程执行
             for (int i = 0; i <1000 ; i++) {
                 count++;
             }

              //  count.incrementAndGet();//使用原子类

        }
     //创建10个线程,加入到集合中, 遍历集合,执行start
        public static void main(String[] args) {
            // 创建一个10个线程的list，执行任务皆是 m方法
            ss t = new ss();
            List<Thread> threads = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                threads.add(new Thread(t::m, "t-" + i));
            }

            // 启动这10个线程  启动完十个线程;  Thread::start  start ;开始执行;然后子线程执行join,让子线程先执行完;再执行主线程;
            threads.forEach(Thread::start   );

            // join 到主线程，防止主线程先行结束
            long start= System.currentTimeMillis();
            for (Thread thread : threads) {
                try {

                    thread.join();//先让子线程执行完; 主线程等待;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long end= System.currentTimeMillis();
            System.out.println("操作的时间"+(end-start));//15834  sync 5330
            // 10个线程，每个线程执行10000次，结果应为 100000
            System.out.println(t.count);  // 所得结果并不为 100000，说明volatile 不保证原子性
        }


}
