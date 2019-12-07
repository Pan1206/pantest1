package com.pan.Concurrent.t4;

import com.pan.Concurrent.t2.MyObject;

public class ThreadAA extends Thread{
    private ServiceTest serviceTest;
    private MyObject myObject;

    public ThreadAA(ServiceTest serviceTest,MyObject myObject)
    {
        super();
        this.myObject=myObject;
        this.serviceTest=serviceTest;
    }

    @Override
    public void run() {
        super.run();
        serviceTest.testMethod1(myObject);
    }
}
