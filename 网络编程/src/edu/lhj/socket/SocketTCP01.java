package edu.lhj.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 实现 从客户端通过数据通道发送“hello,server”给服务端
 */
@SuppressWarnings({"all"})
public class SocketTCP01 {
    public static void main(String[] args) throws IOException {
        // 思路
        //1.通过ip/域名 + 接口连接服务端(ip/域名, 端口号),如果连接成功则返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket的运行类型:" + socket.getClass());
        //2.连接上服务端后,通过通过socket.getOutputStream()把数据从客户端写入到数据通道
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        //3.关闭流和socket,必须要两个都关闭！！！
        if (socket != null) {
            socket.close();
        }
        if (outputStream != null) {
            outputStream.close();
        }
    }
}
