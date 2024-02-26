package edu.lhj.generic.exercise;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class GenericExercise02 {
    public static void main(String[] args) {
        Employee tim = new Employee("Tim", 5000, new MayDate(2004, 1, 1));
        Employee jackal = new Employee("Jackal", 6000, new MayDate(2000, 2, 2));
        Employee nice = new Employee("Tim", 7000, new MayDate(2003, 3, 3));
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(tim);
        employees.add(jackal);
        employees.add(nice);
        System.out.println("employees=" + employees);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //由于定义的泛型类型的子类型也能传入,所以先进行类型的判断,确保传入的不可以是子类的类型
                if (!((o1 instanceof Employee) && (o2 instanceof Employee))) {
                    return 0;
                }
                //比较名字,如果名字不相同,就进行比较然后返回一个值
                int nameCompare = o1.getName().compareTo(o2.getName());
                if (nameCompare != 0) {
                    return nameCompare;
                }

                //下面是对birthday的比较,因此最好把这个比较封装到MyDate中去
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        System.out.println("employees=" + employees);
    }
}

class Employee {
    private String name;
    private double sal;
    private MayDate birthday;

    public Employee(String name, double sal, MayDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MayDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MayDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return  '\n' + "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MayDate implements Comparable<MayDate>{
    private int year;
    private int month;
    private int day;

    public MayDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MayDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
    @Override
    public int compareTo(MayDate o) {
        //比较年,如果不是同年,就进行比较然后返回一个值
        int yearCompare = year - o.getYear();
        if (yearCompare != 0) {
            return yearCompare;
        }
        //比较月,如果不是同月,就进行比较然后返回一个值
        int monthCompare = month - o.getMonth();
        if (monthCompare != 0) {
            return monthCompare;
        }
        //比较日,如果不是同日,就进行比较然后返回一个值
        int dayCompare = day - o.getDay();
        return dayCompare;
    }
}
