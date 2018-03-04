package com.coffeeio.bikeshare;

/**
 * Created by MGApcDev on 02-02-2018.
 */

public class Ride {
    private String mBikeName, mStartRide, mEndRide = null;
    public Ride(String name, String start) {
        mBikeName = name;
        mStartRide = start;
    }

    public Ride(String name, String start, String end) {
        mBikeName = name;
        mStartRide = start;
        mEndRide = end;
    }

    public String getmBikeName() {
        return mBikeName;
    }

    public void setmBikeName(String mBikeName) {
        this.mBikeName = mBikeName;
    }

    public String getmStartRide() {
        return mStartRide;
    }

    public void setmStartRide(String mStartRide) {
        this.mStartRide = mStartRide;
    }

    public String getmEndRide() {
        return mEndRide;
    }

    public void setmEndRide(String mEndRide) {
        this.mEndRide = mEndRide;
    }

    public String toString() {
        if (mEndRide != null) {
            return mBikeName + " started here: " + mStartRide + ", ended here: " + mEndRide;
        }

        return mBikeName + " started here: " + mStartRide;
    }
}
