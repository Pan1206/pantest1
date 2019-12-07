package com.pan.Concurrent.SynLockIn_1;

public class Sub extends MainSyn {
    //
    synchronized public void operateISubMethod()  {

        try
        {   while (i>0) {
            i--;
            System.out.println("sub print i=" + i);
            Thread.sleep(100);
            this.operateMainMethod();
        }
        }catch (Exception e)
            {
                e.printStackTrace();
            }


    }
    @Override
     synchronized public void methodPrint(){
         System.out.println("我是子类"+(++i));
         //super.methodPrint();
     }
}
