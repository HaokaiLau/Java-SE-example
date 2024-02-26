package edu.lhj.collection_.exercise_;

import java.util.LinkedHashSet;
import java.util.Objects;
@SuppressWarnings({"all"})
public class LinkedHashSetExercise01 {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("奥迪", 30));
        linkedHashSet.add(new Car("奥迪", 36));
        linkedHashSet.add(new Car("保时捷", 300));
        linkedHashSet.add(new Car("奔驰", 100));
        linkedHashSet.add(new Car("本田", 22));
        linkedHashSet.add(new Car("丰田", 26));
        linkedHashSet.add(new Car("奥迪", 36));

        for (Object o : linkedHashSet) {
            System.out.println(o);
        }

    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}