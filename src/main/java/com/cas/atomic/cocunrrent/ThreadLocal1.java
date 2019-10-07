package com.cas.atomic.cocunrrent;


import java.util.concurrent.TimeUnit;

/**
     * ThreadLocal 线程局部变量
     */
    public class ThreadLocal1 {
   //先加载静态属性.static{} 赋值 ;
        /*volatile*/ static Person p = new Person();//主程序执行之前会执行
                     String name="11"; //执行构造前执行
        public static void main(String[] args) {
            Person p1 = new Person();  //获得class模块的static 值
            new Thread(() -> {
                try {
                   TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(p.name);  // 在加与不加volatile的情况下，这句话打印的值分别是？ 答：不写volatile有可能发生可见性问题
            }).start();

            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                p.name = "lisi";
            }).start();
        }
       //在运行主时, 会先加载静态类  Person --name="zhangsan"
        static class Person {
            String name = "zhangsan";
        }
    }

