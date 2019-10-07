package com.cas.shangguigu;


/*
  禁止重排序
 */

public class VolatileDemo1 {
  int a=0;
boolean flag=false;
public void method01(){
   a=1;        //语句1
    flag=true;   //语句2
}
public void method02(){
    if(flag){
        a=a+5;
        //一个结果是5 ,一个结果是6
        System.out.println("______retValue---> "+ a);
    }
}
//多线程环境中线程交替执行,由于编译器优化重排的存在
//两个线程中使用的变量能否保持一致性是无法确定的,结果无法预测;
    public static void main(String[] args) {
        VolatileDemo1 volatileDemo1=new VolatileDemo1();
        for (int i = 0; i <19999 ; i++) {
            new Thread(()->volatileDemo1.method01()).start();
            new Thread(()->volatileDemo1.method02()).start();
        }


    }


}
