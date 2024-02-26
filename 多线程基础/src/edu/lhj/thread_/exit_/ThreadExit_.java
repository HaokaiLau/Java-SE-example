package edu.lhj.thread_.exit_;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        Thread thread = new Thread(t);
        thread.start();//启动T线程
        System.out.println("主线程休眠10秒...");
        Thread.sleep(10 * 1000);//让主线程休眠10秒
        //如果希望主线程去控制t线程的终止,必须修改loop
        //让t线程退出run方法,从而终止t线程,我们把这种方式称为通知方式
        t.setLoop(false);
    }
}

class T implements Runnable {

    private int count = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);//让该线程休眠50毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中..." + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}