package com.pan.Concurrent.t5;

public class MyObjectt5 {

    synchronized public void speedPrintString(){

        System.out.println("speedPrintString_____getLock time=" + System.currentTimeMillis()
                + "run ThreadName= " + Thread.currentThread().getName());

        System.out.println("------------------");
        System.out.println("speedPrintString____ releaseLock time= "+
                System.currentTimeMillis()+" run ThreadName= "
                +Thread.currentThread().getName());
    }
}
