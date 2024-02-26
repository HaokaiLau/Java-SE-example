package edu.lhj.homework;

import edu.lhj.upload.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待连接...");
        Socket socket = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] b = new byte[1024];
        int readLen = 0;
        String filepath = "";
        while ((readLen = bis.read(b)) != -1) {
            filepath = "src\\" + new String(b, 0, readLen) + ".jpg";
            System.out.println(filepath);
        }
        //把图片存入到字节数组中
        bis = null;
        byte[] array = null;
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        File file = new File(filepath);
        if (file.exists()) {
            bis = new BufferedInputStream(new FileInputStream(filepath));
            array = StreamUtils.streamToByteArray(bis);
            bos.write(array);//把数据写入数据通道
            bos.flush();//刷新流
        } else {
            bis = new BufferedInputStream(new FileInputStream("src\\me.jpg"));
            array = StreamUtils.streamToByteArray(bis);
            System.out.println("服务器没有找到对应的文件,返回一个默认文件...");
            bos.write(array);//把数据写入数据通道
            bos.flush();//刷新流
        }
        socket.shutdownOutput();//写入结束标记

        //关闭资源
        bos.close();
        if (bis != null) {
            bis.close();
        }
        socket.close();
        serverSocket.close();

        System.out.println("服务端已退出...");
    }
}
