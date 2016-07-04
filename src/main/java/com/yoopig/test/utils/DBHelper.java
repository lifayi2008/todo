package com.yoopig.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by lifayi on 2016/6/30.
 */
public class DBHelper {

    private static String driver = null;
    private static String username = null;
    private static String password = null;
    private static String address = null;
    private static String database = null;

    private static Connection connection = null;

    static {
//        InputStream in = DBHelper.class.getClassLoader().getResourceAsStream("/WEB-INF/classes/config/db.properties");
        InputStream in = DBHelper.class.getClassLoader().getResourceAsStream("config/db.properties");
        Properties properties = new Properties();

        try {
            properties.load(in);

            driver = properties.getProperty("driver", "com.mysql.jdbc.Driver");
            username = properties.getProperty("username", "root");
            password = properties.getProperty("password", "root");
            address = properties.getProperty("address", "localhost");
            database = properties.getProperty("database", "blog");

            Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection getConnection() {
        if(connection != null)
            return connection;

        String url = "jdbc:mysql://" + address + ":3306/" + database + "?user=" + username + "&password=" + password;
        try {
            connection = DriverManager.getConnection(url);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void releaseResource(PreparedStatement preparedStatement, ResultSet resultSet) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                resultSet = null;
            }
        }

        if(preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
