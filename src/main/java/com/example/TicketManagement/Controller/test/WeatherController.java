package com.example.TicketManagement.Controller.test;

import com.example.TicketManagement.Service.Impl.WeatherService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<Object> getWeather(@PathVariable String city){
        Object weatherData = weatherService.getWeatherForCity(city);
        return ResponseEntity.ok(weatherData);
    }
}
