package edu.lhj.interface_;

public class MysqlDB implements DBInterface{
    @Override
    public void connect() {
        System.out.println("Mysql已连接...");
    }

    @Override
    public void close() {
        System.out.println("Mysql已关闭...");
    }
}
