package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringDataJPA {

    private static final Logger logger = LoggerFactory.getLogger(SpringDataJPA.class);
    private static CountryService countryService;

    public static void main(String[] args) throws CountryNotFoundException {
        ApplicationContext applicationContext = SpringApplication.run(SpringDataJPA.class, args);
        countryService = applicationContext.getBean(CountryService.class);
        logger.info("Inside Main");

        getAllCountries();
    }
    private static void testAllCountries() {
        logger.info("Start");
        List<Country> countries = countryService.getAllCountries();
        logger.debug("counties = {}", countries);

        Country country = new Country();
        country.setCode("AU");
        country.setName("AUSTRALIA");

        //Add country using hibernate
//        logger.debug("Country Added - {} ", countryService.addCountryHibernate(country));

        //Using SpringDataJPA
        logger.debug("Country Added using SpringDataJPA - {}", countryService.addCountry(country));
        logger.info("End");
    }

    private static  void getAllCountries() throws CountryNotFoundException {
        logger.info("Start");
        Country country = countryService.findCountryByCode("XC");
        logger.debug("Country: {}", country);
        logger.info("End");
    }
}