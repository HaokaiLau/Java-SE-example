package edu.lhj.interface_;

public class InterfaceDetail02 {
    public static void main(String[] args) {
        //证明接口中所有的属性都是public static final修饰的
        System.out.println(IB.a);//能通过类名.属性名的方式直接调用,证明用的是static修饰
        //IB.a = 10;无法修改IB.a的值,证明用的是final修饰
    }
}

//1.一个类只能继承一个父类,而一个类可以实现多个接口,接口与接口之间用逗号分隔
//2.接口中所有的属性都是final的,并且都是public static final 修饰符修饰的
//3.接口无法继承其他类,但是可以继承接口,同时可以继承多个接口
//3.接口前的修饰符只能是public和默认,这点和类是一样的
interface IB {
    int a = 1;//实际上为 public static final int a = 1;
    public static final int b = 2;
    void hi();
}
interface IC {
    void say();
}
interface ID extends IB,IC{

}

class Pig implements IB,IC {

    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}