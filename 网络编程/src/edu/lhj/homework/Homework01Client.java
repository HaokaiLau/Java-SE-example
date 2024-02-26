package edu.lhj.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);//连接9999端口
        //获取输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //从键盘读取用户输入的信息
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的问题:");
        String data = scanner.next();
        bw.write(data);
        bw.newLine();//写入结束标记
        bw.flush();//刷新流,使成功写入数据

        //获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);

        //关闭资源
        bw.close();
        socket.close();

        System.out.println("客户端已退出...");
    }
}
