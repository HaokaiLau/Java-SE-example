package edu.lhj.innerclass_;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        //把匿名内部类作为对象类型(编译类型是对象类型)的形参传进了alarmClock方法中
        //bell = new Bell() {
        //            @Override
        //            public void ring() {
        //                System.out.println("懒猪起床了");
        //            }
        //        }
        //由于该形参的运行类型是匿名内部类的类型,所以根据动态绑定机制会调用匿名内部类中同名的方法
        //该匿名内部类的实质是 匿名内部类 extends CellPhone implements Bell
        //所以需要实现接口中所有的抽象方法
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}

interface Bell {
    void ring();
}
class CellPhone {
    public void alarmClock(Bell bell) {
        bell.ring();
        System.out.println(bell.getClass());
    }
}
