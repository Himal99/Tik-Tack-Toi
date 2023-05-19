package com.custom.orm.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */
public class DbConnection {

    public static Connection getConnection()throws Exception
    {
        String userName="sa",pw="root",
                url="jdbc:sqlserver://localhost:1433;DatabaseName=orm;" +
                        "encrypt=true;trustServerCertificate=true;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(url,userName,pw);
        return connection;
    }
}
