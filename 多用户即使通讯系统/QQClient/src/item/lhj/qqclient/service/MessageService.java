package item.lhj.qqclient.service;

import item.lhj.qqcommon.Message;
import item.lhj.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class MessageService {
    public void send(String sender ,String receiver,String content) {
        //向服务端发送一个Message对象,信息类型为MESSAGE_COMM_MES
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_COMM_MES);
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println("你 对 " + receiver + " 说 " +
                content);
        //消息的属性编辑完毕后,把消息对象写入数据通道
        try {
            //获取当前用户对应的线程的Socket,利用Socket获取对象输出流
            //1.先从管理线程集合类中调用get方法传入uid获取对应的线程
            //2.获取到线程后调用线程类中的get方法获取Socket
            //3.利用Socket获取输出流
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getThread(
                            sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendAll(String sender ,String content) {
        //向服务端发送一个Message对象,信息类型为MESSAGE_COMM_MES
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_TO_ALL_MES);
        message.setSender(sender);
        message.setReceiver("所有人");
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println("你 对 " + message.getReceiver() + " 说 " +
                content);
        //消息的属性编辑完毕后,把消息对象写入数据通道
        try {
            //获取当前用户对应的线程的Socket,利用Socket获取对象输出流
            //1.先从管理线程集合类中调用get方法传入uid获取对应的线程
            //2.获取到线程后调用线程类中的get方法获取Socket
            //3.利用Socket获取输出流
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getThread(
                            sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
