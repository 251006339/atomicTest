package com.cas.shangguigu;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
//队列  Collection ---BlockQueue
//2 .阻塞队列
  //2.1 阻塞队列有没有好的一面
  //2.2 不得不阻塞,你如何管理;
// ArrayBlockQueue == 数组结构组成的有界阻塞队列;
//linkedBlockQueue --由链表结构组成的有界(但大小默认值为Integer.MAX_VALUE)阻塞队列         21亿 大小
//SynchronusQueue   --不存储元素的阻塞队列.也

public class BlockingQueueDemo {

    public static void main(String[] args) {
        List list=null;
        //默认是10 ,容量为3
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        blockingQueue.add("a"); //报出异常 add  remove()
        blockingQueue.add("b");
        blockingQueue.add("c");
        System.out.println(blockingQueue.element());

        blockingQueue.add("a");
        System.out.println(blockingQueue);

    }

}
