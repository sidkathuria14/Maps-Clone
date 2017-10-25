package com.example.sidkathuria14.mapsclone.models.directions;

import java.sql.Types;

/**
 * Created by sidkathuria14 on 26/10/17.
 */

public class Geocoded_waypoints {
String geocoder_status;
    String place_id;
    String[] types;

    public String getGeocoder_status() {
        return geocoder_status;
    }

    public String getPlace_id() {
        return place_id;
    }

    public String[] getTypes() {
        return types;
    }
}
