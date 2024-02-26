package edu.lhj.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        String filePath = "src\\灵魂莲华阿狸.jpg";

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待连接...");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        //调用方法,把读取的内容存入数组
        byte[] array = StreamUtils.streamToByteArray(inputStream);
        //把数组的内容写到目标路径
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(array);
        bos.flush();

        //向客户端发送信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到图片".getBytes());
        socket.shutdownOutput();//写入结束标记

        //关闭资源
        outputStream.close();
        bos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端已退出...");
    }
}
