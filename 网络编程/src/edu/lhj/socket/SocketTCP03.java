package edu.lhj.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class SocketTCP03 {
    public static void main(String[] args) throws IOException {
        //1.连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //2.通过socket.getOutputStream()把数据写入数据通道
        OutputStream outputStream = socket.getOutputStream();
        // 利用转换流把字节流转成字符流,然后刷新
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write("hello,server");
        //socket.shutdownOutput();//写入结束标记
        bw.newLine();//使用这种方式作为结束标记时,需要对方使用readLine来读取数据
        bw.flush();//如果使用字符流,需要flush/close,否则数据无法正常写入

        //3.通过socket.getInputStream()从数据通道中读取数据
        InputStream inputStream = socket.getInputStream();
        // 利用转换流把字节流转成字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        System.out.println(s);

        //关闭资源
        if (br != null) {
            br.close();
        }
        if (bw != null) {
            bw.close();
        }
        if (socket != null) {
            socket.close();
        }
        System.out.println("客户端退出...");
    }
}
