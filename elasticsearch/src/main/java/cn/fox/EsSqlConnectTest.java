package cn.fox;

import org.elasticsearch.xpack.sql.jdbc.jdbcx.JdbcDataSource;

import java.sql.*;
import java.util.Properties;

public class EsSqlConnectTest {

    public static void main(String[] args) throws SQLException {
//        JdbcDataSource dataSource = new JdbcDataSource();
//        String address = "jdbc:es://10.20.128.210:15601/api/console/proxy";
//        dataSource.setUrl(address);
//        Properties connectionProperties = new Properties();
//        connectionProperties.put("user", "admin");
//        connectionProperties.put("password", "bigdata");
//        dataSource.setProperties(connectionProperties);
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);

                String address = "jdbc:es://10.20.128.210:15601";
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "admin");
        connectionProperties.put("password", "bigdata");
        Connection connection =
                DriverManager.getConnection(address, connectionProperties);
//        System.out.println(connection);

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery("   SELECT author from library")) {
            while (results.next()) {
                String value = results.getString(0);
                System.out.println(value);
            }
        }



    }
}
