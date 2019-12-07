package com.pan.Concurrent.t6;

public class Runt61 {
    public static void main(String[] args) {
        Object lock=new Object();
        ThreadA a=new ThreadA(lock);
        a.start();
        ThreadB B=new ThreadB(lock);
        B.start();
    }
}
