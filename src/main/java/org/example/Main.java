package org.example;

import org.example.Controller.ControllerCity;
import org.example.Controller.ControllerDB;
import org.example.Controller.ControllerCountry;

public class Main {
    public static void main(String[] args) {
        ControllerDB controllerDB = new ControllerDB();
        ControllerCity controllerCity = new ControllerCity();
        controllerDB.connectDB();
        controllerDB.closeConnection();


        controllerCity.connectDB();
        controllerCity.showCityInfo(controllerCity.getOneHundredCities());
        controllerCity.closeConnection();

        ControllerCountry controllerCountry = new ControllerCountry();

        controllerCountry.connectDB();
        controllerCountry.showCountryInfo(controllerCountry.getCountry());
        controllerCountry.closeConnection();


    }
}