package com.cas.shangguigu;

class MyData {

    int number=0;

    public void addT060(){

        this.number=60;
    }
    //请注意.此时number前面加个volatile 关键字修饰的,volatile不保存原子性
public void addPlusPlus(){

        number++;
}




}
public class VolatileDemo{
//1原子volatile的可见性
    // 1.1 假如int number=0.number 变量之前根本没有添加volatile关键字修饰
    //1.2添加volation ,.可以解决可见性问题:
 //2 验证volatile 不保证原子性
     //2.1原子性是指的是什么意思?
     //不见分割.完整性.也即某个线程正在做某个具体业务时.要么同时成功,

    public static void main(String[] args) throws InterruptedException { //main 是一切方法的运行入口
        //volatile1();
         atomic1();

    }

    private static void atomic1() {
        MyData myData=new MyData();
        //fori 20次
       for (int i = 0; i <20 ; i++) {
           new Thread(()->{
               //遍历for j 1000次
               for (int j = 0; j <10000 ; j++) {
                   myData.addPlusPlus();
               }

           },String.valueOf(i)).start();
          }
        //需要等待上面20个线程全部计算完成后,再用mian线程取得最终结果值看是多少
        while(Thread.activeCount()>2){
            Thread.yield(); //主gc子线程大于2 .就一直循环执行
        }
        System.out.println(Thread.currentThread().getName()+"final main number:"+myData.number);


    }

    public static void  volatile1(){
     MyData myData=new MyData();

     new  Thread(()->{
         System.out.println(Thread.currentThread().getName()+"come in ");
         try {
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         myData.addT060();//修改子线程属性
     },"aaa").start();

     while(myData.number==0){ //cpu的内存连续,没有时间切换会导致不可见问题

     }
     System.out.println(Thread.currentThread().getName());
 }


}