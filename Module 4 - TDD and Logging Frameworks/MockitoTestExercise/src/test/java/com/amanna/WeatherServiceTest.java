package com.amanna;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

class WeatherServiceTest {

    @Test
    void testWeatherService() {

        WeatherApi weatherApi = Mockito.mock(WeatherApi.class);
        Mockito.when(weatherApi.weather("Delhi")).thenReturn("Sunny");
        WeatherService weatherService  = new WeatherService(weatherApi);

        String result = weatherService.getWeather("Delhi");

        Assertions.assertEquals("Sunny", result);
        Mockito.verify(weatherApi).weather("Delhi");
    }

    /**
     * Spy in Mockito
     */

//    @Test
//    void testWeatherService2() {
//
//        WeatherApi realWeatherApi = new RealWeatherApi();
//        WeatherApi weatherApi = Mockito.spy(realWeatherApi);
//        Mockito.doReturn("Rainy").when(weatherApi).weather("Delhi");
//
//        WeatherService weatherService = new WeatherService(weatherApi);
//
//        String result = weatherService.getWeather("Delhi");
//
//        Assertions.assertEquals("Rainy", result);
//        Mockito.verify(weatherApi).weather("Delhi");
//    }

}