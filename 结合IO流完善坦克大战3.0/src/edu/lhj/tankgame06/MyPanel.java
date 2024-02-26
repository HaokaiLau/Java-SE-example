package edu.lhj.tankgame06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 坦克大战的绘图区域
 */
@SuppressWarnings({"all"})
//由于子弹移动需要不同的重绘MyPanel,所以使MyPanel实现Runnable接口,放在线程内循环重绘面板
public class MyPanel extends JPanel implements KeyListener, Runnable {

    //定义我的坦克
    MyTank myTank = null;
    //考虑到多线程的问题,所以把敌人的坦克放到Vector集合中
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int size = 3;//设置敌方坦克的数量
    Bullet bullet = null;//定义一个子弹对象
    Vector<Boom> booms = new Vector<>();//定义一个爆炸的集合,用于存放爆炸对象
    Vector<Node> nodes = new Vector<>();//定义一个Vector集合,用于读取退出游戏时候敌人坦克的信息
    int key;

    //定义三张爆炸的图片,用于显示爆炸的动画效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(int key) {//初始化对象的地方
        //当我们选择2时,判断记录文件是否存在,存在则正常执行,不存在则提示文件不存在,并且把key置成1
        File file = new File(Recorder.getRecordFile());
        if (file.exists()) {
            nodes = Recorder.readRecord();
        } else {
            System.out.println("上一局的记录文件不存在,已为你开启新游戏...");
            key = 1;
        }

        Recorder.setEnemyTanks(enemyTanks);
        myTank = new MyTank(400, 200);//初始化我们的坦克
        myTank.setSpeed(10);

        switch (key) {
            case 1:
                Recorder.setEnemyTankNum(0);
                //采用for循环循环创建敌方的坦克
                for (int i = 0; i < size; i++) {
                    //创建一个敌方的坦克
                    EnemyTank enemyTank = new EnemyTank((i + 1) * 100, 0);
                    //将enemyTanks设置给enemyTank对象,否则
                    //EnemyTank类没有接收到enemyTanks集合,无法处理坦克重叠问题
                    enemyTank.setEnemyTanks(enemyTanks);
                    //把该坦克的初始方向设置成向下
                    enemyTank.setDirect(2);
                    //enemyTank.setSpeed(3);
                    new Thread(enemyTank).start();//启动敌方坦克的线程
                    //为每一台敌方的坦克初始化一颗子弹
                    //Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                    //把子弹对象添加到Vector集合
                    //enemyTank.bullets.add(bullet);
                    //启动敌方子弹的线程
                    //new Thread(bullet).start();
                    //把该坦克加入到Vector集合
                    enemyTanks.add(enemyTank);
                }
                break;
            case 2:
                //采用for循环循环创建敌方的坦克
                for (int i = 0; i < nodes.size(); i++) {
                    //取出一个node
                    Node node = nodes.get(i);
                    //创建一个敌方的坦克
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                    //将enemyTanks设置给enemyTank对象,否则
                    //EnemyTank类没有接收到enemyTanks集合,无法处理坦克重叠问题
                    enemyTank.setEnemyTanks(enemyTanks);
                    //把该坦克的初始方向设置成向下
                    enemyTank.setDirect(node.getDirect());
                    //enemyTank.setSpeed(3);
                    new Thread(enemyTank).start();//启动敌方坦克的线程
                    //为每一台敌方的坦克初始化一颗子弹
                    //Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                    //把子弹对象添加到Vector集合
                    //enemyTank.bullets.add(bullet);
                    //启动敌方子弹的线程
                    //new Thread(bullet).start();
                    //把该坦克加入到Vector集合
                    enemyTanks.add(enemyTank);
                }
                break;
            default:
                System.out.println("您的输入有误...");
        }
        //初始化三张图片
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/boom1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/boom2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/boom3.png"));
    }

    //编写方法,显示我方击毁坦克的信息
    public void showInfo(Graphics g) {
        //画出玩家的总成绩
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);//设置字体
        g.setFont(font);
        g.drawString("您累计击毁坦克", 1020, 30);
        drawTank(1020, 60, g, 0, 0);//画一个敌方坦克
        g.setColor(Color.BLACK);//因为drawTank方法把画笔颜色改成了青色,所以这里需要重新设置一下
        g.drawString(Recorder.getEnemyTankNum() + "", 1080, 100);
    }

    @Override
    public void paint(Graphics g) {//真正把对象画出来的地方
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形,默认是黑色
        showInfo(g);
        if (myTank != null && myTank.isLive) {
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), 1);
        }

        //画出我们的坦克射出的子弹
        //当按下J的时候,就会创建一个bullet的对象
        //这边就会判断子弹对象是否存在,如果存在,就会把子弹画出来
