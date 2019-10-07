package com.cas.atomic.cocunrrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 和 synchronized 的区别
 *
 * ReentrantLock 可以进行尝试锁定 tryLock 这样无法锁定、或者在指定时间内无法锁定，线程可以决定是否继续等待
 */
class A{
    //使用lock 一个对象使用同一把锁;
    ReentrantLock reentrantLock = new ReentrantLock();
   //线程之间通讯
    Condition condition = reentrantLock.newCondition();
    void test(){
        reentrantLock.lock(); //上锁;
        reentrantLock.unlock();//释放锁
        try {
            condition.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    void test1() throws InterruptedException {
        reentrantLock.lockInterruptibly();//等待
        System.out.println("抢到线程1的锁");
        reentrantLock.lock();
        condition.signal();//+执行之前释放锁;
      //  reentrantLock.lockInterruptibly();//抢锁;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }

    }

}



public class Demo4 {







    public static void main(String[] args) {
           A a=new A();
            new Thread(a::test).start();
        new Thread(() -> {
            try {
                a.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }








}


