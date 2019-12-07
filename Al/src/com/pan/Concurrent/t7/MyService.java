package com.pan.Concurrent.t7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock=new ReentrantLock();
    public Condition conditionA=lock.newCondition();
    public Condition conditionB=lock.newCondition();

    public void awaitA(){
        try
        {
            lock.lock();
            System.out.println("begin await A 时间为 "+System.currentTimeMillis()+" ThreadName= "+Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end await A 时间为" +System.currentTimeMillis()+" ThreadName=" +Thread.currentThread().getName());
        }catch (Exception E)

        {
            E.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try
        {
            lock.lock();
            System.out.println("begin await B 时间为 "+System.currentTimeMillis()+" ThreadName= "+Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end await B 时间为" +System.currentTimeMillis()+" ThreadName=" +Thread.currentThread().getName());
        }catch (Exception E)

        {
            E.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_A(){

        try {
            lock.lock();
            System.out.println("signall  A 时间为 "+System.currentTimeMillis()+" ThreadName= "+Thread.currentThread().getName());
            conditionA.signalAll();

        }finally {
            lock.unlock();
        }
    }

    public void signalAll_B(){

        try {
            lock.lock();
            System.out.println("signall  B 时间为 "+System.currentTimeMillis()+" ThreadName= "+Thread.currentThread().getName());
            conditionB.signalAll();

        }finally {
            lock.unlock();
        }
    }
}
