package edu.lhj.interface_;

public class InterfacePolyPass {
    public static void main(String[] args) {
        //接口的多态传递现象
        IG ig = new H();
        IF if_ = new H();
    }
}
interface IF{}
interface IG extends IF{}
class H implements IG{
}
