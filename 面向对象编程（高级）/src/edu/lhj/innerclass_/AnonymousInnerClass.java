package edu.lhj.innerclass_;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer03 outer03 = new Outer03();
        outer03.f1();
    }
}

interface IA {//接口
    void cry();
}

class Father {
    public Father(String name) {
    }
    public void test() {

    }
}

class Outer03 {
    private int n1 = 10;
    public void f1() {
        //基于接口的匿名内部类
        //1.需求:想使用IA接口并创建对象
        //2.传统方法:是写一个类,实现该接口
        //3.然而Tiger这个类只使用一次,后面就不再使用,这就显得再创建一个类去实现一个接口变得很多余了
//        class Tiger implements IA{
//            @Override
//            public void cry() {
//                System.out.println("老虎叫...");
//            }
//        }
//        Tiger tiger = new Tiger();
//        tiger.cry();
        //4.可以使用匿名内部类来简化开发
        //5.tiger的编译类型是IA
        //6.tiger的运行类型是匿名内部类
        /*
        匿名内部类的底层动作
        XXXX就是系统分配的一个类名,真实的名字是Outer03$1
        class XXXX implements IA{
            @Override
            public void cry() {
                System.out.println("老虎叫...");
            }
        }
         */
        //7.jdk底层在创建匿名内部类Outer03$1时,立即就创建了匿名内部类Outer03$1
        // 的实例,并且把地址返回给 tiger
        //8.匿名内部类使用一次就不能再使用了
        IA tiger = new IA() {//基于接口的一个匿名内部类
            @Override
            public void cry() {
                System.out.println("老虎叫...");
            }
        };
        System.out.println("该匿名内部类的名字是: " + tiger.getClass());
        tiger.cry();

        Father father = new Father("Jack") {

        };
        System.out.println("father这个对象的运行类型为: " + tiger.getClass());
    }
}
