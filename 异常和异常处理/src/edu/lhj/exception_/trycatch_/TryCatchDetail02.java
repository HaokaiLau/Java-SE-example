package edu.lhj.exception_.trycatch_;

public class TryCatchDetail02 {
    public static void main(String[] args) {
        //如果try中代码存在多个异常,我们可以使用多个catch来捕获多个不同的异常,对应处理
        //要求:子类异常写在前面,父类异常写在后面
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName());//NullPointerException空指针异常
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;//ArithmeticException算术异常
        } catch (NullPointerException e) {
            System.out.println("空指针异常:" + e.getMessage());
        }  catch (ArithmeticException e) {
            System.out.println("算术异常:" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }
}

class Person {
    private String name = "Tim";

    public String getName() {
        return name;
    }
}
