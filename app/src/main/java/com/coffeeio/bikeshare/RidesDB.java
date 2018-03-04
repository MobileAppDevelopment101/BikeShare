package com.coffeeio.bikeshare;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mgapc on 20/02/2018.
 */

public class RidesDB {
    private static RidesDB sRidesDB;
    private ArrayList<Ride> ridesFinished;
    private HashMap<String, Ride> ridesInProgress;

    private RidesDB(Context context) {
        clearRides();
    }
    private RidesDB() {
        clearRides();
    }

    public static RidesDB get() {
        if (sRidesDB == null) { sRidesDB = new RidesDB(); }
        return sRidesDB;
    }

    public static RidesDB get(Context context) {
        if (sRidesDB == null) { sRidesDB = new RidesDB(context); }
        return sRidesDB;
    }

    public List<Ride> getRidesDB() {
        List<Ride> r1 = getFinishedRides();
        List<Ride> r2 = getUnfinishedRides();
        Collections.reverse(r1); // Newly finished rides first
        r2.addAll(r1); // Append finished onto unfinished, so unfinished is displayed first.
        return r2;
    }

    public List<Ride> getFinishedRides() {
        return ridesFinished;
    }

    public List<Ride> getUnfinishedRides() {
        // Convert map to list. http://javaconceptoftheday.com/how-to-convert-hashmap-to-arraylist-in-java/
        Collection<Ride> values = ridesInProgress.values();
        ArrayList<Ride> listOfValues = new ArrayList<>(values);
        return listOfValues;
    }

    public Ride addRide(String what, String where) {
        if (ridesInProgress.containsKey(what)) {
            return null;
        }
        ridesInProgress.put(what, new Ride(what, where));

        return new Ride(what, where);
    }

    public Ride addRide(Ride ride) {
       return addRide(ride.getmBikeName(), ride.getmStartRide());
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

    public void clearRides() {
        ridesInProgress = new HashMap<>();
        ridesFinished = new ArrayList<>();
    }
}
