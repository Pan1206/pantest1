package com.pan.Concurrent.SynLockIn_1;
/*
 同步不可以继承，子类方法要加syn才能同步
 */
public class MainSyn2 {
     synchronized public void serviceMethod(){
         try {
             System.out.println("in main next sleep begin threadName="
             + Thread.currentThread().getName()+"time="
             +System.currentTimeMillis());
             Thread.sleep(5000);
             System.out.println("in main next sleep end threadName="
             +Thread.currentThread().getName()+" time="
             +System.currentTimeMillis());
         }catch (Exception e)
         {
             e.printStackTrace();
         }
     }
}
