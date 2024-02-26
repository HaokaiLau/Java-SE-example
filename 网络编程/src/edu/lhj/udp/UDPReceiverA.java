package edu.lhj.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * UDP接收端
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象,准备在9999端口接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        //2.创建一个DatagramPacket对象,用于接收数据
        // UDP数据包最大为64K
        byte[] bytes = new byte[64 * 1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        //3.调用接收方法。将网络传输的DatagramSocket对象填充到DatagramPacket对象中去
        // 然后由receive方法接收
        System.out.println("接收端等待接收...");
        datagramSocket.receive(datagramPacket);

        //4.把DatagramPacket进行拆包,取出数据并显示
        int length = datagramPacket.getLength();//接收端接收到的数据长度
        byte[] data = datagramPacket.getData();//拆包取得数据
        System.out.println(new String(data,0,length));
        
        //向9998端口回发信息
        data = "好的,明天见".getBytes();
        DatagramPacket datagramPacket1 = new DatagramPacket(data, data.length, InetAddress.getLocalHost(),9998);
        datagramSocket.send(datagramPacket1);//由send方法发送

        //关闭资源
        datagramSocket.close();
        System.out.println("A端已关闭");
    }
}
