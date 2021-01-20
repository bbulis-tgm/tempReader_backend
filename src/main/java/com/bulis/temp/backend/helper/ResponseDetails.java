package com.bulis.temp.backend.helper;

public class ResponseDetails {

    private final Temperature temperature;

    public ResponseDetails(Temperature temperature) {
        this.temperature = temperature;
    }

    public Temperature getTemperature() {
        return temperature;
    }
}
