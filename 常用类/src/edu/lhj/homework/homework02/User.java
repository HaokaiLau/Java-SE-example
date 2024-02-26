package edu.lhj.homework.homework02;

public class User {
    private String id;
    private String password;
    private String email;

    public User(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public void userRegister(User user) {

        //1.验证用户名长度是否为2-4个字符
        int idLength = user.getId().length();
        if (!(idLength >= 2 && idLength <= 4)) {
            throw new RuntimeException("用户名长度应在2-4个字符的长度");
        }

        //2.验证密码长度是否为6位纯数字
        if (!(user.getPassword().length() == 6 && isDigital(user.getPassword()))) {
            throw new RuntimeException("密码长度应为6位纯数字");
        }

        //3.验证邮箱是否含有@和. 且.是否在@前面
        int i = user.getEmail().lastIndexOf("@");
        int j = user.getEmail().lastIndexOf(".");
        if (!((i > 0) && (j > i))) {
            throw new RuntimeException("邮箱地址必须包含@和.并且.要在@前面");
        }


    }

    public static boolean isDigital(String password) {
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "用户名：" + id + '\n' +
                "密码：" + password + '\n' +
                "邮箱：" + email + '\n';
    }
}
