package org.example.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {

    private static volatile ConnectionPool connectionPool;
    private String datasource;
    private DataSource ds;

    {
        try (InputStream in = ConnectionPool.class
                .getClassLoader().getResourceAsStream("application.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            datasource = properties.getProperty("datasource.name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //WebLogic Datasource
    {
        Context context;
        try {
            context = new InitialContext();
            ds = (DataSource) context.lookup(datasource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private ConnectionPool() {
    }

    public static ConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                if (connectionPool == null) {
                    connectionPool = new ConnectionPool();
                }
            }
        }
        return connectionPool;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

//    TomCat Datasource
//    private static PoolProperties p = new PoolProperties();
//    {
//        p.setUrl("jdbc:postgresql://localhost:5432/travel_agency");
//        p.setDriverClassName("org.postgresql.Driver");
//        p.setUsername("postgres");
//        p.setPassword("root");
//        ds = new org.apache.tomcat.jdbc.pool.DataSource(p);
//    }
