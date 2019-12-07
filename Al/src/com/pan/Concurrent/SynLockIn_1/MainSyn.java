package com.pan.Concurrent.SynLockIn_1;

public class MainSyn {
    public int i=10;
    synchronized public void operateMainMethod()  {

        try
        {
            i--;
            System.out.println("main print i="+i);
            Thread.sleep(100);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    synchronized public void  methodPrint(){
        System.out.println("test 123"+(++i));
    }
}
