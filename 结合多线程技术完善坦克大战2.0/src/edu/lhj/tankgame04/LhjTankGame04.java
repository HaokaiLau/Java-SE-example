package edu.lhj.tankgame04;

import javax.swing.*;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class LhjTankGame04 extends JFrame {
    private MyPanel panel = null;//定义一个面板

    public static void main(String[] args) {
        LhjTankGame04 lhjTankGame01 = new LhjTankGame04();
    }

    public LhjTankGame04() {
        panel = new MyPanel();//初始化面板
        Thread thread = new Thread(panel);
        thread.start();//启动面板的线程
        this.add(panel);//把面板加入到窗口中
        this.setSize(1017,790);//设置窗口的大小
        this.addKeyListener(panel);//使窗口能够监听面板中发生的事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击x关闭程序
        this.setVisible(true);//设置画板可见
    }
}
