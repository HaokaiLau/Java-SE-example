package item.lhj.qqserver.service;

import item.lhj.qqcommon.Message;
import item.lhj.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 该类是和某个客户端保持通讯的一个类
 */
public class ServerConnectClientThread extends Thread {

    //定义一个Socket
    private Socket socket;
    private String uid;//连接到服务端的用户id

    //构造器可以接收一个Socket对象,使得该线程会持有一个Socket对象
    public ServerConnectClientThread(Socket socket, String uid) {
        this.socket = socket;
        this.uid = uid;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        //因为需要线程在后台不断地发送/接收消息,因此我们使用while循环
        while (true) {
            try {
                //System.out.println("服务端线程:等待读取从客户端" + "(用户" + uid + ")" + "发送的消息...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                //根据客户端发送的消息类型,做不同的处理
                if (message.getMsgType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {//获取在线用户列表
                    System.out.println(message.getSender() + " 请求获取在线好友列表...");
                    Message message2 = new Message();
                    message2.setMsgType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(ManageServerConnectClientThread.getOnlineList());
                    message2.setReceiver(message.getSender());//谁请求的就发回去给谁
                    //消息的属性编辑完毕后,把消息对象写入数据通道
                    //ManageServerConnectClientThread.getThread(message2.getReceiver()).socket.getOutputStream()
                    //这里不用上面那句这么复杂是因为构造器获取了一个socket,这个socket和用户登录的时候用的socket是同一个socket
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                } else if (message.getMsgType().equals(MessageType.MESSAGE_TO_ALL_MES)) {//群发
                    //获取在线列表,使用循环遍历在线列表并发送
                    String[] onlineList = ManageServerConnectClientThread.getOnlineList().split(" ");
                    for (String receiver : onlineList) {
                        if (!receiver.equals(message.getSender())) {//排除掉发送者
                            ObjectOutputStream oos = new ObjectOutputStream(
                                    ManageServerConnectClientThread.getThread(
                                            receiver).socket.getOutputStream());
                            oos.writeObject(message);
                        }
                    }

                } else if (message.getMsgType().equals(MessageType.MESSAGE_COMM_MES)) {//私聊
                    if (ManageServerConnectClientThread.getThread(message.getReceiver()) != null) {
                        //根据消息的接收者来确定应该接受这条消息的客户端
                        ObjectOutputStream oos = new ObjectOutputStream(
                                ManageServerConnectClientThread.getThread(
                                        message.getReceiver()).socket.getOutputStream());
                        oos.writeObject(message);
                    } else {
                        Message message3 = new Message();
                        message3.setMsgType(MessageType.MESSAGE_COMM_MES);
                        message3.setSender("服务器");
                        message3.setReceiver(message.getSender());
                        message3.setContent("该用户离线/不存在,请核对用户名再尝试...");
                        ObjectOutputStream oos = new ObjectOutputStream(
                                ManageServerConnectClientThread.getThread(
                                        message.getSender()).socket.getOutputStream());
                        oos.writeObject(message3);
                    }

                } else if (message.getMsgType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {//用户退出
                    System.out.println("用户" + message.getSender() + "退出");
                    ManageServerConnectClientThread.removeThread(message.getSender());
                    socket.close();//关闭数据通道
                    break;//退出while循环

                } else if (message.getMsgType().equals(MessageType.MESSAGE_FILE_MES)) {//发送文件
                    ObjectOutputStream oos = new ObjectOutputStream(
                            ManageServerConnectClientThread.getThread(
                                    message.getReceiver()).socket.getOutputStream());
                    oos.writeObject(message);
                } else {
                    System.out.println("其他类型message,暂时不做处理...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
