package com.pan.Concurrent.t3;

/** synchronized (this)
 * 在使用同步代码块的时候要注意。当一个线程访问了object的一个同步代码块时，其他线程对同一个object
 * 中所有其他的同步代码块的访问将被阻塞，这说明synchronized使用的”对象监视器“是一个；
 */
public class ObjectService {
    public void serviceMetodA(){

        try{
            synchronized (this)
            {
                System.out.println("A begin time ="+System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("A end time ="+System.currentTimeMillis());
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void serviceMethodB(){
      synchronized (this)
      {

              System.out.println("b begin time ="+System.currentTimeMillis());
              System.out.println("b end time ="+System.currentTimeMillis());

      }
    }
}
