package edu.lhj.interface_;

//Camera类 实现 Usb01接口
//即 Camera类 需要实现 Usb01接口 声明的方法
public class Camera implements UsbInterface {
    //把接口的方法实现
    @Override
    public void start() {
        System.out.println("相机开始工作...");
    }

    @Override
    public void stop() {
        System.out.println("相机停止工作...");
    }
}
