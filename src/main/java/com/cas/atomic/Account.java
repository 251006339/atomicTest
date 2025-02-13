package com.cas.atomic;


import java.util.concurrent.TimeUnit;

/**
 * 对业务写方法加锁，而对业务读方法不加锁，
 * 容易出现 脏读问题
 * <p>
 * 因为，在执行写的过程中，因为读操作没有加锁，所以读会读取到写未改完的脏数据
 * 解决办法，给读写都加锁
 */
public class Account {

    /**
     * 银行账户名称
     */
    String name;
    /**
     * 银行账余额
     */
    double balance;

      //一个方法run 里,两个方法加了锁,不能同时调两个方法
    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
           TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public synchronized double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();

        new Thread(() -> a.set("张三", 100.0)).start();
          //主线程调用getBalance 银行卡 如果加锁,则需要等其他子线程执行完,释放锁才能继续执行
        System.out.println(a.getBalance()); // 0.0
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance()); // 100.0
    }
}