package org.example;

import org.example.Controller.*;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ControllerDB controllerDB = new ControllerDB();
        ControllerCity controllerCity = new ControllerCity();
        ControllerCountry controllerCountry = new ControllerCountry();
        ControllerFilm controllerFilm = new ControllerFilm();
        ControllerActor controllerActor = new ControllerActor();

        Connection con = controllerDB.connectDB();


        controllerCity.showCityInfo(controllerCity.getOneHundredCities(con));

        controllerCountry.showCountryInfo(controllerCountry.getCountry(con));

        controllerFilm.showFilm(controllerFilm.getPrimerosCincuentaFilms(con));

        controllerActor.showActor(controllerActor.getcincuentaActors(con));

        controllerDB.closeConnection();
    }
}