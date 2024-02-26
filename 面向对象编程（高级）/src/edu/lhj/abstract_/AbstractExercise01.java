package edu.lhj.abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        CommonEmployee tim = new CommonEmployee("Tim", "101", 4000);
        tim.work();
        System.out.println("========================================================");
        Manager howie = new Manager("Howie", "102", 5000, 1000);
        howie.work();
    }
}

abstract class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void work();
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("普通员工 " + getName() +
                "\n工号 " + getId() + "\n薪资 " + getSalary() + "\n工作中...");
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理 " + getName() +
                "\n工号 " + getId() + "\n薪资 " + getSalary() +
                "\n工作中..." + "\n奖金 " + bonus);
    }
}