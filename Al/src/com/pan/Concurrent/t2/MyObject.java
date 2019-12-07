package com.pan.Concurrent.t2;



public class MyObject {
    synchronized public void methodA(){

        try {
            System.out.println("begin method A threadName="+
            Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("A end endTime="+System.currentTimeMillis());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

         public void methodB(){

        try {
            System.out.println("begin method B threadName="+
                    Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("B end endTime="+System.currentTimeMillis());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
