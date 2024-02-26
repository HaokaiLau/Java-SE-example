package edu.lhj.thread_.synchronized_;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 使用多线程模拟三个窗口同时售票(100张)
 */
public class SellTicket {
    public static void main(String[] args) {
//        //测试1 继承Thread类
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//        sellTicket01.start();//启动第一个线程
//        sellTicket02.start();//启动第二个线程
//        sellTicket03.start();//启动第三个线程

//        //测试2 实现Runnable接口
//        SellTicket02 sellTicket02 = new SellTicket02();
//        new Thread(sellTicket02).start();//启动第一个线程
//        new Thread(sellTicket02).start();//启动第二个线程
//        new Thread(sellTicket02).start();//启动第三个线程

        //测试3 实现Runnable接口,且使用线程同步方法
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//启动第一个线程
        new Thread(sellTicket03).start();//启动第二个线程
        new Thread(sellTicket03).start();//启动第三个线程
    }
}

//实现Runnable接口,使用synchronized实现线程同步
class SellTicket03 implements Runnable {
    //这里不用静态常量,原因是我们将来只需要创建一个该类的对象
    //把该类的对象放入不同的Thread对象中即可
    public int tickNum = 100;
    public boolean loop = true;

    /* 总结
    1.同步方法如果没有static修饰:默认锁对象为this
    2.同步方法如果有static修饰:默认锁对象为类名.class
    3.实现的落地步骤
    先分析需要上锁的代码
    选择同步代码块或同步方法(优先选择同步代码块)
    要求多个线程的对象为同一个(即保证多个线程争夺的是同一把锁)
     */

    //当某个对象使用synchronized修饰代表该对象任一时刻只能由一个线程访问
    //1.public synchronized void sell() { } 在声明方法时使用synchronized修饰,那么该方法是一个同步方法
    //2.synchronized (this) { },在声明代码块时用synchronized修饰,那么该代码块是一个同步代码块
    //3.在非静态方法中使用同步代码块,锁可以是this,也可以是其他对象(前提是n个线程用的同一对象中的其他对象)
    //4.在静态方法中使用同步代码块,锁为当前类本身,例如:
    public static void m3() {//静态方法
        synchronized (SellTicket03.class) {//锁为当前方法所在类的类本身

        }
    }
    public /*synchronized*/ void sell() {//同步方法,保证同一时间只能有一个线程来调用sell方法

        synchronized (this) {//同步代码块
            if (tickNum <= 0) {
                System.out.println("票已售空...");
                loop = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "窗口售出一张票" +
                    " 当前剩余 " + --tickNum + " 张票");
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
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