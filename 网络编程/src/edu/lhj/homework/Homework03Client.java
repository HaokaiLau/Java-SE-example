package edu.lhj.homework;

import edu.lhj.upload.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 从服务端下载文件
 */
public class Homework03Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //向服务端发送信息
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入:");
        String next = scanner.next();
        bos.write(next.getBytes(StandardCharsets.UTF_8));
        bos.flush();//刷新流
        socket.shutdownOutput();//写入结束标记

        //接收服务端发送的文件
        String savePath = "d:\\javacode\\FileIO\\picture\\" + next + ".jpg";
        String reply = "服务端没有找到该文件...";
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] array = StreamUtils.streamToByteArray(bis);
        bos = new BufferedOutputStream(new FileOutputStream(savePath));
        bos.write(array);//把文件保存到指定路径中
        bos.flush();//刷新流

        //关闭资源
        bos.close();
        bis.close();
        socket.close();

        System.out.println("客户端已退出...");
    }
}
