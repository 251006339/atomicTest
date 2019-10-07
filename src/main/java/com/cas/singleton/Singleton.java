package com.cas.singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class Singleton {
      //指令禁止重排  加载完才去取---
    private volatile static  Singleton singleton=null ;

    private Singleton(){
        System.out.println("创建构造方法");
    }
    public static Singleton getInstance( ){
        //  创建对象时会先获得地址,对象还没创建好;<有名无实>


        if(singleton==null) { //在未加volatile时候.线程1进入获得地址,但还没有创建好对象, 线程2判断不为空,线程2获得的对象,为空.
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();//有三步操作;
                    //1 分配对象内存空间,2初始化对象,3 给对象应用地址;
                    //重排. 1 分配对象内存空间 ,3给对象引用地址; --线程2 判断不为空,但实际还没初始化对象
                    // 2初始化对象.   线程1
                    System.out.println("原子类加载+ "+new AtomicInteger().addAndGet(1));
                }
            }
        }


        return singleton;
    }
    public static Singleton getInstance1( ){
    //因为没有加锁,导致了会出现并发问题;


                if (singleton == null) {
                    singleton = new Singleton();
                    System.out.println("原子类加载+ "+new AtomicInteger().addAndGet(1));


        }


        return singleton;
    }


}
