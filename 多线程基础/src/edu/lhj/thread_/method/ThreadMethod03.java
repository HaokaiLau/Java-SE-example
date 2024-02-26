package edu.lhj.thread_.method;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyDaemonThread());
        //守护线程:当主线程结束时,无论子线程是否是无限循环的线程,都会伴随主线程的结束而结束
        thread.setDaemon(true);//把子线程设置成守护线程
        thread.start();//启动子线程
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(500);
            System.out.println("主线程正在运行... " + i);
        }
    }
}

class MyDaemonThread implements Runnable {

    public int count = 0;

    @Override
    public void run() {
        for ( ; ;) {//无限循环
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程正在运行... " + (++count));
        }
    }
}