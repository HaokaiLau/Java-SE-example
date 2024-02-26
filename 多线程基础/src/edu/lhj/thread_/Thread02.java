package edu.lhj.thread_;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start();//因为Runnable接口中没有start方法,所以无法调用start方法
        //创建了Thread对象,把Dog对象(实现了Runnable接口)放入了Thread
        Thread thread = new Thread(dog);
        //通过Thread对象来调用start方法
        thread.start();
        //我们把这种创建线程的模式称为代理模式
    }
}

class Dog implements Runnable {//通过实现Runnable的方式来新建线程
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("小狗汪汪叫" + ++count + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;//当该线程执行10次后就退出
            }
        }
    }
}