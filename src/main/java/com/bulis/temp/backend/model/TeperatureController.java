package com.bulis.temp.backend.model;

import com.bulis.temp.backend.helper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = "/sensors")
public class TeperatureController {

    @Autowired
    private TemperatureReposiroty temperatureReposiroty;

    @GetMapping("/all")
    public Response temperature() {
        return new Response(true, temperatureReposiroty.findAll());
    }


    @PostMapping("/add")
    public @ResponseStatus(HttpStatus.CREATED) Response addTemperature(@RequestBody AddTemperatureRequest addTemperatureRequest) {
        Temperature temperature = new Temperature();
        temperature.setTemp(addTemperatureRequest.getTemp());
        temperature.setDate(addTemperatureRequest.getDate());
        temperature.setSensor(addTemperatureRequest.getSensor());

        temperatureReposiroty.save(temperature);
        return new Response(true, "saved");
    }

}
