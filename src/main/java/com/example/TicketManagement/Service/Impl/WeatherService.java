package com.example.TicketManagement.Service.Impl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value("${rapidapi.weather.url}")
    private String apiUrl;

    @Value("${rapidapi.host}")
    private String apiHost;

    @Value("${rapidapi.key}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Object getWeatherForCity(String city){
        String url = apiUrl + city;

        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", apiHost);


        HttpEntity<String> entity = new HttpEntity<>(headers);

        try{
            ResponseEntity<Object> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    Object.class
            );
            return response.getBody();
        }catch (Exception e){
            throw new RuntimeException("Error fetching weather data: " + e.getMessage());
        }
    }
}
