package com.pan.Concurrent.t5;

import com.pan.Concurrent.t2.ThreadB;

public class Servicet5 {

    public void testMthod1(MyObjectt5 myObjectt5)
    {
        synchronized (myObjectt5)
        {
            try{
                System.out.println("testMthod1_____getLock time=" + System.currentTimeMillis()
                        + "run ThreadName= " + Thread.currentThread().getName());

                Thread.sleep(5000);
                System.out.println("testMthod1____ releaseLock time= "+
                        System.currentTimeMillis()+" run ThreadName= "
                        +Thread.currentThread().getName());
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
