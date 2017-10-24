package com.example.sidkathuria14.mapsclone.models.models_geolocation;

/**
 * Created by sidkathuria14 on 18/10/17.
 */

public class CellTowers{
    int cellId,locationAreaCode,mobileCountryCode,mobileNetworkCode,age,signalStrength,timingAdvance;

    public int getCellId() {
        return cellId;
    }

    public int getLocationAreaCode() {
        return locationAreaCode;
    }

    public int getMobileCountryCode() {
        return mobileCountryCode;
    }

    public int getMobileNetworkCode() {
        return mobileNetworkCode;
    }

    public int getAge() {
        return age;
    }

    public int getSignalStrength() {
        return signalStrength;
    }

    public int getTimingAdvance() {
        return timingAdvance;
    }

//    public CellTowers(int cellId, int locationAreaCode, int mobileCountryCode, int mobileNetworkCode, int age, int signalStrength, int timingAdvance) {
//        this.cellId = cellId;
//        this.locationAreaCode = locationAreaCode;
//        this.mobileCountryCode = mobileCountryCode;
//        this.mobileNetworkCode = mobileNetworkCode;
//        this.age = age;
//        this.signalStrength = signalStrength;
//        this.timingAdvance = timingAdvance;
//    }
}