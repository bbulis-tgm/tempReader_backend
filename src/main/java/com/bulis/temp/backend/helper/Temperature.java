package com.bulis.temp.backend.helper;

public class Temperature {

    public final long id;
    public final double temp;
    public final String date;

    public Temperature (long id, double temp, String date) {
        this.id = id;
        this.temp = temp;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public double getTemp() {
        return temp;
    }

    public String getDate() {
        return date;
    }
}
