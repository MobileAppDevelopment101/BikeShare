package com.coffeeio.bikeshare;

/**
 * Created by MGApcDev on 02-02-2018.
 */

public class Ride {
    private String mBikeName, mStartRide, mEndRide;

    public Ride(String name, String start) {
        mBikeName = name;
        mStartRide = start;
    }
    public Ride(String name, String start, String end) {
        mBikeName = name;
        mStartRide = start;
        mEndRide = end;
    }
    public String getMbikeName() {return mBikeName; }

    public void setMbikeName(String mbikeName) {
        this.mBikeName= mbikeName;
    }

    public String getMstartRide() { return mStartRide; }

    public void setMstartRide(String mStartRide) {
        this.mStartRide = mStartRide;
    }

    public String toString() { return mBikeName + " started here: " + mBikeName; }
}
