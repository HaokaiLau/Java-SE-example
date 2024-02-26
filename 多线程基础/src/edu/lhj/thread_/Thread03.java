package edu.lhj.thread_;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);
        thread.start();//启动第一个线程
        thread1.start();//启动第二个线程
    }
}

class T1 implements Runnable {
    int count = 0;
    @Override
    public void run() {
        //每隔一秒输出一个hello,world,输出10次然后退出
        while (true) {
            System.out.println("hello,world" + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}

class T2 implements Runnable {
    int count = 0;
    @Override
    public void run() {
        //每隔一秒输出一个hello,world,输出10次然后退出
        while (true) {
            System.out.println("hi" + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}