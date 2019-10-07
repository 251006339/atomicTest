package com.cas.atomic.cocunrrent;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Demo{
      private BlockingQueue blockingQueue=new ArrayBlockingQueue(10);

void test(){
 while(true) {

         try {
             blockingQueue.put("xsa");//容器
             System.out.println(blockingQueue.remainingCapacity());
             System.out.println(blockingQueue);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

 }
}
void test1(){
    while(true){
        if(blockingQueue.size()==10) {
            Object poll = blockingQueue.poll();
            System.out.println("获得容器内元素" + poll);
        }
    }




}

}






public class ProducersDemo {


    public static void main(String[] args) {
        Demo demo=new Demo();

            new Thread(demo::test).start();


        new Thread(demo::test1).start();
    }






}
