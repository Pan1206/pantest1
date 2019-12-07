package com.pan.Concurrent.t2;

public class ThreadA extends Thread{
    private MyObject object;

    public ThreadA(MyObject myObject)
    {
        super();
        this.object=myObject;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
