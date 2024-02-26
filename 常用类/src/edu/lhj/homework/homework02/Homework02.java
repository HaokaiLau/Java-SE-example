package edu.lhj.homework.homework02;

public class Homework02 {
    public static void main(String[] args) {
        User user = new User("lhj", "123456", "773849533@qq.com");
        try {
            user.userRegister(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("注册成功！！");
        System.out.println(user);

    }
}
