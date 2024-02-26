package edu.lhj.tankgame05;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 红色坦克
 */
public class MyTank extends Tank {



    public MyTank(int x, int y) {
        super(x, y);
    }

    //射击子弹的方法(子弹也是坦克的一部分,所以最好封装在坦克类里)
    public void shot() {

        //限制存在子弹的上限
        if (bullets.size() == 5) {
            return;
        }

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
        //把bullet对象放入到bullets集合中
        bullets.add(bullet);
        //启动子弹的线程
        new Thread(bullet).start();
    }
}
