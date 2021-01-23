package com.bulis.temp.backend.model;

import com.bulis.temp.backend.helper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Controller handls incoming requests
 * Handls receiving data and sending data if requested
 *
 * @author Benjamin Bulis
 * @version V1.1
 */
@RestController
@RequestMapping(path = "/sensors")
public class TeperatureController {

    @Autowired
    private TemperatureReposiroty temperatureReposiroty;

    /**
     * Method return all temperature and sensor data
     *
     * @return returns data from repository (data of sensors as array)
     */
    @GetMapping("/all")
    public Response temperature() {
        return new Response(true, temperatureReposiroty.findAll());
    }


    /**
     * method for adding data to the database
     *
     * @param addTemperatureRequest RequestBody structur
     * @return response with confirmation data
     */
    @PostMapping("/add")
    public @ResponseStatus(HttpStatus.CREATED) Response addTemperature(@RequestBody AddTemperatureRequest addTemperatureRequest) {
        try {
            Temperature temperature = new Temperature();
            temperature.setTemp(addTemperatureRequest.getTemp());
            temperature.setDate(addTemperatureRequest.getDate());
            temperature.setSensor(addTemperatureRequest.getSensor());
            Temperature temperatureSaved = temperatureReposiroty.save(temperature);
            return new Response(true, "saved");
        } catch (Exception e) {
            return new Response(false, new ResponseError("database", "error when saving to database"));
        }
    }

}
