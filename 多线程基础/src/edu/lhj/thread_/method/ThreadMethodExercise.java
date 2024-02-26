package edu.lhj.thread_.method;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Hi hi = new Hi();
        Thread thread = new Thread(hi);
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
            if (i == 5) {
                thread.start();//子线程启动
                thread.join();//子线程插队
            }
            if (i == 10) {
                System.out.println("主线程结束...");
            }
        }
    }
}

class Hi implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello " + i);
            if (i == 10) {
                System.out.println("子线程结束...");
            }
        }
    }
}
