package edu.lhj.string_;

public class StringExercise05 {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "lhj";
        Person person1 = new Person();
        person1.name = "lhj";
        System.out.println(person.name.equals(person1.name));//true 字符串相同
        System.out.println(person.name == person1.name);//true 两个对象的name指向的地址相同
        System.out.println(person.name == "lhj");//true
        System.out.println(person1.name == "lhj");//true

        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2);//false s1和s2在堆中是两个不同的对象
    }
}

class Person {
    public String name;
}
