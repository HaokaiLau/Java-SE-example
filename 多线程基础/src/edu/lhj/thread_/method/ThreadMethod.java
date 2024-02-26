package edu.lhj.thread_.method;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        Eat eat = new Eat();
        Thread thread = new Thread(eat);
        thread.setName("lhj");
        thread.setPriority(Thread.MIN_PRIORITY);//1
        thread.start();//启动子线程
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);//让主线程休眠1秒
            System.out.println(i);
        }
        thread.interrupt();//中断子线程当前的行为(提前结束子线程当前的行为)
    }
}

class Eat implements Runnable {

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() +
                        " 在吃包子" + i);
            }
                try {
                    System.out.println(Thread.currentThread().getName() +
                            "线程休眠了");
                    Thread.sleep(20000);//休眠20秒
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() +
                            "线程的休眠被interrupt了");
                }
        }
    }
}
