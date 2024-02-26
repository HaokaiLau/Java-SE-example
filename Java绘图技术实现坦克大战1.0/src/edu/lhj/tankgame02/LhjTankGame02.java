package edu.lhj.tankgame02;

import javax.swing.*;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class LhjTankGame02 extends JFrame {
    private MyPanel panel = null;//定义一个面板

    public static void main(String[] args) {
        LhjTankGame02 lhjTankGame01 = new LhjTankGame02();
    }

    public LhjTankGame02() {
        panel = new MyPanel();//初始化面板
        this.add(panel);//把面板加入到窗口中
        this.setSize(1000,750);//设置窗口的大小
        this.addKeyListener(panel);//使窗口能够监听面板中发生的事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击x关闭程序
        this.setVisible(true);//设置画板可见
    }
}
