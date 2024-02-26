package edu.lhj.thread_.synchronized_;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class DeadLock_ {
    public static void main(String[] args) {
        DeadLockDemo A = new DeadLockDemo(true);
        DeadLockDemo B = new DeadLockDemo(false);
        Thread threadA = new Thread(A);
        threadA.setName("A线程");
        Thread threadB = new Thread(B);
        threadB.setName("B线程");
        threadA.start();//启动A线程
        threadB.start();//启动B线程
    }
}

class DeadLockDemo implements Runnable {

    public static Object o1 = new Object();//保证多线程共享同一个对象,这里使用static
    public static Object o2 = new Object();
    public boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag == true) {//当判断为ture时,A线程先得到了锁o1,然后再尝试获得锁o2
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + " 进入1");
                //当输出完语句后,A线程进入阻塞状态并且尝试获得锁o2
                synchronized (o2) {//由于此时o2被B线程持有
                    System.out.println(Thread.currentThread().getName() + " 进入2");
                }
            }
        } else {//当判断为false时,B线程先得到了锁o2,然后再尝试获得锁o1
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入3");
                //当输出完语句后,B线程进入阻塞状态并且尝试获得锁o1
                synchronized (o1) {//o1被A线程持有
                    System.out.println(Thread.currentThread().getName() + " 进入4");
                }
            }
        }//两个线程都无法获得彼此的锁,所以一直都处于阻塞状态,这就叫做线程的死锁
        /* 细节
            因为只有当线程执行完 同步方法/同步代码块 中的所有内容后才会释放锁
            这里线程A和线程B都没有执行完代码块,所以都没有释放锁
            导致两个线程接下来无法获得彼此的锁
            所以这里才会导致死锁现象
         */
    }
}
