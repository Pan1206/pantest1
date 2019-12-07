package com.pan.Concurrent.t3;

public class Run {
    public static void main(String[] args) {
        Task1 task=new Task1();
        MyThread1 thread1=new MyThread1(task);
        thread1.start();
        MyThread2 thread2=new MyThread2(task);
        thread2.start();
        try {
            Thread.sleep(10000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        long beginTime=CommUtils.beginTime1;
        if(CommUtils.beginTime2<CommUtils.beginTime1)
            beginTime=CommUtils.beginTime2;

        long endTime=CommUtils.endTime1;
        if(CommUtils.endTime2>CommUtils.endTime1)
            beginTime=CommUtils.beginTime2;

        System.out.println("耗时+:"+(endTime-beginTime)/1000);


    }
}
