package com.example.sidkathuria14.mapsclone.models.directions;

import com.google.android.gms.maps.model.Polyline;


/**
 * Created by sidkathuria14 on 26/10/17.
 */

public class Steps {
    Distance distance;
    Duration duration;
LatLng end_location;
    String html_instrcutions;
    Polyline polyline;
    String travel_mode;
   LatLng start_location;
    String maneuver;

    public String getManeuver() {
        return maneuver;
    }

    public Distance getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public LatLng getEnd_location() {
        return end_location;
    }

    public String getHtml_instrcutions() {
        return html_instrcutions;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public String getTravel_mode() {
        return travel_mode;
    }

    public LatLng getStart_location() {
        return start_location;
    }
}
