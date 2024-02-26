package edu.lhj.event_;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class BallMove extends JFrame {
    public MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }
    public BallMove() {
        mp = new MyPanel();//初始化面板
        this.add(mp);
        this.setSize(400,300);
        //使窗口JFrame对象可以监听键盘事件,即可以监听到面板中发生的键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

//KeyListener 是一个键盘监听器
class MyPanel extends JPanel implements KeyListener {
    //为了使小球可以移动,我们把他的坐标设置成变量
    int x = 10;
    int y = 10;//x和y对应小球左上角的坐标
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    //有字符输出时,该方法会被触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当键盘某个键按下时,该方法会触发
    @Override
    public void keyPressed(KeyEvent e) {
        //在Java中,会给键盘中每一个键分配了一个KeyCode
        //System.out.println((char) e.getKeyCode() + "被按下");
        if (e.getKeyCode() == KeyEvent.VK_W) {
            y--;
        }else if (e.getKeyCode() == KeyEvent.VK_S) {
            y++;
        }else if (e.getKeyCode() == KeyEvent.VK_A) {
            x--;
        }else if (e.getKeyCode() == KeyEvent.VK_D) {
            x++;
        }
        //让面板重绘
        this.repaint();
    }

    //当键盘某个键松开时,该方法会触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}