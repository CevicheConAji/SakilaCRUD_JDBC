package org.example;

import java.sql.*;

public class ControllerCity {
    private ConnectDB connection = new ConnectDB();
    private Connection con = connection.getConnection();

    public ResultSet getOneHundredCities(){
        String query = "SELECT * FROM city where city_id LIMIT 100";
        ResultSet config = null;
        try{
            Statement stmt = con.createStatement() ;
            config = stmt.executeQuery(query);
            System.out.println("Consulta "+ query + " ejecutada correctamente.");

        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
        return config;
    }
    public void showCityInfo(ResultSet config) {
        try{
            while(config.next()){
                int id = config.getInt("city_id");
                String name = config.getString("city");
                int country_id = config.getInt("country_id");
                Timestamp last_update = config.getTimestamp("last_update");
                System.out.printf("%-5s %-25s %-20s %-20s\n", id, name, country_id, last_update);
            }
        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
    }
    public  void connectDB(){
        try{
            con = DriverManager.getConnection(connection.getJdbc(),connection.getUsername(),connection.getPassword());
            System.out.println("Conexion exitosa");

        }catch (SQLException ex){
            System.out.println("Error "+ex.getMessage());
        }
    }
    public void closeConnection() {

        try {
            con.close();
            System.out.println("Conexion Cerrada");

        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }
}
