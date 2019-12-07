package com.pan.Concurrent.SynLockIn_1;

public class MyThread1 extends Thread{
    @Override
    public void run() {
        Sub sub=new Sub();
        //sub.operateISubMethod();
        sub.methodPrint();
    }
}
