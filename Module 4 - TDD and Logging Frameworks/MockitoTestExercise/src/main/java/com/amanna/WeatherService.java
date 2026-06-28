package com.amanna;

public class WeatherService {

    private WeatherApi weatherApi;

    WeatherService(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }


    public String getWeather(String city) {
        return weatherApi.weather(city);
    }

}
