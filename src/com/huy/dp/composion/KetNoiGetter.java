package com.huy.dp.composion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiGetter {
    private Connection cnn = null;
    public Connection getCnn(){
        return cnn;
    }

    private static KetNoiGetter instance = null;

    private KetNoiGetter() throws SQLException, ClassNotFoundException {
 
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=composite;user=sa;password=sa;trustServerCertificate=true;";

        cnn = DriverManager.getConnection(url);
    }

    public static KetNoiGetter getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null || instance.cnn.isClosed()) {
            instance = new KetNoiGetter();
        }
        return instance;
    }
}
