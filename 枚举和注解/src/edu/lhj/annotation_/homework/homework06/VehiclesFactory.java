package edu.lhj.annotation_.homework.homework06;

//3.编写一个交通工具工厂类VehiclesFactory,要求分别用两个方法分别获取Horse对象或者Boat对象
public class VehiclesFactory {
    //因为马是一直跟着唐僧的,都是同一匹马,而船是别人的,每过一条河就用一条新船
    //为了避免一直新建马对象造成浪费,所以直接定义一个常量马
    //同时为了防止用构造器新建马对象,把构造器私有化
    private static Horse horse = new Horse();

    private VehiclesFactory() {}

    public static Horse getHorse() {
        return horse;
    }
    public static Boat getBoat() {
        return new Boat();
    }
    public static Airplane getAirplane() {
        return new Airplane();
    }
}
