package item.lhj.qqserver.service;

import item.lhj.qqcommon.Message;
import item.lhj.qqcommon.MessageType;
import item.lhj.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class SendNewsService implements Runnable{

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        System.out.println("服务器推送线程已启动...");
        System.out.print("请输入推送的内容[exit退出]:");
        while (true) {
            String news = Utility.readString(200);
            if (news.equals("exit")) {
                System.out.println("服务器推送线程已退出");
                break;
            }
            Message message = new Message();
            message.setMsgType(MessageType.MESSAGE_NEWS_MES);
            message.setSender("服务器");
            message.setContent(news);
            message.setSendTime(new Date().toString());
            //遍历在线用户列表,取出所有在线用户的线程并推送新闻
            String[] onlineList = ManageServerConnectClientThread.getOnlineList().split(" ");
            for (String uid : onlineList) {
                message.setReceiver(uid);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(
                            ManageServerConnectClientThread.getThread(
                                    uid).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
