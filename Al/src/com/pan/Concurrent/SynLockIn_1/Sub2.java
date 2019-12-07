package com.pan.Concurrent.SynLockIn_1;

import java.io.SyncFailedException;

/*
 同步不可以继承，子类方法要加syn才能同步
 */
public class Sub2 extends MainSyn2{
    @Override
     public  synchronized void serviceMethod() {

        try {
            System.out.println("in sub next sleep begin threadName="
                    + Thread.currentThread().getName()+" time="
                    +System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("in sub next sleep end threadName="
                    +Thread.currentThread().getName()+" time="
                    +System.currentTimeMillis());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        super.serviceMethod();
    }
}
