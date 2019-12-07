package com.pan.Concurrent.t2;

public class ThreadB extends Thread{
    private MyObject object;

    public ThreadB(MyObject myObject)
    {
        super();
        this.object=myObject;
    }

    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}

