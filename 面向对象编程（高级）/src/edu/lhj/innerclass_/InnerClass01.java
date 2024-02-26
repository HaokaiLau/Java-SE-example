package edu.lhj.innerclass_;

public class InnerClass01 {
    public static void main(String[] args) {

    }
}

class Outer {//外部类
    private int n1 = 10;

    public Outer(int n1) {
        this.n1 = n1;
    }

    {
        System.out.println("这是外部类的第一个代码块");
    }
    public void hi() {
        System.out.println("这是外部类的一个方法");
    }
    class Inner {//内部类
        public void hello() {
            System.out.println("这是内部类的一个方法");
        }
    }
}