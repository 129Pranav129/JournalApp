package com.pranav.journalApp.service;

import com.pranav.journalApp.api.Response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String API_KEY;
    @Value("${weather.api.url}")
    private String API;

    @Autowired
    RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String final_API = API.replace("CITY_NAME", city).replace("API_KEY", API_KEY);

        return restTemplate.exchange(final_API, HttpMethod.GET, null, WeatherResponse.class).getBody();
    }
}
