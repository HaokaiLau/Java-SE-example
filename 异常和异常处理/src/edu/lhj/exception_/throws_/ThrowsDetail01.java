package edu.lhj.exception_.throws_;

public class ThrowsDetail01 {
    public static void main(String[] args) {//main(String[] args) 后默认也隐藏了一个throws ArithmeticException
        f1();
    }

    public static void f1() /*throws ArithmeticException*/ {//f1() 后默认隐藏了一个throws ArithmeticException
        //1.对于编译异常,程序必须处理,如try-catch-finally或者throws
        //2.对于运行时异常,程序中如果没有处理,则默认用throws处理
        int n1 = 10;
        int n2 = 0;
        int res = n1 / n2;
    }
}

class Father {
    public void f2() throws RuntimeException {

    }
}
class Son extends Father {
    @Override
    //3.子类重写父类方法时,子类重写的方法所抛出的异常必须要么
    // 和父类抛出类型一致,要么是父类抛出类型的子类
    public void f2() throws NullPointerException {
        super.f2();
    }
}
