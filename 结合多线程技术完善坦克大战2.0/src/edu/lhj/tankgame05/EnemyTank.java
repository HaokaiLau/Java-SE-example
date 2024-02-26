package edu.lhj.tankgame05;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class EnemyTank extends Tank implements Runnable{

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void shot() {

        //限制每辆敌方坦克存在的子弹数量
        //通过判断bullets.size()的大小来判断当前每辆坦克有多少颗子弹在场上
        if (isLive && bullets.size() < 1) {

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

    @Override
    public void run() {
        while (true) {

            shot();

            //根据坦克的方向随机移动
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                       moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //然后随机的改变坦克的方向 Math.random() * 4
            setDirect((int) (Math.random() * 4));

            if (!isLive) {
                break;
            }
        }
    }
}
