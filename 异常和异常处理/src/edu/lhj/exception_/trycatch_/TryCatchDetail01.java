package edu.lhj.exception_.trycatch_;

public class TryCatchDetail01 {
    public static void main(String[] args) {
        //1.如果程序出现异常,则出现异常的代码后面的代码不再执行,直接进入到catch中
        //2.如果没有出现异常,则顺序执行try中的代码,不仅如此catch中
        //3.如果希望无论是否发生异常,都执行某段代码(如:关闭链接,释放资源等),则使用finally
        try {
            String str = "123";
//            String str = "广东工商职业技术大学";
            int a = Integer.parseInt(str);
            System.out.println("数字a=" + a);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            System.out.println("异常信息为:" + e.getMessage());
        }finally {
            System.out.println("finally块被执行...");
        }
        System.out.println("程序继续执行...");
    }
}
