package com.pan.Concurrent.t3;

/**
 * 注意：方法中既有Synchroized 又有非synchroized修饰的代码块，会出现异步和同步现象
 */
public class Task1 {

    public void doLongTimeTask()
    {
        for(int i=0;i<100;i++)
        {
            System.out.println("nosynchronized threadName"
            +Thread.currentThread().getName()+" i="+(i+1));
        }
        System.out.println("  ");
        synchronized (this)
        {
            for(int i=0;i<100;i++)
            {
                System.out.println("synchronized threadName"
                        +Thread.currentThread().getName()+" i="+(i+1));
            }
        }
    }
}
