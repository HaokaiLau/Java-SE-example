package edu.lhj.annotation_.homework.homework06;

//4.编写Person类,具有属性name和vehicles,并且用构造器对其赋值
public class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }


    public void passRiver() {
        //1.为了避免传进去的参数被浪费,所以最好是添加一个判断
        //如果传进去的vehicles属性不为空,则跳出该方法不再获取新的Boat对象
        //如果传进去的vehicles属性为空,则获取一个新的Boat对象
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    public void common() {
        //1.为了避免传进去的参数被浪费,所以最好是添加一个判断
        //如果传进去的vehicles属性不为空,则跳出该方法不再获取新的Horse对象
        //如果传进去的vehicles属性为空,则获取一个新的Horse对象
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }

    public void passFire() {
        if (!((vehicles instanceof Horse) && (vehicles instanceof Boat))) {
            vehicles = VehiclesFactory.getAirplane();
        }
        vehicles.work();
    }
}
