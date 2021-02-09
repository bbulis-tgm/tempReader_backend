package com.bulis.temp.backend.model;

import com.bulis.temp.backend.helper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Controller handls incoming requests
 * Handls receiving data and sending data if requested
 *
 * @author Benjamin Bulis
 * @version V1.3
 */
@RestController
@RequestMapping(path = "/sensors")
public class TemperatureController {

    @Autowired
    private TemperatureRepository temperatureRepository;

    /**
     * Method return all temperature and sensor data
     *
     * @return returns data from repository (data of sensors as array)
     */
    @GetMapping("/findAll")
    public Response temperature() {
        Iterable<Temperature> temperatures = temperatureRepository.findAll();
        if (!temperatures.iterator().hasNext()) {
            return new Response(false, new ResponseError("database", "no data found"));
        }
        return new Response(true, temperatures);
    }

    /**
     * Method returns all temperature data from a requested date
     *
     * @return data from specific date
     */
    @GetMapping("/findByDate")
    public Response findTemperatureByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
        Iterable<Temperature> temperatures = temperatureRepository.findByDate(dateTime);
        if (!temperatures.iterator().hasNext()) {
            return new Response(false, new ResponseError("database", "no data found"));
        }
        return new Response(true, temperatures);
    }

    /**
     * Method returns current temperature of the measured area
     * Temperature sensors measure every 2 minutes
     * Current Temperature is the average of the last 3 measurements
     *
     * @return the response with the requested value
     */
    /*@GetMapping("/findCurrent")
    public Response findCurrentTemperature() {
        Iterable<Temperature> temperatures = temperatureRepository.findBySensor();
        if (!temperatures.iterator().hasNext()) {
            return new Response(false, new ResponseError("database", "no data found"));
        }
        return new Response(true, temperatures);
    }*/

    /**
     * Methode returns all sensors find in database
     *
     * @return the response including all sensors
     */
    @GetMapping("/findAllSensors")
    public Response findAllSensors() {
        Iterable<String> sensors = temperatureRepository.findAllSensors();
        if (!sensors.iterator().hasNext()) {
            return new Response(false, new ResponseError("database", "no sensors found"));
        }
        return new Response(true, sensors);
    }

    /**
     * method for adding data to the database
     *
     * @param addTemperatureRequestBody RequestBody structur
     * @return response with confirmation data
     */
    @PostMapping("/add")
    public @ResponseStatus(HttpStatus.CREATED) Response addTemperature(@RequestBody AddTemperatureRequestBody addTemperatureRequestBody) {
        try {
            Temperature temperature = new Temperature();
            temperature.setTemp(addTemperatureRequestBody.getTemp());
            temperature.setDate(LocalDateTime.now());
            temperature.setSensor(addTemperatureRequestBody.getSensor());
            Temperature temperatureSaved = temperatureRepository.save(temperature);
            return new Response(true, "saved");
        } catch (Exception e) {
            return new Response(false, new ResponseError("database", "error when saving to database"));
        }
    }

}
