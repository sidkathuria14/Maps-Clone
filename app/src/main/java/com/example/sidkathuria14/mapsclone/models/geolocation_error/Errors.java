package com.example.sidkathuria14.mapsclone.models.geolocation_error;

import java.util.ArrayList;

/**
 * Created by sidkathuria14 on 20/10/17.
 */

public class Errors {
    ArrayList<ObjectError> errors;
    int code;
    String message;


    public ArrayList<ObjectError> getErrors() {
        return errors;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
