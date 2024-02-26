package edu.lhj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class SocketTCP02 {
    public static void main(String[] args) throws IOException {
        //1.连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //2.获取输出流,把数据写入到数据通道
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        // 设置一个写入结束标记
        socket.shutdownOutput();

        //3.发送数据完毕后再接收服务端回发的数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,readLen));
        }

        //关闭流和socket
        if (outputStream != null) {
            outputStream.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (socket != null) {
            socket.close();
        }
    }
}
