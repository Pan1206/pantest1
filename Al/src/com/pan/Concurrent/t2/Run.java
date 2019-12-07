package com.pan.Concurrent.t2;

/**
 *  结论：1）如果A线程先持有object对象的Lock锁，B线程可以以异步的方式调用object 对象中的非 synchronizedd的方法；
 *       2）若B想调用其他的 synchronized的方法也是同步机制；
 *       3）注意在读取修改某个值时一定要做到同步，防止脏读现象；
 */
public class Run {
    public static void main(String[] args) {
        MyObject object=new MyObject();
        ThreadA a=new ThreadA(object);
        a.setName("A");
        ThreadB b=new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }
}
