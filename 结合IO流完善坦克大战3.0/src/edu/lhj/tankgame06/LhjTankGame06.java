package edu.lhj.tankgame06;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class LhjTankGame06 extends JFrame {
    private MyPanel panel = null;//定义一个面板
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LhjTankGame06 lhjTankGame01 = new LhjTankGame06();
    }

    public LhjTankGame06() {

        System.out.print("请输入你的选择(1.新游戏/2.继续上一局):");
        int key = scanner.nextInt();

        panel = new MyPanel(key);//初始化面板
        Thread thread = new Thread(panel);
        thread.start();//启动面板的线程
        this.add(panel);//把面板加入到窗口中
        this.setSize(1300,790);//设置窗口的大小
        this.addKeyListener(panel);//使窗口能够监听面板中发生的事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击x关闭程序
        this.setVisible(true);//设置画板可见

        //添加响应点击关闭窗口的相关方法
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.saveRecord();//存盘退出的方法
                System.exit(0);
            }
        });
    }
}
