package item.lhj.qqserver.service;

import item.lhj.qqcommon.Message;
import item.lhj.qqcommon.MessageType;
import item.lhj.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 监听端口,等待客户端的连接
 */
public class QQServer {

    private ServerSocket serverSocket;
    //ConcurrentHashMap是线程安全的
    private static ConcurrentHashMap<String, User> validUser = new ConcurrentHashMap<>();

    static {//静态代码块,类加载的时候就会一同加载
        validUser.put("100", new User("100", "123456"));
        validUser.put("200", new User("200", "123456"));
        validUser.put("300", new User("300", "123456"));
        validUser.put("瑟提", new User("瑟提", "123456"));
        validUser.put("亚托克斯", new User("亚托克斯", "123456"));
        validUser.put("暮光星灵", new User("暮光星灵", "123456"));
    }

    private boolean checkUser(String uid,String password) {
        User user = validUser.get(uid);
        if (user == null) {//说明用户名不存在
            return false;
        }
        if (!user.getPassword().equals(password)) {//用户名正确,密码错误
            return false;
        }
        return true;
    }

    public QQServer() {
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("服务端在9999端口监听...");
            //启动推送新闻的线程
            Thread thread = new Thread(new SendNewsService());
            thread.start();//启动线程
            while (true) {//当服务端和某个客户端连接后,仍会继续监听
                //当没有新的客户端与本服务端连接时,程序会阻塞在这个位置
                Socket socket = serverSocket.accept();

                //获取对象输入流,读取数据
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();//读取客户端发送过来的User对象
                //创建Message对象,准备回复客户端
                Message message = new Message();
                //获取对象输出流,写入数据
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //对user对象的属性进行验证
                if (checkUser(user.getUid(), user.getPassword())) {
                    message.setMsgType(MessageType.MESSAGE_LOGIN_SUCCESS);
                    oos.writeObject(message);
                    System.out.println("用户 " + user.getUid() + " 登录成功!!");
                    //创建一个线程,和客户端保持通讯,该线程需要持有一个socket对象
                    // 即创建一个类 ServerConnectClientThread
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUid());
                    serverConnectClientThread.start();
                    ManageServerConnectClientThread.addThread(user.getUid(), serverConnectClientThread);

                } else {//登录失败
                    message.setMsgType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    System.out.println("用户" + user.getUid() + " 密码" + user.getPassword() +
                            "验证失败...");
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //如果服务端退出了while循环,说明服务端不再监听,我们需要关闭资源
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
