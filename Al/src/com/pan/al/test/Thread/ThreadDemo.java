package com.pan.al.test.Thread;


import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void createOrder() {
        // 比如我们同一时间，只允许一个线程创建订单
        reentrantLock.lock();
        // 通常，lock 之后紧跟着 try 语句
        try {
            System.out.println(Thread.currentThread().getId() + " 线程 START"  );
        } finally {
            // 释放锁
            reentrantLock.unlock();
        }
    }



    public static void main(String[] args) {


        for(int i=0;i<20;i++)
        {
            new Thread(new Runnable(){

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId()+"中秋快乐111");
                    createOrder();
                }

            }).start();
        }

    }
}
