package com.pan.al.test.Thread;

public class test7 {

    public static class SecondThread implements Runnable{

        @Override
        public void run() {
            System.out.println("UUUU");
        }
    }
    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20){
                SecondThread st = new SecondThread();
                new Thread(st, "new thread 1").start();
            }
        }
    }
}
