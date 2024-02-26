package edu.lhj.thread_.homework;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        Thread threadA = new Thread(a);
        Thread threadB = new Thread(b);
        threadA.start();//启动A线程
        threadB.start();//启动B线程
    }
}

class A implements Runnable {

    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((int)(Math.random() * 100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A线程已退出...");
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

//采用通知的方式控制A线程退出
class B implements Runnable {

    private Scanner scanner = new Scanner(System.in);
    private A a;

    //使用构造获取A对象,方便后面用来调用setLoop方法
    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入你的指令(Q表示退出):");
            char key = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
            if (key == 'Q') {
                //采用通知的方式
                //调用a对象的setLoop方法,把loop设置成false,从而使A线程退出
                a.setLoop(false);
                System.out.println("B线程已退出...");
                break;
            }
        }
    }
}
