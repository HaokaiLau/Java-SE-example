package edu.lhj.thread_.state_;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new T());
        //新建线程时的状态 NEW
        System.out.println(thread.getName() + " 状态: " + thread.getState());
        thread.start();//启动子线程
        while (Thread.State.TERMINATED != thread.getState()) {//只要线程没有终止就会一直输出线程的状态
            Thread.sleep(500);
            //线程运行时的状态 Runnable
            System.out.println(thread.getName() + " 状态: " + thread.getState());
        }
        //线程终止时的状态 TERMINATED
        System.out.println(thread.getName() + " 状态: " + thread.getState());
    }
}

class T implements Runnable {

    @Override
    public void run() {
        while (true) {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hi" + i);
            }
            break;
        }
    }
}
