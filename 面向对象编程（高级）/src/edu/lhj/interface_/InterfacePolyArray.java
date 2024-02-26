package edu.lhj.interface_;

public class InterfacePolyArray {
    public static void main(String[] args) {
        //接口类型的多态数组
        //当类实现了接口时,该类的实例化对象可以放入接口类的多态数组中
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone_();
        usbs[1] = new Camera_();
        /*
        遍历usbs数组,调用接口类中的方法,如果
        是Phone_类的话,还要调用Phone_中特有的call方法
         */
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();
            if (usbs[i] instanceof Phone_) {
                ((Phone_) usbs[i]).call();
            }
        }
    }
}
interface Usb{
    void work();
}
class Phone_ implements Usb{
    public void call() {
        System.out.println("手机可以打电话...");
    }

    @Override
    public void work() {
        System.out.println("手机已接入...");
    }
}
class Camera_ implements Usb{

    @Override
    public void work() {
        System.out.println("相机已接入... ");
    }
}