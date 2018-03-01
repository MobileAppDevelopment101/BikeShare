package com.coffeeio.bikeshare;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgapc on 20/02/2018.
 */

public class RidesDB {
    private static RidesDB sRidesDB;

    public static RidesDB get(Context context) {
        if (sRidesDB == null) { sRidesDB = new RidesDB(context); }
        return sRidesDB;
    }

    private ArrayList<Ride> mallRides;

    private Ride mlastRide= new Ride("", "");

    public List<Ride> getRidesDB() {return mallRides; }

    public void addRide(String what, String where) {
        mallRides.add(new Ride(what, where));
    }

    public void endRide(String what, String where) {

    }

    private RidesDB(Context context) {
        mallRides= new ArrayList<>();
        // Add some rides for testing purposes
        mallRides.add(new Ride("Peters bike", "ITU", "Fields"));
        mallRides.add(new Ride("Peters bike", "Fields", "Kongens Nytorv"));
        mallRides.add(new Ride("Jørgens bike", "Home", "ITU"));
    }
}