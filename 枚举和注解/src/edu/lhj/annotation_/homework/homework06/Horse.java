package edu.lhj.annotation_.homework.homework06;

//2.编写Horse类和Boat类,并且实现Vehicles接口
public class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("一般情况下使用马作为交通工具...");
    }
}
