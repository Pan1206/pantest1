package com.pan.Concurrent.t3;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class MyThread1 extends Thread{
    private Task1 task;
    public MyThread1(Task1 task)
    {
        super();
        this.task=task;
    }

    @Override
    public void run() {
        super.run();
        CommUtils.beginTime1=System.currentTimeMillis();
        task.doLongTimeTask();
        CommUtils.endTime1=System.currentTimeMillis();
    }
}
