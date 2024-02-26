package edu.lhj.tankgame04;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 红色坦克
 */
public class MyTank extends Tank {

    //定义一个子弹对象
    public Bullet bullet = null;

    public MyTank(int x, int y) {
        super(x, y);
    }

    //射击子弹的方法(子弹也是坦克的一部分,所以最好封装在坦克类里)
    public void shot() {
        switch (getDirect()) {//根据坦克的方向来获取子弹发射点的xy坐标
            case 0:
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1:
                bullet = new Bullet(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                bullet = new Bullet(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                bullet = new Bullet(getX(), getY() + 20, 3);
                break;
        }
        //启动子弹的线程
        new Thread(bullet).start();
    }
}
