package com.amanna;

public class Main {
    public static void main(String[] args) {

        WeatherApi weatherApi = new RealWeatherApi();
        WeatherService weatherService = new WeatherService(weatherApi);

        System.out.println(weatherService.getWeather("Delhi"));

    }
}