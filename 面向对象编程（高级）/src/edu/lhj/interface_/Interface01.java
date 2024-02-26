package edu.lhj.interface_;

public class Interface01 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Phone phone = new Phone();
        computer.work(phone);
        Camera camera = new Camera();
        computer.work(camera);


    }
}
