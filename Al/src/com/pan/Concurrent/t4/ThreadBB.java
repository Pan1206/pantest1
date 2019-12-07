package com.pan.Concurrent.t4;

import com.pan.Concurrent.t2.MyObject;

public class ThreadBB extends Thread{
    private ServiceTest serviceTest;
    private MyObject myObject;

    public ThreadBB(ServiceTest serviceTest,MyObject myObject)
    {
        super();
        this.myObject=myObject;
        this.serviceTest=serviceTest;
    }

    @Override
    public void run() {
        super.run();
        serviceTest.testMethod2(myObject);
    }
}
