package item.lhj.qqcommon;

import java.io.Serializable;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    private String sender;//发送者
    private String receiver;//接收者
    private String content;//消息内容
    private String sendTime;//发送时间
    private String msgType;//消息类型[可以在接口定义消息类型]

    //扩展,添加和文件相关的属性
    private byte[] fileBytes;//字节数组,把文件以字节数组的形式保存到内存中
    private int fileLen;//文件长度
    private String target;//文件要发送到的目标路径
    private String src;//源文件的路径

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
