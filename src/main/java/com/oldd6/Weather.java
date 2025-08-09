package com.oldd6;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Weather {
    @Id
    String date;
    int temp;
    int wind;
    String air;

    Weather(String d, int t, int w, String a){
        date = d; temp = t; wind = w; air = a;
    }

    public String getDate() {
        return date;
    }

    public int getTemp() {
        return temp;
    }

    public int getWind() {
        return wind;
    }

    public String getAir() {
        return air;
    }

    Weather(){}
}
