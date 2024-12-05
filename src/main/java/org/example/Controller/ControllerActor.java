package org.example.Controller;


import org.example.DB.ConnectDB;

import java.sql.*;

public class ControllerActor {
    private ConnectDB connection = new ConnectDB();
    private Connection con = connection.getConnection();

    public void connectDB(){
        String query = "select * from actor";

        try{
            con = DriverManager.getConnection(connection.getJdbc(), connection.getUsername(),connection.getPassword());
            System.out.println("Connected to database");
        }catch (SQLException e){
            System.out.printf("Error "+e.getMessage());
        }
    }
    public void closeDB(){
        try {
            con.close();
            System.out.printf("Closing connection");
        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
    }
    public ResultSet getActor(){
        String query = "select * from actor LIMIT 50";
        ResultSet rs = null;
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }catch (SQLException ex){
            System.out.printf("Error "+ex.getMessage());
        }
        return rs;
    }
    public void showActor(ResultSet rs){

        try {
            while (rs.next()){
                String actor_id = rs.getString("actor_id");
                System.out.printf("%-10s\n",actor_id);
            }

        }catch (SQLException ex){
            System.out.printf("Error "+ex.getMessage());
        }
    }

}
