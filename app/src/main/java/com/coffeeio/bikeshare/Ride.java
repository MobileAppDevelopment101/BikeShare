package com.coffeeio.bikeshare;

/**
 * Created by MGApcDev on 02-02-2018.
 */

public class Ride {
    private String mbikeName;
    private String mstartRide;
    public Ride(String name, String start) {
        mbikeName= name;
        mstartRide= start;
    }
    public String getMbikeName() {return mbikeName; }
    public void setMbikeName(String mbikeName) {
        this.mbikeName = mbikeName;
    }
    public String getMstartRide() { return mstartRide; }
    public void setMstartRide(String mstartRide) {
        this.mstartRide = mstartRide;
    }
    public String toString() { return mbikeName+" started here: " + mstartRide ; }
}
