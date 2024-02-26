package edu.lhj.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericDetail {
    public static void main(String[] args) {
        //1.给泛型指定数据类型时,要求的是引用类型,不能是基本数据类型
        List<Integer> list = new ArrayList<Integer>();
        //ArrayList<int> list1 = new ArrayList<int>();//错误

        //2.在给泛型指定了具体的类型后,可以传入该类型及其子类类型的数据
        C<A> ac = new C<A>(new A());
        //C<A> ac1 = new C<A>(new B());错误,因为B类不是A类的子类
        C<A> ac2 = new C<A>(new D());//D类继承了A类

        //3.泛型的使用形式
        List<Integer> list1 = new ArrayList<Integer>();
        List<Double> list2 = new ArrayList<>();
        //在开发中我们往往使用简写的形式
        //编译器会自动进行类型判断
        List<Integer> list3 = new ArrayList<>();
        List<Double> list4 = new ArrayList<>();

        //4.当我们不对泛型进行定义时,默认泛型为Object类型
    }
}

class A {}
class B {}
class D extends A{}
class C<E> {
    E e;
    public C(E e) {
        this.e = e;
    }
}
