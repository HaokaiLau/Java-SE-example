package item.lhj.qqclient.service;

import item.lhj.qqcommon.Message;
import item.lhj.qqcommon.MessageType;

import java.io.*;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 文件传输服务
 */
public class FileService {
    /**
     * @param src      源文件路径
     * @param target   发送的目标路径
     * @param sender   发送者
     * @param receiver 接收者
     */
    public void sendFile(String src, String target, String sender, String receiver) {
        Message message = new Message();
        message.setMsgType(MessageType.MESSAGE_FILE_MES);
        message.setSrc(src);
        message.setTarget(target);
        message.setSender(sender);
        message.setReceiver(receiver);

        //使用文件输入流把本地文件以字节数组的形式读取到内存中
        FileInputStream fis = null;
        byte[] fileBytes = new byte[(int) new File(src).length()];//根据读取的文件长度创建对应大小的字节数组
        try {
            fis = new FileInputStream(src);
            fis.read(fileBytes);//把文件以字节数组的形式读入到内存中
            //将该字节数组放到message中的字节数组
            message.setFileBytes(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //发送文件到服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServerThread.getThread(
                            sender).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n你 向 " +
                message.getReceiver() + " 发送了文件: 从" + message.getSrc() +
                " 发送到 " + message.getTarget());
    }

    public void receiveFile(String target, byte[] fileBytes) {

    }
}
