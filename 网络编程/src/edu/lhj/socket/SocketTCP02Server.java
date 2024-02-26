package edu.lhj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //1.服务端监听本机的9999接口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在本机9999端口监听,等待客户端连接...");

        //2.等待客户端连接,连接成功则返回Socket对象
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,readLen));
        }
        // 设置一个读取结束标记
        socket.shutdownInput();

        //3.接收数据完毕后再回发数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,client".getBytes());

        //关闭流和socket、serverSocket
        if (outputStream != null) {
            outputStream.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (socket != null) {
            socket.close();
        }
        if (serverSocket != null) {
            serverSocket.close();
        }
    }
}
