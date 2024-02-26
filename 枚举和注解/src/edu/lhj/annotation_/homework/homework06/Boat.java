package edu.lhj.annotation_.homework.homework06;

//2.编写Horse类和Boat类,并且实现Vehicles接口
public class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("在渡河时用船作为交通工具...");
    }
}
