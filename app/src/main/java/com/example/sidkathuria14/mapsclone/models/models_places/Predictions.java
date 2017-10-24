package com.example.sidkathuria14.mapsclone.models.models_places;

import java.util.ArrayList;

/**
 * Created by sidkathuria14 on 19/10/17.
 */

public class Predictions {
    String description;
    String id;
   Matched_Substrings[] matched_substrings;
    String place_id;
    String reference;
    Terms[] terms;
    String[] types;

    public String getDescription() {
        return description;
    }


    public Matched_Substrings[] getMatched_substrings() {
        return matched_substrings;
    }

    public String getId() {
        return id;
    }


    public String getPlace_id() {
        return place_id;
    }

    public String getReference() {
        return reference;
    }


    public Terms[] getTerms() {
        return terms;
    }

    public String[] getTypes() {
        return types;
    }
}
