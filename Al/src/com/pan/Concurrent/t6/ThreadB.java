package com.pan.Concurrent.t6;

public class ThreadB extends Thread{
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Servicet6 servicet6=new Servicet6();
        servicet6.testMthod(lock);
    }
}
