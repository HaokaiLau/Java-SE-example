package edu.lhj.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);//监听9999端口
        System.out.println("服务端在9999端口等待连接...");
        Socket socket = serverSocket.accept();//等待客户端连接

        //获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println(s);

        //获取输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //根据接收到的数据内容作出不同的回复
        if (s.equals("name")) {
            bw.write("服务端:" + "我是nova~");
        }else if (s.equals("hobby")) {
            bw.write("服务端:" + "编写java程序~");
        }else {
            bw.write("服务端:" + "不是你说啥呢?");
        }
        bw.newLine();//写入结束标记
        bw.flush();//刷新流,使成功写入数据

        //关闭资源
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();

        System.out.println("服务端已退出...");
    }
}