//        if (myTank.bullet != null && bullet.isLive) {
//            g.fillOval(myTank.bullet.x, myTank.bullet.y, 3, 3);
//        }

        //遍历myTank.bullets集合,取出子弹进行绘制
        for (int i = 0; i < myTank.bullets.size(); i++) {
            Bullet bullet = myTank.bullets.get(i);
            bullet.speed = 10;
            if (bullet != null && bullet.isLive) {
                g.fillOval(bullet.x, bullet.y, 3, 3);
            } else {
                myTank.bullets.remove(bullet);
            }
        }

        //遍历Vector集合,循环绘制敌方坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {//判断坦克是否存活,存活的才画出来
                //遍历敌方坦克的Vector集合,取出EnemyTank对象
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //遍历敌方坦克子弹的Vector集合,取出子弹对象
                for (int j = 0; j < enemyTank.bullets.size(); j++) {
                    Bullet bullet = enemyTank.bullets.get(j);
                    if (bullet.isLive) {
                        bullet.speed = 5;
                        //绘制子弹
                        g.fillOval(bullet.x, bullet.y, 3, 3);
                    } else {
                        //isLive为false,就从Vector对象中移除该子弹对象
                        enemyTank.bullets.remove(bullet);
                    }
                }
            }
        }

        //休眠10ms
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //画出爆炸的图片
        for (int i = 0; i < booms.size(); i++) {
            Boom boom = booms.get(i);
            if (boom.isLive) {
                if (boom.life > 6) {
                    g.drawImage(image1, boom.x, boom.y, 60, 60, this);
                } else if (boom.life > 3) {
                    g.drawImage(image2, boom.x, boom.y, 60, 60, this);
                } else {
                    g.drawImage(image3, boom.x, boom.y, 60, 60, this);
                }
            }
            boom.lifeDown();
            if (!boom.isLive) {
                booms.remove(boom);
            }
        }
    }

    //编写方法画出坦克

    /**
     * @param x      坦克左上角的x坐标
     * @param y      坦克左上角的y坐标
     * @param g      画笔
     * @param direct 坦克方向(上下左右)
     * @param type   坦克类型
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

    //从双方的bullets集合中取出子弹对双方坦克进行击中判定
    public void isHit() {
        //击中敌方坦克的判定
        for (int i = 0; i < myTank.bullets.size(); i++) {
            Bullet bullet = myTank.bullets.get(i);
            if (bullet != null && bullet.isLive) {
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(myTank.bullet, enemyTank);
                }
            }
        }
        //击中我方坦克的判定
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.bullets.size(); j++) {
                Bullet bullet = enemyTank.bullets.get(j);
                hitTank(enemyTank.bullet, myTank);
            }
        }
    }

    //子弹击中坦克销毁坦克和子弹的方法
    public void hitTank(Bullet bullet, Tank tank) {
        //根据坦克的方向进行击中判定
        switch (tank.getDirect()) {
            case 0://坦克向上
            case 2://坦克向下
                //子弹出现在坦克的xy坐标内就表示子弹击中了坦克
                if (bullet.x > tank.getX() && bullet.x < tank.getX() + 40
                        && bullet.y > tank.getY() && bullet.y < tank.getY() + 60) {
                    bullet.isLive = false;
                    tank.isLive = false;
                    enemyTanks.remove(tank);//把死掉的坦克移出集合
                    //判断该坦克是否是敌方的类型,是,击毁坦克数+1
                    if (tank instanceof EnemyTank) {
                        Recorder.destroyEnemyTankNum();
                    }
                    //坦克被击中,创建一个爆炸对象,把爆炸对象放入到booms集合中
                    Boom boom = new Boom(tank.getX(), tank.getY());
                    booms.add(boom);
                    break;
                }
            case 1://坦克向右
            case 3://坦克向左
                //子弹出现在坦克的xy坐标内就表示子弹击中了坦克
                if (bullet.x > tank.getX() && bullet.x < tank.getX() + 60
                        && bullet.y > tank.getY() && bullet.y < tank.getY() + 60) {
                    bullet.isLive = false;
                    tank.isLive = false;
                    enemyTanks.remove(tank);//把死掉的坦克移出集合
                    //判断该坦克是否是敌方的类型,是,击毁坦克数+1
                    if (tank instanceof EnemyTank) {
                        Recorder.destroyEnemyTankNum();
                    }
                    //坦克被击中,创建一个爆炸对象,把爆炸对象放入到booms集合中
                    Boom boom = new Boom(tank.getX(), tank.getY());
                    booms.add(boom);
                    break;
                }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理按下WDSA的事件
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (myTank.getDirect() != 0) {
                myTank.setDirect(0);
            }
            myTank.moveUp();

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (myTank.getDirect() != 1) {
                myTank.setDirect(1);
            }
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (myTank.getDirect() != 2) {
                myTank.setDirect(2);
            }
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (myTank.getDirect() != 3) {
                myTank.setDirect(3);
            }
            myTank.moveLeft();
        }

        //如果用户按下J,就发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //我方坦克发射的子弹销毁后,才能发射新的子弹(一次只能发射一颗)
//            if (myTank.bullet == null || !myTank.bullet.isLive) {
//                myTank.shot();
//            }
            myTank.shot();
        }
//        //重绘面板
//        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//因为面板要一直重绘,所以我们把面板也做成一个线程
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //因为我们要一直判断我方的子弹是否击中敌人的坦克,所以我们也把这个判断放在run中
                isHit();
                this.repaint();
            }
        }
    }
}
