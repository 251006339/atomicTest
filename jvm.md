jmm     不是真实存在
 共享变量  主内存
 1.可见性
 2.原子性
 3.有序性
 
 volatile   1.可见性   2.不保证原子性  3.禁止指令重排
 final :值不可修改

  原子性: AtomicInteger  AtomicRefen    
          getAndIncrement();
          AtomicStampedRewference  --防止ABA问题
          
   CAS :比较并交换   
                手写CAS
               unsafe--内存偏移地址获取数据
   集合并发List:CopyOnWriteArrayList
           Set:CopyOnWriteArraySet        
          AtomicRefen

         
 
 并发 CountDownLatch<减1>   Cyclicarrier<加1>  Semaphore<信号量>
 
 公平锁非公平锁 
    执行的线程有排序功能;
          
 重入锁 --递归锁  ReentrantLock Synchrion
 读写锁
 
 阻塞队列  ---并发队列  Queue
 
 synchronized 和lock区别
 
 线程池
 
 jvm 参数
  gc
  强引用:
  软引用:  如果内存不足,会被gc回收 --原理mybatis内存
  弱引用:
  WeakHashmap : 软
 
 
 