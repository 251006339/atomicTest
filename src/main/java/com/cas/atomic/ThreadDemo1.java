package com.cas.atomic;


 class ThreadA extends  Thread{
     private static String name=null;
     String name1=null;
     public ThreadA() {
     }

     @Override  //无返回值的多线程;
    public void run() {

        System.out.println(Thread.currentThread().getName()+"当前线程的名字");

    }
}



public  class ThreadDemo1 {
    private static String name=null; //先加载静态方法
    public static void main(String[] args) {

        for (int i = 0; i <10 ; i++) {
            ThreadA threadA=new ThreadA();
            //只能执行一次;
            threadA.start();
        }





    }








}
