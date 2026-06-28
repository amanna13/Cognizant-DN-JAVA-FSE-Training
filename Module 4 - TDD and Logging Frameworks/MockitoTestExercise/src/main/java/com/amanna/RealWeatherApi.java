package com.amanna;

public class RealWeatherApi implements WeatherApi{
    @Override
    public String weather(String city) {
        return "Sunny";
    }
}
