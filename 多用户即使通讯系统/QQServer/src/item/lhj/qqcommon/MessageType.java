package item.lhj.qqcommon;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public interface MessageType {

    //在接口中定义一些常量
    //不同的常量的值表示不同的消息类型
    String MESSAGE_LOGIN_SUCCESS = "1";//表示登录成功
    String MESSAGE_LOGIN_FAIL = "2";//表示登录失败
    String MESSAGE_COMM_MES = "3";//表示普通的信息包
    String MESSAGE_TO_ALL_MES = "4";//表示群发的信息包
    String MESSAGE_GET_ONLINE_FRIEND = "5";//表示获取在线好友列表
    String MESSAGE_RET_ONLINE_FRIEND = "6";//表示返回在线好友列表
    String MESSAGE_CLIENT_EXIT = "7";//表示客户端请求退出
    String MESSAGE_FILE_MES = "8";//表示文件类型的消息
    String MESSAGE_NEWS_MES = "9";//表示新闻类型的消息
}
