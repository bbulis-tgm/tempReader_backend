package com.bulis.temp.backend.model;

import com.bulis.temp.backend.helper.Response;
import com.bulis.temp.backend.helper.ResponseDetails;
import com.bulis.temp.backend.helper.ResponseError;
import com.bulis.temp.backend.helper.Temperature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TeperatureController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/temperature")
    public Response temperature() {
        return new Response(true, new ResponseDetails(new Temperature(counter.incrementAndGet(), 0.0, new Date().toString())));
    }


    @PostMapping("/temperature")
    public String addTemperature() {
        return "";
    }

}
