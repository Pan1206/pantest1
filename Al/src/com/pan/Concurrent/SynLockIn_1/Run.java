package com.pan.Concurrent.SynLockIn_1;

/**
 * "可重入锁“：自己再次获得自己内部的锁
 *  可重入锁也可以用于在父子类继承
 */
public class Run {
    public static void main(String[] args) {
        MyThread t=new MyThread();
        t.start();
    }
}
