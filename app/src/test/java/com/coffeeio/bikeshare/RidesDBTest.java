package com.coffeeio.bikeshare;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RidesDBTest {
    @Before
    public void clearRides() {
        RidesDB db = RidesDB.get();
        db.clearRides();
    }

    @Test
    public void basicRideStartEnd() throws Exception {
        RidesDB db = RidesDB.get();

        assertEquals(0, db.getRidesDB().size());
        db.addRide(new Ride("Bike 1", "Start 1"));
        assertEquals(1, db.getRidesDB().size());
        db.endRide("Bike 1", "End 1");
        assertEquals(1, db.getRidesDB().size());
    }

    @Test
    public void avoidDupRides() throws Exception {
        RidesDB db = RidesDB.get();

        db.addRide(new Ride("Bike 1", "Start 1"));
        assertEquals(1, db.getRidesDB().size());
        db.addRide(new Ride("Bike 1", "Start 2"));
        assertEquals(1, db.getRidesDB().size());

        db.addRide(new Ride("Bike 2", "Start 1"));
        assertEquals(2, db.getRidesDB().size());
    }

    @Test
    public void endStartedRides() throws Exception {
        RidesDB db = RidesDB.get();

        db.endRide("Bike 1", "Start 1");
        assertEquals(0, db.getRidesDB().size());
    }

    @Test
    public void orderRides() throws Exception {
        RidesDB db = RidesDB.get();

        db.addRide(new Ride("Bike 1", "Start 1"));
        db.addRide(new Ride("Bike 2", "Start 1"));
        db.addRide(new Ride("Bike 3", "Start 1"));

        db.endRide("Bike 2", "Start 1");

        List<Ride> list = db.getRidesDB();

        assertEquals("Bike 1", list.get(0).getmBikeName());
        assertEquals("Bike 3", list.get(1).getmBikeName());
        assertEquals("Bike 2", list.get(2).getmBikeName()); // Ended rides first
    }
}