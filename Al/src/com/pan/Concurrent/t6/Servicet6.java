package com.pan.Concurrent.t6;

/**
 * wait执行后会让出锁，而notify会执行完当前的同步代码快后释放锁
 */
public class Servicet6 {
    public void testMthod(Object lock)
    {
        try{
            synchronized (lock)
            {
                System.out.println("begin wait()");
                //lock.wait();
                Thread.sleep(10000);
                System.out.println("end wait");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
