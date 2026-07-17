package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CountryService {

    ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

    public Country getCountryIndia() {
        Country country = context.getBean("india", Country.class);
        return country;
    }

    public Country getCountryByCountryCode(String code) {
        Map<String, Country> countries = context.getBeansOfType(Country.class);
        List<Country> countriesList = countries.values().stream().toList();

        return countriesList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findAny().orElse(null);
    }
}
