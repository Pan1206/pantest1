package com.pan.al.test.outerinterclass;

//内部类测试
public class Outer {

    private String str="hello world";
    private String name="name";
    private static int ccc=1;
    public static void wangyi()
    {
        System.out.println("想来网易吗");

    }
    private void haikang(){
        System.out.println("想来海康吗");
    }

    //成员内部类
    public class Inter{
        //成员内部类不有任何的static的变量和方法，就像类方法里面不能定义static一样
        //public static String count;
        public static final int count=1;
        private String str1;
        private String name="user";
         Inter(){
            this.str1=str+" pan";
        }
        private void printStr()
        {
            //
            System.out.println(str);
            System.out.println(count);
            System.out.println(str1);
            //当成员内部类与外部成员类有相同的成员变量名时，默认使用成员内部类自己的，要使用外部类的可以要 Outer.this.属性名
            System.out.println(name);
            System.out.println(Outer.this.name);
        }
        //成员内部类可以无条件的访问外部类的所有成员属性和成员方法（包括private和static成员）
        public void printStr1(){
            System.out.println(str);
            wangyi();
        }

    }

    /*局部内部类
      访问权限只限于方法内部或者作用域内部，想要用方法里的形参，方法的形参要用final修饰，JDK8形参变为隐式final声明
      不能有public protected private以及static修饰符
    */
    public void wangUser(final String str)
    {
         class MethodClass1{
            private void COUT(){
                System.out.println(str);
            }
        }
        new MethodClass1().COUT();
    }

    /**静态内部类***/
      /**使用static修饰的内部类我们称之为静态内部类，
      非静态内部类在编译完成之后会隐含的保存着一个引用，该引用是指向创建它的外部类，但是静态类没有。没有这个引用就意味着：
     1.静态内部类的创建不需要依赖外部类可以直接创建。
     2.静态内部类不可以使用任何外部类的非static类（包括属性和方法），但可以存在自己的成员变量，
        但是可以通过new外部类来访问

      不能在静态内部类中写抽象方法

　　　2、外部类如何调用静态内部类中的属性和方法

　　　1）外部类可以通过创建静态内部类实例的方法来调用静态内部类的非静态属性和方法

　　　2）外部类可以直接通过“ 外部类.内部类.属性（方法）” 的方式直接调用静态内部类中的静态属性和方法

　　　3、静态内部类如何调用外部类的属性和方法　

　　　1）静态内部类可以直接调用外部类的静态属性和方法

　　　2）静态内部类可以通过创建外部类实例的方法调用外部类的非静态属性和方法

　　　4、如何创建静态内部类实例

　　　1）在非外部类中：外部类名.内部类名 name = new 外部类名.内部类名();

　　　2）在外部类中：内部类名 name = new 内部类名();

     */
     //静态内部类
    static class Inter1{
        private String name="静态内部类";
        public static int c;
        public void printWang(){
            //不能直接使用外部非静态类，需要new外部类
            Outer outer=new Outer();
            outer.haikang();
            System.out.println(outer.str);
            //System.out.println(str);
            //可以使用外部类的静态方法和静态变量
            wangyi();
            System.out.println(ccc);
            System.out.println(name);
        }

        public static void printLi(){
            System.out.println("静态方法调用");
        }
    }
    //外部类可以直接使用静态内部类
    public void testInter1(){
        Inter1.c=2;
        Inter1.printLi();

    }


    /*
       匿名内部类的使用
     */

    //成员内部类测试
    public static void test1()
    {
       Outer.Inter inter=new Outer().new Inter();
        inter.printStr();


    }
    //局部内部类测试

    public static void test2(){
        Outer outer=new Outer();
        outer.wangUser("123");
    }
    //静态内部类测试
    public static void test3(){
        Inter1.printLi();

        Outer outer=new Outer();
        outer.testInter1();
    }

    public static void main(String[] args) {
        //静态内部类可以直接new 可以不用通过外部类创建
        Inter1 inter1=new Inter1();
        inter1.printWang();
        test3();

    }
}
