package edu.lhj.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 演示InetAddress 类的使用
 */
@SuppressWarnings({"all"})
public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        //1.获取本机InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//机器名/ip地址 Redmibook/192.168.31.105

        //2.根据主机名获取对应的InetAddress对象
        InetAddress redmibook = InetAddress.getByName("Redmibook");
        System.out.println("localHost=" + redmibook);//localHost=Redmibook/192.168.31.105

        //3.根据指定域名来获取对应的InetAddress对象,如 www.baidu.com
        InetAddress host1 = InetAddress.getByName("www.baidu.com");
        System.out.println("host1=" + host1);//host1=www.baidu.com/120.232.145.144

        //4.根据InetAddress对象获取对应的ip地址
        String hostAddress = host1.getHostAddress();
        System.out.println("host1对应的地址为:" + hostAddress);//120.232.145.144

        //5.根据InetAddress对象来获取对应的主机名/域名
        String hostName = host1.getHostName();
        System.out.println("host1对应的主机名为:" + hostName);//www.baidu.com
    }
}
