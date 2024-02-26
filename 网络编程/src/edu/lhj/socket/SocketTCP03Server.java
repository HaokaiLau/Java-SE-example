package edu.lhj.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //1.监听本机9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待连接...");

        //2.等待连接,连接成功则返回一个Socket对象
        Socket socket = serverSocket.accept();

        //3.通过socket.getInputStream()从数据通道读取数据
        InputStream inputStream = socket.getInputStream();
        // 利用转换流把字节流转换成字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);

        //4.通过socket.getOutputStream()把数据写入数据通道
        OutputStream outputStream = socket.getOutputStream();
        // 利用转换流把字节流转成字符流,然后刷新
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hello,client");
        //socket.shutdownOutput();//写入结束标记
        bw.newLine();//使用这种方式作为结束标记时,需要对方使用readLine来读取数据
        bw.flush();//如果使用字符流,需要flush/close,否则数据无法正常写入


        //关闭资源
        if (bw != null) {
            bw.close();
        }
        if (br != null) {
            br.close();
        }
        if (socket != null) {
            socket.close();
        }
        if (serverSocket != null) {
            serverSocket.close();
        }
        System.out.println("服务端退出...");
    }
}
