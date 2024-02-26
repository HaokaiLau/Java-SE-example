package edu.lhj.tankgame05;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 子弹类
 */
public class Bullet implements Runnable {
    public int x;//子弹的x坐标
    public int y;//子弹的y坐标
    public int direct = 0;//子弹的方向,默认向上
    public int speed = 1;//子弹的速度,默认为1
    public boolean isLive = true;//子弹的存活状态,默认存活

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            //测试子弹是否在移动
            System.out.println("x=" + x + " y=" + y);

            //当子弹触碰到面板的边界 子弹isLive为false时,退出子弹线程
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                isLive = false;
                System.out.println("子弹线程退出");
                break;
            }
        }
    }
}
