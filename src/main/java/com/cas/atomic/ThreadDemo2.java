package com.cas.atomic;


 class ThreadB implements   Runnable{
     //加上了volatile 无原子性
     public  static Integer id=0; //静态的储存元空间,栈执行的时候会加载到main主栈中;
     String name1=null;
     public ThreadB() {

     }

     @Override  //无返回值的多线程;
    public void run() {
         //重排序执行的时候 ,有时会先执行system
         synchronized (this) {
             id++;
             System.out.println(Thread.currentThread().getName()+"当前线程的名字"+id);
         }



    }
}


public  class ThreadDemo2 {
    private static  String name=null; //先加载静态方法
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();

        for (int i = 0; i <100 ; i++) {

          //设置线程的名字/
             new Thread(threadB,String.valueOf(i)).start();//执行线程

        }
        Integer id = threadB.id;
        System.out.println(id );
        try {
            Thread.sleep(5000); //栈内存没有实施更新 会导致前后不一致,加上volatile会一致;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer id1 = threadB.id;
        System.out.println(id1 );

    }








}
