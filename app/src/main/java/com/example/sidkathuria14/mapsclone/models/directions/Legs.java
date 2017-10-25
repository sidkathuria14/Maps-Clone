package com.example.sidkathuria14.mapsclone.models.directions;

/**
 * Created by sidkathuria14 on 26/10/17.
 */

public class Legs {
    Distance distance;
    Duration duration;
    String end_address;
LatLng end_location;
    String start_address;
    LatLng start_location;

    public Distance getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getEnd_address() {
        return end_address;
    }

    public LatLng getEnd_location() {
        return end_location;
    }

    public String getStart_address() {
        return start_address;
    }

    public LatLng getStart_location() {
        return start_location;
    }
}
