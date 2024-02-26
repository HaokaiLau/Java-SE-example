package edu.lhj.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{
    /* 理解:
    1.该类继承JFrame就相当于画框(框架)
    2.new一个继承了JPanel对象相当于添加了一块画板
    3.调用里面的paint方法就相当于用画笔作画
     */
    //定义一个面板
    private MyPanel panel = null;
    public static void main(String[] args) {//主方法
        new DrawCircle();//调用构造器
    }
    public DrawCircle() {//构造器
        //1.初始化面板
        panel = new MyPanel();
        //2.把面板加入到窗口(画框)里面去
        this.add(panel);
        //3.设置一下窗口(画框)的大小
        this.setSize(800,800);
        //4.设置一下窗口是否显示
        this.setVisible(true);//true表示可以显示
        //5.设置当点击窗口的X时候,程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//先定义一个面板 MyPanel,继承JPanel类,画图形就在面板上画
class MyPanel extends JPanel {

    /* 说明:
    1.MyPanel对象就是一个画板
    2.Graphics g 就是一支画笔
    3.Graphics提供了了很多绘图分方法
     */
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化
        //System.out.println("paint方法被调用");
        //g.drawOval(10,10,200,200);


        //（1）画直线 drawLine(int x1,int y1,int x2,int y2)；
        //g.drawLine(10,10,100,100);
        //（2）画矩形边框 drawRect(int x, int y, int width, int height)；
        //g.drawRect(10,10,100,100);
        //（3）画椭圆边框 drawOval(int x, int y, int width, int height)；
        //g.drawOval(10,10,200,100);
        //（4）填充矩形 fillRect(int x, int y, int width, int height)；
        //g.setColor(Color.red);
        //g.fillRect(10,10,100,100);
        //（5）填充椭圆 fillOval(int x, int y, int width, int height)；
        //g.fillOval(10,10,200,100);
        //（6）画图片 drawImage(Image img, int x, int y, ..)；
        //Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/3a199e25a4d3036e1c381817e9f2bbf.jpg"));
        //g.drawImage(image,0,0,700,699,this);
        //（7）画字符串 drawString(String str, int x, int y)//写字；
        //这里特别一点,这里的xy是字体框的左下角
        //g.drawString("LHJ",20,20);
        //（8）设置画笔的字体 setFont(Font font)；
        g.setFont(new Font("隶书", Font.BOLD,50));
        g.drawString("LHJ",100,100);
        //（9）设置画笔的颜色 setColor(Color c)。
        //g.setColor(Color.red);


    }
}