package com.cas.shangguigu;

import java.util.concurrent.atomic.AtomicInteger;

/*
  cas是什么?  -->compreAndSet
   底层 unsafe类 底层执行 保证原子类 执行 不会造成所谓的数据不一致问题;
    缺点:
   1.cas失败.会一直进行尝试.cas长时间一直不成功,可以会给cpu带来很大的开销;
   2.只能保证一个共享变量的原子操作;
   3. aba问题;
   内存地址,this对象---
  Unsafe.getU
  private static final  long valueOffset   valueOffset=unsafe.objectField
  CAS --> Unsafe --->CAS底层思想--->ABA--->原子引用更新--->如何规避ABA问题;
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        //当线程1 执行时;期望值和原始值,一致. 更新 为100;
        //当线程1,执行时,期望值时5.原始值为100了. 更新不变;
        System.out.println(atomicInteger.compareAndSet(5, 100)+"cuttent data  "+atomicInteger.get());
         //期望值是5.但是原始值已经更新100;.更新值不变,为,原始值;
        System.out.println(atomicInteger.compareAndSet(5, 101)+"cuttent data  "+atomicInteger.get());

    }


}
