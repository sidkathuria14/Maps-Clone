package com.example.sidkathuria14.mapsclone.models.models_geolocation;

/**
 * Created by sidkathuria14 on 18/10/17.
 */

public class WifiAccessPoints{

    String macAddress;
    int signalStrength;
    int age,channel;
    int signalToNoiseRatio;

//    public WifiAccessPoints(String macAddress, int signalStrength, int age, int channel, int signalToNoiseRatio) {
//        this.macAddress = macAddress;
//        this.signalStrength = signalStrength;
//        this.age = age;
//        this.channel = channel;
//        this.signalToNoiseRatio = signalToNoiseRatio;
//    }

    public String getMacAddress() {
        return macAddress;
    }

    public int getSignalStrength() {
        return signalStrength;
    }

    public int getAge() {
        return age;
    }

    public int getChannel() {
        return channel;
    }

    public int getSignalToNoiseRatio() {
        return signalToNoiseRatio;
    }
}