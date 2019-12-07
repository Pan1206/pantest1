package com.pan.Concurrent.SynLockIn_1;

/**
 * 1）当存在父子类继承关系时，子类是完全可以通过"可重入锁”调用父类的同步方法的；
 * 2）虽然可以使用synchronized来定义方法，但synchronized并不属于方法定义的一部分，
 * 因此，synchronized关键字不能被继承。如果在父类中的某个方法使用了synchronized关键字，
 * 而在子类中覆盖了这个方法，在子类中的这个方法默认情况下并不是同步的，
 * 而必须显式地在子类的这个方法中加上synchronized关键字才可以。
 * 当然，还可以在子类方法中调用父类中相应的方法，这样虽然子类中的方法不是同步的，
 * 但子类调用了父类的同步方法，因此，子类的方法也就相当于同步了。这两种方式的例子代码如下：
 * 在子类方法中加上synchronized关键字
 */
public class Run1 {
    public static void main(String[] args) {
          MyThread1 myThread1=new MyThread1();
          myThread1.start();
    }
}
