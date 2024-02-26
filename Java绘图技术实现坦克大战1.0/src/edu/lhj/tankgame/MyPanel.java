package edu.lhj.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel {
    //定义我的坦克
    RedTank redTank = null;

    public MyPanel() {
        redTank = new RedTank(100,100);//初始化红色坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形,默认是黑色
        drawTank(redTank.getX(),redTank.getY(),g,0,0);
    }

    //编写方法画出坦克

    /**
     *
     * @param x 坦克左上角的x坐标
     * @param y 坦克左上角的y坐标
     * @param g 画笔
     * @param direct 坦克方向(上下左右)
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型的坦克分配不同的颜色
        switch (type) {
            case 0://我们的坦克
                g.setColor(Color.red);
                break;
            case 1://敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克的方向来绘制坦克
        switch (direct) {
            case 0://表示向上
                //左侧履带
                g.fill3DRect(x,y,10,60,false);
                //右侧履带
                g.fill3DRect(x + 30,y,10,60,false);
                //车身
                g.fill3DRect(x + 10,y + 10,
                        20,40,false);
                //炮台
                g.fillOval(x + 10,y + 20,
                        20,20);
                //炮管
                g.drawLine(x + 20,y + 30,
                        x + 20,y);
                break;
            default:
                System.out.println("暂时没有处理");
                break;
        }
    }
}
