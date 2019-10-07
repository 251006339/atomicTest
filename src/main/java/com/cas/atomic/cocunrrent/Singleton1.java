package com.cas.atomic.cocunrrent;



    /**
     * 线程安全的单例模式
     * <p>
     * 更好的是采用这种方式，既不用加锁，也能实现懒加载
     */
    public class Singleton1 {

   private Singleton1(){

   }
  private static  class Inner{
              private static Singleton1 singleton1=new Singleton1(); //执行的时候才会加载;
        }

    public Singleton1 getInStance(){

       return  Inner.singleton1;
    }

        public static void main(String[] args) {
       Singleton1 singleton1=new Singleton1();

                     new Thread(()-> {
                         Singleton1 inStance = singleton1.getInStance();

                         System.out.println(inStance);

                     },"2").start();



                      new Thread(()-> {
            Singleton1 inStance1 = singleton1.getInStance();

            System.out.println(inStance1);

        },"1").start();


    }

}
