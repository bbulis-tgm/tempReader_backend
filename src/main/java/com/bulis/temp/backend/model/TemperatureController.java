package com.bulis.temp.backend.model;

import com.bulis.temp.backend.helper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller handls incoming requests
 * Handls receiving data and sending data if requested
 *
 * @author Benjamin Bulis
 * @version V1.2
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
            return new Response(false, "no data found");
        }
        return new Response(true, temperatures);
    }

    /**
     * Method returns all temperature data from a requested date
     *
     * @return data from specific date
     */
    @GetMapping("/findByDate")
    public Response findTemperatureByDate(@RequestBody FindTemperatureByDateRequestBody body) {
        Iterable<Temperature> temperatures = temperatureRepository.findByDate(body.getDate());
        if (!temperatures.iterator().hasNext()) {
            return new Response(false, "no data found");
        }
        return new Response(true, temperatures);
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
            temperature.setDate(addTemperatureRequestBody.getDate());
            temperature.setSensor(addTemperatureRequestBody.getSensor());
            Temperature temperatureSaved = temperatureRepository.save(temperature);
            return new Response(true, "saved");
        } catch (Exception e) {
            return new Response(false, new ResponseError("database", "error when saving to database"));
        }
    }

}
