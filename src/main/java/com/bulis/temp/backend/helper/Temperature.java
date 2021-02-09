package com.bulis.temp.backend.helper;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Database structur with all arguments to save in database
 *
 * @author Benjamin Bulis
 * @version V1.1
 */
@Entity
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private double temp;
    @Column(nullable = false)
    private LocalDateTime date;
    @Column(nullable = false)
    private String sensor;

    public long getId() {
        return id;
    }

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
