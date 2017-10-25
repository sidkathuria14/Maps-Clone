package com.example.sidkathuria14.mapsclone.models.models_geolocation;

import java.util.ArrayList;

/**
 * Created by sidkathuria14 on 18/10/17.
 */

public class main_geolocation {
   int homeMobileCountryCode,homeMobileNetworkCode;
            String radioType,carrier,considerIp;

   ArrayList<CellTowers> cellTowers;
    ArrayList<WifiAccessPoints> wifiAccessPoints;

//    public main_geolocation(int homeMobileCountryCode, int homeMobileNetworkCode,
//                            String radioType,
//                            String carrier, String considerIp,
//                            CellTowers cellTowers,
//                            WifiAccessPoints wifiAccessPoints) {
//        this.homeMobileCountryCode = homeMobileCountryCode;
//        this.homeMobileNetworkCode = homeMobileNetworkCode;
//        this.radioType = radioType;
//        this.carrier = carrier;
//        this.considerIp = considerIp;
//        this.cellTowers = cellTowers;
//        this.wifiAccessPoints = wifiAccessPoints;
//    }


    public ArrayList<CellTowers> getCellTowers() {
        return cellTowers;
    }

    public ArrayList<WifiAccessPoints> getWifiAccessPoints() {
        return wifiAccessPoints;
    }

    public int getHomeMobileCountryCode() {
        return homeMobileCountryCode;
    }

    public int getHomeMobileNetworkCode() {
        return homeMobileNetworkCode;
    }

    public String getRadioType() {
        return radioType;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getConsiderIp() {
        return considerIp;
    }

}

