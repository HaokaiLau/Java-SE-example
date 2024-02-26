package edu.lhj.thread_.method;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        Thread thread = new Thread(t2);
        thread.start();//启动子线程
        for (int i = 0; i <= 20; i++) {
            Thread.sleep(1000);
            if (i == 5) {
                System.out.println("t2线程插队,让t2先执行完毕...");
                thread.join();//t2线程插队,等t2线程执行完毕再回来执行剩下的主线程
                //Thread.yield();//主线程礼让,让其他线程先执行,但是不一定能礼让成功,
                //这取决于cpu的处理能力
            }
            System.out.println("主线程正在运行..." + i);
        }
    }
}
class T2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程正在运行..." + i);
        }
    }
}
