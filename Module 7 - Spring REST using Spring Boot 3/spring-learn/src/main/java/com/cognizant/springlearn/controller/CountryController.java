package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    @GetMapping
    public ResponseEntity<Country> getCountryIndia() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");
        Country country = applicationContext.getBean("country", Country.class);

        return ResponseEntity.status(HttpStatus.OK).body(country);
    }
}
