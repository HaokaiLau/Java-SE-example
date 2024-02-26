package edu.lhj.tankgame06;

import java.util.Vector;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class EnemyTank extends Tank implements Runnable {

    Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //判断当前的这个敌人坦克是否和集合内的其他坦克发生碰撞
    public boolean isTouch() {
        //判断当前敌人坦克的方向
        switch (this.getDirect()) {

            case 0://上
                //让当前坦克和集合中除自己外的其他坦克进行比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从集合中取出一个坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人的坦克方向是上或者下
                        //那么xy的范围应该是 x [enemyTank.getX(), enemyTank.getX() + 40]
                        //                y [enemyTank.getY(), enemyTank.getY() + 60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //判断取出的这个坦克的左上角是否在其他敌人坦克范围内
                            //左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //判断取出的这个坦克的右上角是否在其他敌人坦克范围内
                            //右上角坐标[this.getX() + 40,this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人的坦克方向是左或者右
                        //那么xy的范围应该是 x [enemyTank.getX(), enemyTank.getX() + 60]
                        //                y [enemyTank.getY(), enemyTank.getY() + 40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //判断取出的这个坦克的左上角是否在其他敌人坦克范围内
                            //左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //判断取出的这个坦克的右上角是否在其他敌人坦克范围内
                            //右上角坐标[this.getX() + 40,this.getY()]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }

            case 1://右
                //让当前坦克和集合中除自己外的其他坦克进行比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从集合中取出一个坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人的坦克方向是上或者下
                        //那么xy的范围应该是 x [enemyTank.getX(), enemyTank.getX() + 40]
                        //                y [enemyTank.getY(), enemyTank.getY() + 60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //判断取出的这个坦克的右上角是否在其他敌人坦克范围内
                            //右上角坐标[this.getX() + 60,this.getY()]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //判断取出的这个坦克的右下角是否在其他敌人坦克范围内
                            //右下角坐标[this.getX() + 60,this.getY() + 40]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人的坦克方向是左或者右
                        //那么xy的范围应该是 x [enemyTank.getX(), enemyTank.getX() + 60]
                        //                y [enemyTank.getY(), enemyTank.getY() + 40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //判断取出的这个坦克的右上角是否在其他敌人坦克范围内
                            //右上角坐标[this.getX() + 60,this.getY()]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //判断取出的这个坦克的右下角是否在其他敌人坦克范围内
                            //右下角坐标[this.getX() + 60,this.getY() + 40]
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }

            case 2://下
                //让当前坦克和集合中除自己外的其他坦克进行比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从集合中取出一个坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人的坦克方向是上或者下
                        //那么xy的范围应该是 x [enemyTank.getX(), enemyTank.getX() + 40]
                        //                y [enemyTank.getY(), enemyTank.getY() + 60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //判断取出的这个坦克的左下角是否在其他敌人坦克范围内
                            //左下角坐标[this.getX(),this.getY() + 60]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //判断取出的这个坦克的右上角是否在其他敌人坦克范围内
                            //右下角坐标[this.getX() + 40,this.getY() + 60]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人的坦克方向是左或者右
                        //那么xy的范围应该是 x [enemyTank.getX(), enemyTank.getX() + 60]
                        //                y [enemyTank.getY(), enemyTank.getY() + 40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //判断取出的这个坦克的左下角是否在其他敌人坦克范围内
                            //左下角坐标[this.getX(),this.getY() + 60]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //判断取出的这个坦克的右下角是否在其他敌人坦克范围内
                            //右下角坐标[this.getX() + 40,this.getY() + 60]
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }

            case 3://左
                //让当前坦克和集合中除自己外的其他坦克进行比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从集合中取出一个坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //如果敌人的坦克方向是上或者下
                        //那么xy的范围应该是 x [enemyTank.getX(), enemyTank.getX() + 40]
                        //                y [enemyTank.getY(), enemyTank.getY() + 60]
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //判断取出的这个坦克的左上角是否在其他敌人坦克范围内
                            //左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60) {
                                return true;
                            }
                            //判断取出的这个坦克的左下角是否在其他敌人坦克范围内
                            //左下角坐标[this.getX(),this.getY() + 40]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60) {
                                return true;
                            }
                        }
                        //如果敌人的坦克方向是左或者右
                        //那么xy的范围应该是 x [enemyTank.getX(), enemyTank.getX() + 60]
                        //                y [enemyTank.getY(), enemyTank.getY() + 40]
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //判断取出的这个坦克的左上角是否在其他敌人坦克范围内
                            //左上角坐标[this.getX(),this.getY()]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40) {
                                return true;
                            }
                            //判断取出的这个坦克的左下角是否在其他敌人坦克范围内
                            //左下角坐标[this.getX(),this.getY() + 40]
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40) {
                                return true;
                            }
                        }
                    }
                }

        }
        return false;
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
                    for (int i = 0; i < 50; i++) {
                        if (!isTouch()) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 50; i++) {
                        if (!isTouch()) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 50; i++) {
                        if (!isTouch()) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 50; i++) {
                        if (!isTouch()) {
                            moveLeft();
                        }
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
