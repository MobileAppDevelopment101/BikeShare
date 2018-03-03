package com.coffeeio.bikeshare;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

    private ArrayList<Ride> ridesFinished;
    private HashMap<String, Ride> ridesInProgress;

    private Ride mlastRide= new Ride("", "");

    public List<Ride> getRidesDB() {
        List<Ride> r1 = getFinishedRides();
        List<Ride> r2 = getUnfinisedRides();
        r2.addAll(r1); // Append finished onto unfinished, so unfinished is displayed first.
        return r2;
    }

    public List<Ride> getFinishedRides() {
        return ridesFinished;
    }
    public List<Ride> getUnfinisedRides() {
        // Convert map to list. http://javaconceptoftheday.com/how-to-convert-hashmap-to-arraylist-in-java/
        Collection<Ride> values = ridesInProgress.values();
        ArrayList<Ride> listOfValues = new ArrayList<>(values);
        return listOfValues;
    }

    public void addRide(String what, String where) {
        ridesInProgress.put(what, new Ride(what, where));
    }
    public void addRide(Ride ride) {
        ridesInProgress.put(ride.getmBikeName(), new Ride(ride.getmBikeName(), ride.getmStartRide()));
    }

    public Ride endRide(String what, String where) {
        if (ridesInProgress.containsKey(what)) {
            Ride r = ridesInProgress.get(what); // Constant time operation.
            r.setmEndRide(where);
            ridesFinished.add(r);
            ridesInProgress.remove(what);
            return r;
        }

        return null;
    }

    private RidesDB(Context context) {
        ridesInProgress = new HashMap<>();
        ridesFinished = new ArrayList<>();

        // Add some rides for testing purposes
        ridesFinished.add(new Ride("Peters bike", "ITU", "Fields"));
        ridesInProgress.put("Peters bike" ,new Ride("Peters bike", "Fields"));
        ridesFinished.add(new Ride("Jørgens bike", "Home", "ITU"));
    }
}
