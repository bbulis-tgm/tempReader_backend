package com.bulis.temp.backend.model;

import com.bulis.temp.backend.helper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Controller handls incoming requests
 * Handls receiving data and sending data if requested
 *
 * @author Benjamin Bulis
 * @version V1.2
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
    @GetMapping("/findAll")
    public Response temperature() {
        ArrayList<Temperature> temperatures = (ArrayList<Temperature>) temperatureReposiroty.findAll();
        if (temperatures.isEmpty()) {
            return new Response(false, "no data found");
        }
        return new Response(true, temperatureReposiroty.findAll());
    }

    /**
     * Method returns all temperature data from a requested date
     *
     * @return data from specific date
     */
    @GetMapping("/findByDate")
    public Response findTemperatureByDate(@RequestBody FindTemperatureByDateRequestBody findTemperatureByDateRequestBody) {
        ArrayList<Temperature> returnTemperature = new ArrayList<>();
        ArrayList<Temperature> temperatures = (ArrayList<Temperature>) temperatureReposiroty.findAll();
        for (Temperature item : temperatures) {
            if (item.getDate().equals(findTemperatureByDateRequestBody.getDate())) {
                returnTemperature.add(item);
            }
        }
        if (returnTemperature.isEmpty()) {
            return new Response(false, "no data found");
        }
        return new Response(true, returnTemperature);
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
            Temperature temperatureSaved = temperatureReposiroty.save(temperature);
            return new Response(true, "saved");
        } catch (Exception e) {
            return new Response(false, new ResponseError("database", "error when saving to database"));
        }
    }

}
