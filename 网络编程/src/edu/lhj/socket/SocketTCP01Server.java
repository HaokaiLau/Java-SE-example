package edu.lhj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        // 思路
        //1.在本机的9999端口监听,等待连接(创建ServerSocket对象,传入端口号)
        //细节:要求本机没有服务占用9999端口,否则可能会报异常
        //这个ServerSocket可以通过accept返回多个Scoket对象
        // 实现多个客户端连接服务端的并发
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在本机9999端口监听,等待客户端连接...");
        //2.当没有客户端连接9999端口时,程序会阻塞,等待连接...
        //如果有客户端连接该端口,则会返回一个Socket对象,程序继续执行
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket的运行类型:" + socket.getClass());
        //3.通过socket.getInputStream()读取从客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,readLen));
        }
        //4.关闭流、socket和serversocket,必须都关闭！！！
        if (socket != null) {
            socket.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (serverSocket != null) {
            serverSocket.close();
        }
    }
}
