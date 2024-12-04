package org.example.DB;

import java.sql.Connection;

public class ConnectDB {
    private String db;
    private String port;
    private String jdbc ;
    private String username ;
    private String password ;
    private Connection connection;


    public ConnectDB() {
        this.db = "sakila";
        this.port = "3306";
        this.jdbc = "jdbc:mysql://localhost:"+port+"/" + db;;
        this.username = "root";
        this.password = "root";
        this.connection = null;
    }


    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getJdbc() {
        return jdbc;
    }

    public void setJdbc(String jdbc) {
        this.jdbc = jdbc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
