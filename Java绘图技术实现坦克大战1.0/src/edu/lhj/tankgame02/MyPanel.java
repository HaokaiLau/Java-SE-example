package edu.lhj.tankgame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    MyTank myTank = null;
    //考虑到多线程的问题,所以把敌人的坦克放到Vector集合中
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int size = 3;//设置敌方坦克的数量

    public MyPanel() {
        myTank = new MyTank(200,200);//初始化我们的坦克
        myTank.setSpeed(10);

        //采用for循环循环创建敌方的坦克
        for (int i = 0; i < size; i++) {
            //创建一个敌方的坦克
            EnemyTank enemyTank = new EnemyTank((i + 1) * 100, 0);
            //把该坦克的初始方向设置成向下
            enemyTank.setDirect(2);
            //把该坦克加入到Vector集合
            enemyTanks.add(enemyTank);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形,默认是黑色
        drawTank(myTank.getX(), myTank.getY(),g, myTank.getDirect(),1);
        //遍历Vector集合,循环绘制敌方坦克
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(), enemyTank.getY(),g, enemyTank.getDirect(),0);
        }

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
    //绘制坦克的一个封装方法
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型的坦克分配不同的颜色
        switch (type) {
            case 0://敌人的坦克
                g.setColor(Color.yellow);
                break;
            case 1://我们的坦克
                g.setColor(Color.red);
                break;
        }

        //根据坦克的方向来绘制坦克
        //direct表示方向 (0:上 1:右 2:下 3:左)
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边履带
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边履带
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克车身
                g.fillOval(x + 10, y + 20, 20, 20);//画出炮台
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边边履带
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边边履带
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克车身
                g.fillOval(x + 20, y + 10, 20, 20);//画出炮台
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边履带
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边履带
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克车身
                g.fillOval(x + 10, y + 20, 20, 20);//画出炮台
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边边履带
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边边履带
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克车身
                g.fillOval(x + 20, y + 10, 20, 20);//画出炮台
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理按下WDSA的事件
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirect(0);
            myTank.moveUp();
        }else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirect(1);
            myTank.moveRight();
        }else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirect(2);
            myTank.moveDown();
        }else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirect(3);
            myTank.moveLeft();
        }
        //重绘面板
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
