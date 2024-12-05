package org.example;

import org.example.Controller.*;

public class Main {
    public static void main(String[] args) {
        ControllerDB controllerDB = new ControllerDB();
        ControllerCity controllerCity = new ControllerCity();
        ControllerCountry controllerCountry = new ControllerCountry();

        controllerDB.connectDB();
        controllerDB.closeConnection();


        controllerCity.connectDB();
        controllerCity.showCityInfo(controllerCity.getOneHundredCities());
        controllerCity.closeConnection();


        controllerCountry.connectDB();
        controllerCountry.showCountryInfo(controllerCountry.getCountry());
        controllerCountry.closeConnection();

        ControllerFilm controllerFilm = new ControllerFilm();

        controllerFilm.connectDB();
        controllerFilm.showFilm(controllerFilm.getFilm());
        controllerFilm.closeDB();

        ControllerActor controllerActor = new ControllerActor();
        controllerActor.connectDB();
        controllerActor.showActor(controllerActor.getActor());
        controllerActor.closeDB();

    }
}