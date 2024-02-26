package item.lhj.qqclient.view;

import item.lhj.qqclient.service.FileService;
import item.lhj.qqclient.service.MessageService;
import item.lhj.qqclient.service.UserClientService;
import item.lhj.qqclient.utility.Utility;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 * 客户端的菜单界面
 */
public class QQView {

    private boolean loop = true;
    //定义UserClientService对象,里面的方法用于判断登录/注册是否成功
    private UserClientService userClientService = new UserClientService();
    //定义一个MessageService对象,里面的方法用于发送消息
    private MessageService messageService = new MessageService();
    //定义一个FileSendService对象,里面的方法用于传输文件
    private FileService fileSendService = new FileService();

    public static void main(String[] args) {
        new QQView().mainMenu();
    }

    public void mainMenu() {
        while (loop) {
            System.out.println("==========欢迎来到网络通信系统==========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择:");
            int key = Utility.readInt();
            switch (key) {
                case 1:
                    System.out.print("用 户 名:");
                    String uid = Utility.readString(50);
                    System.out.print("密   码:");
                    String password = Utility.readString(50);
                    //这里需要把用户名和密码封装成一个User对象到服务端去比对是否存在
                    //后面再完善
                    if (userClientService.checkUser(uid, password)) {//先把大概的逻辑框架写出来
                        System.out.print("==========欢迎" + uid + "==========");
                        //随即进入二级菜单
                        while (loop) {
                            System.out.println("\n==========网络通信系统二级菜单(用户" + uid + ")==========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择:");
                            int selection = Utility.readInt();
                            switch (selection) {
                                case 1:
                                    //System.out.println("显示在线用户列表");
                                    userClientService.onlineFriendList();
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 2:
                                    //System.out.println("群发消息");
                                    System.out.print("请输入群发内容:");
                                    String content = Utility.readString(200);
                                    messageService.sendAll(uid, content);
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 3:
                                    //System.out.println("私聊消息");
                                    System.out.print("请输入好友名称:");
                                    String receiver = Utility.readString(50);
                                    System.out.print("请输入发送内容:");
                                    content = Utility.readString(200);
                                    messageService.send(uid, receiver, content);
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 4:
                                    //System.out.println("发送文件");
                                    System.out.print("请输入好友名称:");
                                    receiver = Utility.readString(50);
                                    System.out.print("请输入源文件路径:");
                                    String src = Utility.readString(50);
                                    System.out.print("请输入发送的目标路径:");
                                    String target = Utility.readString(50);
                                    fileSendService.sendFile(src,target,uid,receiver);
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 9:
                                    //调用方法,给服务器发送一个退出线程的message
                                    userClientService.logout();
                                    System.out.println("退出系统");
                                    loop = false;
                                    break;
                            }
                        }
                    } else {//信息校验有误
                        System.out.println("==========登录失败==========");
                    }
                    break;
                case 9:
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }
        }
    }
}
