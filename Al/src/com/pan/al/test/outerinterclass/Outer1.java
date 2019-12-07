package com.pan.al.test.outerinterclass;
//匿名内部类
public class Outer1 {


        public static String s1 = "this is s1 in Outer";
        public static String s2 = "this is s2 in Outer";
        private static String s3 = "this is s3 in Outer";
        public String s4="this is s4 in outer";
        public void method1(Inner inner) {
            System.out.println(inner.say());
        }

        private static String method2() {
            return "this is method2 in Outer";
        }

    /**
     *  1.匿名内部类只能被使用一次，创建匿名内部类时它会立即创建一个该类的实例，该类的定义也就立即消失。
     *  2.使用匿名内部类的时候必须实现接口或者继承一个类（有且只有一个）
     *  3.匿名内部类因为没有类名，可知匿名内部类不能定义构造器
     *  4.匿名内部类不存在任何的静态变量和方法的
     *  5.当匿名内部类和外部类有同名变量（方法）时，默认访问的是匿名内部类的变量（方法），要访问外部类的变量（方法）则需要加上外部类的类名
     *  6.内部类可以访问外部类私有变量和方法。
     * @param args
     */
    public static void main(String[] args) {
            Outer1 outer = new Outer1();
            // 测试1，Inner为接口
            outer.method1(new Inner() {
                String s1 = "this is s1 in Inner";

                public String say() {
                    // 外部类和匿名内部类中有同名变量s1，使用匿名内部类自己的

                   // System.out.println(outer.s4);
                    return s1;
                }
            });
            // 测试2，Inner1为抽象类
            outer.method1(new Inner1() {
                 String s2 = "this is s2 in Inner1";

                public String say() {
                    // 匿名内部类中有同名变量s2，使用外部类的同名的，要用类名.变量
                    return Outer1.s2;
                }
            });
            // 测试3，Inner2为普通类
            outer.method1(new Inner2() {
                public String say() {
                    // 访问外部类私有变量s3
                    return s3;
                }
            });
            // 测试4，Inner2为普通类
            outer.method1(new Inner2() {
                public String say() {
                    // 访问外部类私有方法method1()
                    return method2();
                }
            });
        }

}
