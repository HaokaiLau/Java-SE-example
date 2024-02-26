package edu.lhj.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * UDP发送端
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象,准备向9998端口接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9998);

        //2.创建一个DatagramPacket对象,用于发送数据 (数据,数据长度,主机/域名,端口号)
        // UDP数据包最大为64K
        byte[] data = "hello,明天吃火锅".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(),9999);
        //3.调用发送方法。将网络传输的DatagramSocket对象填充到DatagramPacket对象中去
        // 然后由send方法发送
        datagramSocket.send(datagramPacket);

        //接收9999端口回发的信息
        byte[] receiveData = new byte[64 * 1024];
        datagramPacket = new DatagramPacket(receiveData, receiveData.length);
        datagramSocket.receive(datagramPacket);//由receive方法接收
        int length = datagramPacket.getLength();//接收数据的长度
        data = datagramPacket.getData();//接收的数据
        System.out.println(new String(data,0,length));

        //关闭资源
        datagramSocket.close();
        System.out.println("B端已关闭");
    }
}
