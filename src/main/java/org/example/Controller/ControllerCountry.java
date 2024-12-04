package org.example.Controller;

import org.example.DB.ConnectDB;

import java.sql.*;

public class ControllerCountry {
    private ConnectDB connection = new ConnectDB();
    private Connection con = connection.getConnection();


    public void connectDB(){
        try{
            con = DriverManager.getConnection(connection.getJdbc(),connection.getUsername(),connection.getPassword());
            System.out.println("Connected to database "+ this.getClass().getName());

        }catch (SQLException e){
            System.out.println("Error "+ e.getMessage());
        }
    }

    public ResultSet getCountry(){
        String query = "SELECT * FROM country";
        ResultSet rs = null;
        try{
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }catch (SQLException ex){
            System.out.println("Error "+ ex.getMessage());
        }
        return rs;
    }
    public void showCountryInfo(ResultSet rs){
        try{
            System.out.printf("%-10s %-40s %-10s\n","COUNTRY ID","COUNTRY NAME","LAST UPDATE");
            while (rs.next()){
                int country_id = rs.getInt("country_id");
                String country_name = rs.getString("country");
                Timestamp last_update = rs.getTimestamp("last_update");

                System.out.printf("%-10s %-40s %-10s\n",country_id,country_name,last_update);
            }

        }catch (SQLException ex){
            System.out.println("Error "+ ex.getMessage());
        }
    }
    public void closeConnection(){
        try {
            con.close();
            System.out.println("Connection closed " + this.getClass().getName());
        }catch (SQLException ex){
            System.out.println("Error "+ ex.getMessage());
        }
    }
}
