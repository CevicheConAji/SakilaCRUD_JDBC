package org.example.Controller;

import org.example.DB.ConnectDB;

import java.sql.*;

public class ControllerFilm {
    private ConnectDB connect = new ConnectDB();
    private Connection con = connect.getConnection();

    public void connectDB(){
        try {
            con = DriverManager.getConnection(connect.getJdbc(),connect.getUsername(),connect.getPassword());
            System.out.println("Connected to database");
        }catch (SQLException e){
            System.out.println("Error "+e.getMessage());
        }
    }
    public void closeDB(){

        try{
            con.close();
            System.out.println("Closed connection");
        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
    }
    public ResultSet getFilm(){
        ResultSet rs = null;

        String sql = "select * from film WHERE film_id LIMIT 50";
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
        return rs;
    }
    public void showFilm(ResultSet rs){
        try {
            System.out.printf("%-10s %-30s %-10s\n","FILM ID","FILM TITTLE","DESCRIPTION");
            while (rs.next()){
                int film_id = rs.getInt("film_id");
                String film_title = rs.getString("title");
                String description = rs.getString("description");
                System.out.printf("%-10s %-30s %-10s\n",film_id,film_title,description);
            }

        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }



    }
}
