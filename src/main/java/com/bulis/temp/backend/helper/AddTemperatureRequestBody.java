package com.bulis.temp.backend.helper;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * File is needed because Spring only Supports one RequestBody argument
 * This file is the structur of the request for adding data to the database
 *
 * @author Benjamin Bulis
 * @version V1.0
 */
public class AddTemperatureRequestBody {

    private double temp;
    private LocalDateTime date;
    private String sensor;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }
}
