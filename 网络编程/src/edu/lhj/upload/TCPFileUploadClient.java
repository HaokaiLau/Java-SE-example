package edu.lhj.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        String filePath = "d:\\javacode\\FileIO\\灵魂莲华阿狸.jpg";

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //调用方法,把读取的内容存入数组
        byte[] array = StreamUtils.streamToByteArray(bis);
        //把数组的内容写入数据通道
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(array);
        bos.flush();
        socket.shutdownOutput();//写入结束标记

        //接收服务端回发的信息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭资源
        inputStream.close();
        bos.close();
        bis.close();
        socket.close();
        System.out.println("客户端已退出...");
    }
}
