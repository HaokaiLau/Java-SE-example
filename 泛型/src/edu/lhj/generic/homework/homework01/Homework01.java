package edu.lhj.generic.homework.homework01;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Homework01 {
    public static void main(String[] args) {

    }
    @Test
    public void test01() {
        //这里给 T 定义的类型是User
        DAO<User> userDAO = new DAO<User>();
        userDAO.save("001", new User(1,10,"Tim"));
        userDAO.save("002", new User(2,20,"Jackal"));
        userDAO.save("003", new User(3,30,"Nice"));

        List<User> list = userDAO.list();
        System.out.println(list);

        userDAO.update("003",new User(3,50,"Howie"));

        list = userDAO.list();//重置
        System.out.println(list);

        System.out.println(userDAO.get("003"));
    }
}
