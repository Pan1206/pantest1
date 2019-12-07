package com.pan.Concurrent.SynLockIn_1;

public class MyThreadA2 extends Thread{
    private Sub2 sub2;
    public MyThreadA2(Sub2 sub2)
    {
        this.sub2=sub2;
    }

    @Override
    public void run() {
        sub2.serviceMethod();
    }
}
