package edu.lhj.exception_.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws01 {
    public static void main(String[] args) {
        Throws01 throws01 = new Throws01();
        //throws01.f3();f3方法仍不对异常进行处理,则把异常抛出到main方法中
    }

    public void f3() throws Exception {
            f2();
    }

    public void f2() throws Exception {
        f1();
    }

    public void f1() throws FileNotFoundException {
        //1.这里的FileNotFoundException是一个编译异常
        //2.可以使用try-catch-finally异常处理机制来处理该异常
        //3.也可以使用throws来向上抛出该异常,让调用f1方法的调用者处理该异常
        //4.若调用f1方法的调用者也不处理该异常,则继续向上面的调用者抛出该异常
        //5.若一直没有调用者处理该异常,则异常抛出到JVM中,JVM会直接输出该异常
        //注意:throws后面可以是Exception(父类),也可以是异常列表(即多个异常类型)
        FileInputStream fileInputStream = new FileInputStream("d://aa.txt");
    }
}
