package com.pan.Concurrent.t6;

public class Runt6 extends Thread{
    public static void main(String[] args) {
        final OutClass.InnerClass1 in1=new OutClass.InnerClass1();
        final OutClass.InnerClass2 in2=new OutClass.InnerClass2();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                in1.method1(in2);
            }
        },"T1");

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                in1.method2();
            }
        },"t2");

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                in2.method1();
            }
        },"t3");

       t1.start();
       t2.start();
       t3.start();
    }
}
