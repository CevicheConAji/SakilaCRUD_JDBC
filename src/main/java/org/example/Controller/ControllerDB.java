package org.example.Controller;

import org.example.DB.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControllerDB {
    private  ConnectDB connection = new ConnectDB();
    private Connection con = connection.getConnection();

    public  Connection connectDB() {
        try{
            con = DriverManager.getConnection(connection.getJdbc(),connection.getUsername(),connection.getPassword());
            System.out.println("Conexion exitosa");

        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
        return con;
    }
    public void closeConnection() {
        try{
            con.close();
            System.out.println("Conexion Cerrada");

        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }

    }
}
