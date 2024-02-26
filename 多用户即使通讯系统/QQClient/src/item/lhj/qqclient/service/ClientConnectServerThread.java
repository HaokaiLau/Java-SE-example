package item.lhj.qqclient.service;

import item.lhj.qqcommon.Message;
import item.lhj.qqcommon.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 该类是和服务端端保持通讯的一个类
 */
public class ClientConnectServerThread extends Thread {
    //定义一个Socket对象
    private Socket socket;

    //构造器可以接收一个Socket对象,使得该线程会持有一个Socket对象
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //因为线程需要在后台不断的接收消息,因此我们使用while循环
        while (true) {
            try {
                //System.out.println("客户端线程:等待读取从服务端发送的消息...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务端没有发送消息,则线程就会阻塞在这个位置
                Message message = (Message) ois.readObject();

                //判断服务端返回的消息类型,根据消息类型做不同的操作
                if (message.getMsgType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出消息中的在线好友列表并显示
                    //规定用空格隔开的,我们就以空格为分割标记
                    String[] onlineList = message.getContent().split(" ");
                    System.out.println("\n==========当前在线好友列表==========");
                    for (String uid : onlineList) {
                        System.out.println(" 用户:" + uid);
                    }
                } else if (message.getMsgType().equals(MessageType.MESSAGE_TO_ALL_MES)) {//群发
                    System.out.println("\n" + message.getSender() + " 对 " +
                            message.getReceiver() + " 说 " + message.getContent());

                } else if (message.getMsgType().equals(MessageType.MESSAGE_COMM_MES)) {//私聊
                    System.out.println("\n" + message.getSender() + " 对 你 说 " +
                            message.getContent());

                } else if (message.getMsgType().equals(MessageType.MESSAGE_FILE_MES)) {
                    System.out.println("\n" + message.getSender() + " 向 你" +
                            " 发送了文件: 从" + message.getSrc() + " 发送到 " + message.getTarget());
                    //定义一个文件输出流,取出字节数组,把字节数组输出到目标路径
                    FileOutputStream fos = new FileOutputStream(message.getTarget());
                    fos.write(message.getFileBytes());
                    fos.close();//要关闭/刷新才能成功写入
                    System.out.println("\n 保存文件成功!!!");

                } else if (message.getMsgType().equals(MessageType.MESSAGE_NEWS_MES)) {
                    System.out.println("\n来自 " + message.getSender() +
                            " 的推送 " + message.getContent());

                } else {
                    System.out.println("是其他类型的消息,暂时不处理...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
