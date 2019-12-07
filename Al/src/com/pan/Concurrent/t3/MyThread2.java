package com.pan.Concurrent.t3;

public class MyThread2 extends Thread{
    private Task1 task;
    public MyThread2(Task1 task)
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
