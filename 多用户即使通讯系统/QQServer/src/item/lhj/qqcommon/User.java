package item.lhj.qqcommon;

import java.io.Serializable;

/**
 * @author 喜欢悠然独自在
 * @version 1.0
 */
public class User implements Serializable {//因为要使用对象流来读写,所以要实现序列化接口

    private static final long serialVersionUID = 1L;
    private String uid;//用户名/id
    private String password;//用户密码

    public User(String uid, String password) {
        this.uid = uid;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
