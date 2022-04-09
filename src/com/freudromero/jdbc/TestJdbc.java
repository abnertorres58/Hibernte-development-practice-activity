package com.freudromero.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_client_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbclient";
        String pass = "hbclient";

        try {
            System.out.println("Connecting to Database " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection Successful!!!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
