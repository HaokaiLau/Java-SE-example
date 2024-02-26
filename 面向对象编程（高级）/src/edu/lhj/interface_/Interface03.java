package edu.lhj.interface_;

public class Interface03 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        SqlServerDB sqlServerDB = new SqlServerDB();
        DataBase(mysqlDB);
        DataBase(sqlServerDB);
    }
    public static void DataBase(DBInterface dbInterface) {
        dbInterface.connect();
        dbInterface.close();
    }
}
