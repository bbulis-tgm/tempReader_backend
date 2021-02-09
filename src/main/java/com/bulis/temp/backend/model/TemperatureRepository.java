package com.bulis.temp.backend.model;

import com.bulis.temp.backend.helper.Temperature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {
    Iterable<Temperature> findByDate(LocalDateTime date);

    @Query("SELECT DISTINCT sensor FROM Temperature")
    Iterable<String> findAllSensors();
}
