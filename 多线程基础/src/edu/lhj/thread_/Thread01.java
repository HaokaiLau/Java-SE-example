package edu.lhj.thread_;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Thread01 {
    //1.当启动进程时,首先会先开启一个main线程(即主线程)
    public static void main(String[] args) throws InterruptedException {
        //创建Cat对象,可以当作线程使用
        Cat cat = new Cat();
        //2.当main线程启动一个子线程Thread-0时,main线程没有阻塞,会继续执行
        //此时main线程和子线程是交替执行(并发)
        cat.start();//启动线程
        //cat.run();//run方法就是一个普通的方法,如果是用run方法,进程就会阻塞在这,
        //等run方法执行完毕后再执行下面的语句
        System.out.println("主线程" + Thread.currentThread().getName());
        for (int i = 1; i <= 60; i++) {
            System.out.println("主线程i=" + i);
            Thread.sleep(1000);//向上抛出异常
        }
        //3.当所有的线程(包括所有的子线程)都执行完毕后,进程才会真正的结束

        /* 源码解读
        1.
        public synchronized void start() {
            start0();
        }
        2.start0()是一个本地方法,是由JVM机调用的,底层是C/C++实现的
        private native void start0();
        3.所以真正实现多线程效果,是由start0()方法实现的,而不是run方法
         */
    }
}

//1.当一个类继承了 Thread类,那该类就可以当作一个线程使用
//2.我们会重写run方法,写上自己的业务逻辑
//3.Thread类 实现了 Runnable接口 的run方法
/*
//Thread类的run方法
    @Override
        public void run() {
            if (target != null) {
                target.run();
            }
        }
 */
class Cat extends Thread {
    @Override
    public void run() {//java中真正实现多线程的是star中的star0()方法,run()方法只是一个普通方法
        int times = 0;
        while (true) {
            System.out.println("喵喵喵" + ++times + Thread.currentThread().getName());
            try {
                //sleep方法是让进程休眠的方法,以毫秒计数
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 80) {
                break;//当进程执行10次后就退出进程
            }
        }
    }
}