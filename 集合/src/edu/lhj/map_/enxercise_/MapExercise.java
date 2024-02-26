package edu.lhj.map_.enxercise_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        Employee tim = new Employee("Tim", 1001, 18000);
        Employee nice = new Employee("Nice", 1002, 20000);
        Employee jackal = new Employee("Jackal", 1003, 23000);
        map.put(tim.getId(), tim);
        map.put(nice.getId(), nice);
        map.put(jackal.getId(), jackal);

        Set entrySet = map.entrySet();
        //1.使用增强for遍历,并且输出工资大于18000的员工
        System.out.println("=====使用增强for遍历出工资大于18000的员工=====");
        for (Object obj01 : entrySet) {
            Map.Entry entry = (Map.Entry) obj01;
            Employee employee = (Employee) entry.getValue();
            if (employee.getSal() > 18000) {
                System.out.println(employee);
            }
        }

        //2.使用迭代器遍历,并且输出工资大于18000的员工
        System.out.println("=====使用迭代器遍历出工资大于18000的员工=====");
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =  (Map.Entry)iterator.next();
            Employee employee = (Employee) entry.getValue();
            if (employee.getSal() > 18000) {
                System.out.println(employee);
            }
        }
    }
}

class Employee {
    private String name;
    private int id;
    private double sal;

    public Employee(String name, int id, double sal) {
        this.name = name;
        this.id = id;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sal=" + sal +
                '}';
    }
}