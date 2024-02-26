package edu.lhj.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        //在9999接口接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //接收数据
        byte[] data = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
        datagramSocket.receive(datagramPacket);
        //拆包,取出数据,显示
        int length = datagramPacket.getLength();//接收到的数据的长度
        data = datagramPacket.getData();//实际接收的数据
        String s = new String(data, 0, length);
        System.out.println(s);
        //根据数据内容的不同回发不同的信息
        if (s.equals("四大名著是哪些")) {
            data = "四大名著有《西游记》《红楼梦》《水浒传》《三国演义》".getBytes(StandardCharsets.UTF_8);
        }else {
            data = "你说啥呢?".getBytes(StandardCharsets.UTF_8);
        }
        datagramPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(),9998);
        datagramSocket.send(datagramPacket);
        //关闭资源
        datagramSocket.close();
    }
}
