package item.lhj.reflection.question;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        //传统方法
//        Cat cat = new Cat();
//        cat.hi();
        //反射的优点,无需修改源码,只需修改配置文件即可调用该类中的其他方法,以cry方法为例

        //如何利用配置文件来调用方法? 尝试
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));//载入配置文件
        //获取配置文件的信息
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("methodName=" + methodName);
        //创建对象,调用方法
        //new classfullpath();//我们会发现,因为classfullpath是字符串的形式,不是类名,所以创建不了对象
        //这时候就引出了反射
        //使用反射机制解决
        //1.加载类,返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //2.通过cls来获取你加载的类item.lhj.Cat的对象
        Object o = cls.newInstance();
        System.out.println("o对象的运行类型是:" + o.getClass());//class item.lhj.Cat
        //3.通过cls来获取你加载的类item.lhj.Cat的方法的对象
        // 即在反射中,可以把方法视为一个对象
        Method method = cls.getMethod(methodName);
        //4.通过方法的对象来调用方法
        //传统的调用形式 对象.方法
        //在反射机制中的调用形式 方法的对象.invoke(对象)
        method.invoke(o);

    }
}
