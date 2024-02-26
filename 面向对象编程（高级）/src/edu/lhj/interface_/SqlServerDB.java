package edu.lhj.interface_;

public class SqlServerDB implements DBInterface{
    @Override
    public void connect() {
        System.out.println("SqlServer已连接...");
    }

    @Override
    public void close() {
        System.out.println("SqlServer已关闭...");
    }
}
