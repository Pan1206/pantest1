package com.pan.Concurrent.base;

public class SynTest implements Runnable{
    //共享资源变量
    private int count = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+":"+count++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynTest syncTest1 = new SynTest();
        SynTest syncTest2 = new SynTest();
        Thread thread1 = new Thread(syncTest1,"thread1");
        Thread thread2 = new Thread(syncTest2, "thread2");
        thread1.start();
        thread2.start();
    }

}