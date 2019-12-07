package com.pan.Concurrent.SynLockIn_1;
//同步不可以继承，子类方法要加syn才能同步
public class run2 {
    public static void main(String[] args) {
        Sub2 sub2=new Sub2();
        MyThreadA2 a=new MyThreadA2(sub2);
        a.setName("A");
        a.start();
        MyThreadB2 b=new MyThreadB2(sub2);
        b.setName("B");
        b.start();
    }

}
