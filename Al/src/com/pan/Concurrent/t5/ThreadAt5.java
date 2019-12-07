package com.pan.Concurrent.t5;

public class ThreadAt5 extends Thread{
    private MyObjectt5 myObjectt5;
    private Servicet5 servicet5;

    public ThreadAt5(MyObjectt5 myObjectt5,Servicet5 servicet5)
    {
        super();
        this.myObjectt5=myObjectt5;
        this.servicet5=servicet5;
    }

    @Override
    public void run() {
        super.run();
        servicet5.testMthod1(myObjectt5);
    }
}
