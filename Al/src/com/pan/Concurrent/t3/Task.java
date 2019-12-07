package com.pan.Concurrent.t3;

import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;

public class Task {

    private String getData1;
    private String getData2;
    public synchronized void doLongTimeTask(){

        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String getData1 = "长时间处理任务后从远程返回的值1 threadName= " + Thread.currentThread().getName();
            String getData2 = "长时间处理任务后从远程返回的值2 threadName= " + Thread.currentThread().getName();

//            synchronized (this)
//            {
//                getData1=getData11;
//                getData2=getData22;
//            }

            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end Task");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
