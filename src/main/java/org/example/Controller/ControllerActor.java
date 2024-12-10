package org.example.Controller;


import org.example.DB.ConnectDB;

import java.sql.*;

public class ControllerActor {

    public ResultSet getcincuentaActors(Connection con){
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
