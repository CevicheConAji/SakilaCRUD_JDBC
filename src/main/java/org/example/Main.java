package org.example;

import org.example.Controller.*;
import org.example.DB.ConnectDB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ControllerDB controllerDB = new ControllerDB();
        Connection con = controllerDB.connectDB();

        ControllerCity controllerCity = new ControllerCity();
        ControllerCountry controllerCountry = new ControllerCountry();
        ControllerFilm controllerFilm = new ControllerFilm();
        ControllerActor controllerActor = new ControllerActor();


        controllerCity.showCityInfo(controllerCity.getOneHundredCities(con));

        controllerCountry.showCountryInfo(controllerCountry.getCountry(con));

        controllerFilm.showFilm(controllerFilm.getPrimerosCincuentaFilms(con));

        controllerActor.showActor(controllerActor.getcincuentaActors(con));

        controllerDB.closeConnection();
    }
}