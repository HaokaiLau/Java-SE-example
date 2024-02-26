package edu.lhj.tankgame02;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 所有坦克的父类
 */
public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标
    private int direct = 0;//初始坦克的方向向上
    private int speed = 1;//初始坦克的速度为1

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //向四个方向移动的方法
    public void moveUp() {
        y -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
