package com.fse;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConfig {
    //Replace Db Config here

    static Connection getDbConnection(String dbUrl, String userName, String password) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");

            c = DriverManager
                    .getConnection(dbUrl, userName, password);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }
}
