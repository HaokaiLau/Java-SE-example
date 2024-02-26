package item.lhj.qqclient.service;

import item.lhj.qqcommon.Message;
import item.lhj.qqcommon.MessageType;
import item.lhj.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {

    private User user = new User();//初始化一个User对象
    private Socket socket;
    boolean isSuccess = false;//是否校验成功

    public boolean checkUser(String uid, String password) {
        //把uid和密码封装成一个User对象
        user.setUid(uid);
        user.setPassword(password);

        try {
            //把User对象发送到服务端
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //使用对象流向数据通道写入数据
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);

            //读取从服务端发送回来的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();
            //对message对象进行校验
            if (message.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCESS)) {
                //创建一个和服务器端保持通信的线程,需要创建一个线程类ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();
                //为了后面客户端扩展,我们把该线程添加到集合中
                ManageClientConnectServerThread.addThread(uid,clientConnectServerThread);
                isSuccess = true;

            } else {
                //如果登录失败了,我们就不能启动线程,同时还要关闭Socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    public void onlineFriendList() {
        //向服务端发送一个Message对象,信息类型为MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(user.getUid());
        //消息的属性编辑完毕后,把消息对象写入数据通道
        try {
            //获取当前用户对应的线程的Socket,利用Socket获取对象输出流
            //1.先从管理线程集合类中调用get方法传入uid获取对应的线程
            //2.获取到线程后调用线程类中的get方法获取Socket
            //3.利用Socket获取输出流
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getThread(
                            user.getUid()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //退出客户端
    public void logout() {
        //向服务端发送一个Message对象,信息类型为MESSAGE_CLIENT_EXIT
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(user.getUid());
        //消息的属性编辑完毕后,把消息对象写入数据通道
        try {
            //获取当前用户对应的线程的Socket,利用Socket获取对象输出流
            //1.先从管理线程集合类中调用get方法传入uid获取对应的线程
            //2.获取到线程后调用线程类中的get方法获取Socket
            //3.利用Socket获取输出流
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getThread(
                            user.getUid()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println("用户" + user.getUid() + "已退出...");
            socket.close();
            System.exit(0);//关闭客户端
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
