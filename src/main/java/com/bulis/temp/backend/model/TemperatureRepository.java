package com.bulis.temp.backend.model;

import com.bulis.temp.backend.helper.Temperature;
import org.springframework.data.repository.CrudRepository;

public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {
    Iterable<Temperature> findByDate(String date);
}
