package edu.lhj.thread_.homework;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        Card card = new Card();//新建一个对象
        Thread threadA = new Thread(card);//把同一个对象放入两个不同的线程,表示两个用户
        threadA.setName("A用户");
        Thread threadB = new Thread(card);
        threadB.setName("B用户");
        threadA.start();
        threadB.start();
    }
}

class Card implements Runnable {

    private double balance = 10000;

    @Override
    public void run() {
        while (true) {//注意!!!要把synchronized放在while循环里才能重复获取锁和释放锁的动作
            //while循环在同步代码块内会导致一个线程进入同步代码块时会执行完整个循环才会释放锁
            //导致另一个线程到最后才能进入同步代码块内
            //即同步代码块内应避免使用死循环!!!
            //总结:出现超额的现象应检查死循环和同步代码块的位置,死循环应该放在同步代码块外面,
            //因为线程只有在执行完同步代码块中的内容才会释放锁

            //解读
            //1. 这里使用 synchronized 实现了线程同步
            //2. 当多个线程执行到这里时，就会去争夺 this对象锁
            //3. 哪个线程争夺到(获取)this对象锁，就执行 synchronized 代码块, 执行完后，会释放this对象锁
            //4. 争夺不到this对象锁，就blocked ，准备继续争夺
            //5. this对象锁是非公平锁.
            synchronized (this) {//使用同步代码块,保证不会出现超额取款
                //this表示当前类new的对象作为该同步代码块的锁
                if (balance <= 0) {
                    System.out.println("余额不足,取款失败...");
                    break;
                }
                balance -= 100;
                System.out.println(Thread.currentThread().getName() +
                        " 从卡中取出100元,当前余额为:" + balance);
            }
            try {
                Thread.sleep(50);//sleep操作不会使当前线程释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
