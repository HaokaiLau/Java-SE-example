package edu.lhj.interface_;

public interface DBInterface {//制定规范(即通过接口制定实现接口同时必须实现的方法)
    public void connect();
    public void close();
}
