package com.pan.Concurrent.t6;

/**
 * wait/notify模式
 */

public class MyRunnable
{
    static private Object lock=new Object();

    static private Runnable runnable1=new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock)
                {
                    System.out.println("wait begin timer= "
                    +System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("wait end timer="
                    +System.currentTimeMillis());
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    };

    static private Runnable runnable2=new Runnable() {
        @Override
        public void run() {
            synchronized (lock)
            {
                try {
                    System.out.println("notify begin timer= "
                            +System.currentTimeMillis());
                    lock.notify();
                    System.out.println("notify end timer="
                            +System.currentTimeMillis());
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        }
    };


    public static void main(String[] args)throws Exception
    {
        Thread t1=new Thread(runnable1);
        t1.start();
        Thread.sleep(3000);//通知不能过早,否则会被打乱顺序
        Thread t2=new Thread(runnable2);
        t2.start();
    }
}
