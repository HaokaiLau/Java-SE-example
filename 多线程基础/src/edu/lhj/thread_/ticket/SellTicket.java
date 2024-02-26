package edu.lhj.thread_.ticket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 使用多线程模拟三个窗口同时售票(100张)
 */
public class SellTicket {
    public static void main(String[] args) {
//        //测试 继承Thread类
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//        sellTicket01.start();//启动第一个线程
//        sellTicket02.start();//启动第二个线程
//        sellTicket03.start();//启动第三个线程

        //测试 实现Runnable接口
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();//启动第一个线程
        new Thread(sellTicket02).start();//启动第二个线程
        new Thread(sellTicket02).start();//启动第三个线程
    }
}

//继承Thread类
class SellTicket01 extends Thread {
    //三个对象同时使用一个票数,推荐使用静态常量
    public static int tickNum = 100;

    @Override
    public void run() {
        while (true) {
            if (tickNum <= 0) {
                System.out.println("票已售空...");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //由于线程可能会存在同时争夺资源的问题
            //所以会出现几个线程同时进入if语句判断,这可能会导致部分线程会出现和其他线程一样的判断结果
            //当线程进入休眠后,哪个线程先醒过来就会先进行抢票,就会出现超量卖票的情况
            System.out.println(Thread.currentThread().getName() + "窗口售出一张票" +
                    " 当前剩余 " + --tickNum + " 张票");
        }
    }
}

//实现Runnable接口
class SellTicket02 implements Runnable {
    //这里不用静态常量,原因是我们将来只需要创建一个该类的对象
    //把该类的对象放入不同的Thread对象中即可
    public int tickNum = 100;

    @Override
    public void run() {
        while (true) {
            if (tickNum <= 0) {
                System.out.println("票已售空...");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //由于线程可能会存在同时争夺资源的问题
            //所以会出现几个线程同时进入if语句判断,这可能会导致部分线程会出现和其他线程一样的判断结果
            //当线程进入休眠后,哪个线程先醒过来就会先进行抢票,就会出现超量卖票的情况
            System.out.println(Thread.currentThread().getName() + "窗口售出一张票" +
                    " 当前剩余 " + --tickNum + " 张票");
        }
    }
}