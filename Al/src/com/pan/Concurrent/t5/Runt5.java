package com.pan.Concurrent.t5;

/**
 *   当一个线程执行synchronized(非this对象X)时，另一个线程执行x对象中的同步方法或者同步代码块时，成同步效果
 *
 */
public class Runt5 {

    public static void main(String[] args) throws Exception{
        Servicet5 servicet5=new Servicet5();
        MyObjectt5 myObjectt5=new MyObjectt5();
        ThreadAt5 a=new ThreadAt5(myObjectt5,servicet5);
        a.setName("a");
        a.start();
        Thread.sleep(100);
        ThreadBt5 B=new ThreadBt5(myObjectt5);
        B.setName("B");
        B.start();
    }
}
