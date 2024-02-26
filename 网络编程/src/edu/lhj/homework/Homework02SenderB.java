package edu.lhj.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Homework02SenderB {
    public static void main(String[] args) throws IOException {
        //在9998接口接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        //发送数据
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的问题:");
        String next = scanner.next();
        byte[] data = next.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket =
                new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 9999);
        datagramSocket.send(datagramPacket);
        //接收数据
        data = new byte[1024];
        datagramPacket = new DatagramPacket(data, data.length);
        datagramSocket.receive(datagramPacket);
        //拆包,取出数据,显示
        int length = datagramPacket.getLength();//接收到的数据的长度
        data = datagramPacket.getData();//实际接收的数据
        String s = new String(data, 0, length);
        System.out.println(s);

        //关闭资源
        datagramSocket.close();
    }
}
