package edu.lhj.exception_;

import java.util.Scanner;

public class CustomException01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = 0;
        Person person = new Person();
        System.out.print("请输入年龄:");
        age = scanner.nextInt();
        person.setAge(age);
        if (!(age >= 18 && age <= 120)) {
            //throws 和 throw 的区别
            //1.throws用在方法的声明处,后面跟异常的类型
            //2.throws用在方法体内,后面跟异常对象
            throw new AgeException("你输入的年龄有误...");
        }else {
            System.out.println("你的年龄为:" + person.getAge());
        }
    }
}

//此处的AgeException为自定义异常
//一般的自定义异常都是继承RuntimeException的
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}

class Person {
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
