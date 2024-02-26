package edu.lhj.interface_;

public interface UsbInterface {
    //规定接口的相关方法
    public abstract void start();
    //在接口类中,抽象方法可以不用abstract关键字修饰
    public void stop();
}
