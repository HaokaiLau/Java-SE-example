package edu.lhj.exception_;

public class TryCatch01 {
    //如果出现了异常并且不对异常进行处理
    //系统默认隐藏了一个 throws Exception 把抛出的异常一级一级向上抛出,
    //如果上级都没有对抛出的异常进行处理,则把异常抛到最顶级的JVM中,JVM接收到
    // 异常,就会只会把异常信息直接输出,不会对异常进行处理
    public static void main(String[] args) throws Exception {
        int num1 = 10;
        int num2 = 0;

        try {
            int res = num1 / num2;
        } catch (Exception e) {
            //捕获到异常
            //1.当异常发生时
            //2.系统将Exception对象e,传递给catch
            //3.得到异常后,程序员可以对e进行处理
            //注意:如果没有发生异常catch不会执行
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            //1.无论try中的代码是否有异常发生,finally始终会执行
            //2.所以,通常把释放资源的代码放到finally里面去
            //注意:finally根据需求可加可不加,不加finally语法也是可以通过的
        }
        System.out.println("程序继续运行...");
    }
}
