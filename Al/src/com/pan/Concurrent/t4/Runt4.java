package com.pan.Concurrent.t4;

import com.pan.Concurrent.t2.MyObject;

public class Runt4 {
    public static void main(String[] args) {
        ServiceTest serviceTest=new ServiceTest();
        MyObject myObject=new MyObject();
        ThreadAA aa=new ThreadAA(serviceTest,myObject);
        aa.setName("a");
        aa.start();
        ThreadBB bb=new ThreadBB(serviceTest,myObject);
        bb.setName("b");
        bb.start();

    }
}
