package edu.lhj.tankgame06;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Boom {
    public int x,y;//爆炸的xy坐标
    public int life = 9;//爆炸的生命周期,这里是为了使爆炸效果更丝滑
    public boolean isLive = true;//爆炸是否还存在

    public Boom(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown() {//使爆炸的生命周期减少,表现出不同的爆炸效果,使图片形成动画
        if (life > 0) {
            life--;
        }else {
            isLive = false;
        }
    }
}
