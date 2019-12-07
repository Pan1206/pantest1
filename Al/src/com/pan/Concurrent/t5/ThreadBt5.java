package com.pan.Concurrent.t5;

public class ThreadBt5 extends Thread{
    private MyObjectt5 myObjectt5;

    public ThreadBt5(MyObjectt5 myObjectt5)

    {
        super();
        this.myObjectt5=myObjectt5;
    }

    @Override
    public void run() {
        super.run();
        myObjectt5.speedPrintString();
    }
}
