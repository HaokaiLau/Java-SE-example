package item.lhj.qqclient.service;

import java.util.HashMap;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 该类管理客户端连接服务端的线程
 */
public class ManageClientConnectServerThread {
    //我们把多个线程放入到一个HashMap中管理,key就是uid,value就是线程
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程添加到集合中的方法
    public static void addThread(String uid, ClientConnectServerThread thread) {
        hm.put(uid,thread);
    }

    //通过uid可以得到相应线程并返回
    public static ClientConnectServerThread getThread(String uid) {
        return hm.get(uid);
    }
}
