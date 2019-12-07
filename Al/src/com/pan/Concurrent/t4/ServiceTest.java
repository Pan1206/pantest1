package com.pan.Concurrent.t4;


import com.pan.Concurrent.t2.MyObject;

/**
 * synchronized(非this对象X)是将x本身作为“监视对象器”
 * synchronized（this）是将当前对象作为一个监视对象器
 * 俩者并不是竞争一把锁，所以会以异步的方式执行，前提是this非this对象，否则是在竞争同一个锁，呈现处同步的效果
 *
 */
public class ServiceTest {

    public void testMethod1(MyObject object)
    {
        synchronized (object)
        {
            try {
                System.out.println("testMethod1___getLock time=" + System.currentTimeMillis()
                        + "run ThreadName= " + Thread.currentThread().getName());

                Thread.sleep(2000);
                System.out.println("testMethod1 releaseLock time= "+
                System.currentTimeMillis()+" run ThreadName= "
                +Thread.currentThread().getName());
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public void testMethod2(MyObject object)
    {
        synchronized (this)
        {
            try {
                System.out.println("test2--"+System.currentTimeMillis()+"run ThreadName "+Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("test2 releaseLock time= "+
                        System.currentTimeMillis()+" run ThreadName= "
                        +Thread.currentThread().getName());
            }catch (Exception E)
            {
                E.printStackTrace();
            }


        }
    }
}

