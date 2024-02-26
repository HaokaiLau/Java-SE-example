package item.lhj.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 演示如何通过反射获取类的结构信息
 */
@SuppressWarnings({"all"})
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    //第二、三、四组
    @Test
    public void api_02() throws ClassNotFoundException, NoSuchMethodException {
        //得到Class对象
        Class<?> personCls = Class.forName("item.lhj.reflection.Person");
        //getDeclaredFields:获取本类中所有属性
        //规定 说明: 默认修饰符 是0 ， public  是1 ，private 是 2 ，protected 是 4 , static 是 8 ，final 是 16
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性=" + declaredField.getName()
                    + " 该属性的修饰符值=" + declaredField.getModifiers()
                    + " 该属性的类型=" + declaredField.getType());
        }

        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName()
                    + " 该方法的访问修饰符值=" + declaredMethod.getModifiers()
                    + " 该方法返回类型" + declaredMethod.getReturnType());

            //输出当前这个方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型=" + parameterType);
            }
        }

        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("====================");
            System.out.println("本类中所有构造器=" + declaredConstructor.getName());//这里老师只是输出名

            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型=" + parameterType);
            }



        }

    }

    //第一组方法API
    @Test
    public void api_01() throws Exception {
        //得到Class类对象
        Class<?> personCls = Class.forName("item.lhj.reflection.Person");
        //getName:获取全类名
        System.out.println(personCls.getName());
        //getSimpleName 获取简单类名
        System.out.println(personCls.getSimpleName());
        //getFields 获取所有public修饰的属性,包括本类以及父类的
        Field[] fields = personCls.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }
        //getDeclaredFields 获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        System.out.println("============================================");
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i]);
        }
        //getMethods 获取所有public修饰的方法,包括本类以及父类的
        Method[] methods = personCls.getMethods();
        System.out.println("============================================");
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }
        //getDeclaredMethods 获取本类中所有的方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        System.out.println("============================================");
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i]);
        }
        //getConstructors 获取所有public修饰的构造器,仅包括本类
        Constructor<?>[] constructors = personCls.getConstructors();
        System.out.println("============================================");
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i]);
        }
        //getDeclaredConstructors 获取本类中所有的构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        System.out.println("============================================");
        for (int i = 0; i < declaredConstructors.length; i++) {
            System.out.println(declaredConstructors[i]);
        }
        //getPackage 以Package形式返回包信息
        Package aPackage = personCls.getPackage();
        System.out.println(aPackage);
        //getPackageName 以字符串形式返回包信息
        String packageName = personCls.getPackageName();
        System.out.println(packageName);
        //getSuperclass 以Class形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println(superclass);
        //getInterfaces 以Class[]形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i]);
        }
        //getAnnotations 以Annotation[]形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}


class A {
    public String hobby;

    public void hi() {

    }

    public A() {
    }

    public A(String name) {
    }
}

interface IA {
}

interface IB {

}

@Deprecated
class Person extends A implements IA, IB {
    //属性
    public String name;
    protected static int age; // 4 + 8 = 12
    String job;
    private double sal;

    //构造器
    public Person() {
    }

    public Person(String name) {
    }

    //私有的
    private Person(String name, int age) {

    }

    //方法
    public void m1(String name, int age, double sal) {

    }

    protected String m2() {
        return null;
    }

    void m3() {

    }

    private void m4() {

    }
}
