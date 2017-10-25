package com.example.sidkathuria14.mapsclone.models.directions;


import com.google.maps.android.geometry.Bounds;

/**
 * Created by sidkathuria14 on 26/10/17.
 */

public class Routes {
    Bounds bounds;
    String copyrights;
    Steps[] legs;

    public Bounds getBounds() {
        return bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public Steps[] getLegs() {
        return legs;
    }
}
