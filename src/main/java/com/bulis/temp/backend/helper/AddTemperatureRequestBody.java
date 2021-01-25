package com.bulis.temp.backend.helper;

/**
 * File is needed because Spring only Supports one RequestBody argument
 * This file is the structur of the request for adding data to the database
 *
 * @author Benjamin Bulis
 * @version V1.0
 */
public class AddTemperatureRequestBody {

    private double temp;
    private String date;
    private String sensor;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }
}
