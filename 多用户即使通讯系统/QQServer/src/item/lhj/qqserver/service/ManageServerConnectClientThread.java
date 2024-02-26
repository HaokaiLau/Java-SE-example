package item.lhj.qqserver.service;

import java.util.HashMap;
import java.util.Set;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class ManageServerConnectClientThread {
    //我们把多个线程放入到一个HashMap中管理,key就是uid,value就是线程
    private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    //将某个线程添加到集合中的方法
    public static void addThread(String uid,ServerConnectClientThread thread) {
        hm.put(uid, thread);
    }

    //通过uid可以得到相应线程并返回
    public static ServerConnectClientThread getThread(String uid) {
        return hm.get(uid);
    }

    //返回在线用户列表
    public static String getOnlineList() {
        String onlineList = "";
        //遍历集合中的key(即uid),并放入到字符串中,以空格分割
        Set<String> keySet = hm.keySet();
        for (String uid : keySet) {
            onlineList += uid + " ";
        }
        return onlineList;
    }

    //移除接收到退出消息的线程
    public static void removeThread(String sender) {
        hm.remove(sender);
    }
}
