package com.cas.atomic.cocunrrent;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class AA{
     AtomicBoolean boolean1=new AtomicBoolean(true);
    CopyOnWriteArrayList<Object> copyOnWriteArrayList=new CopyOnWriteArrayList<>();
    public AA(){


    }


    void test(){
        //使用原子类操作
        while(boolean1.get()){

            copyOnWriteArrayList.add(new Random().nextDouble());
            System.out.println("容器执行大小+    "+copyOnWriteArrayList);
        }


    }
    void test1(){
        //不等于5一致循环
      while(copyOnWriteArrayList.size()!=5){
          boolean1.set(false);
          System.out.println("容器执行停止+    "+copyOnWriteArrayList);
      }


    }



}
public class Demo1 {
     /* 面试题（淘宝？）
       实现一个容器，提供两个方法，add，size
       写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，
       当个数到达5时，线程2给出提示并结束  */


    public static void main(String[] args) {

        AA a=new  AA();

          new Thread(a::test).start();

        Thread thread = new Thread(a::test1);

        thread.start();
    }






}
