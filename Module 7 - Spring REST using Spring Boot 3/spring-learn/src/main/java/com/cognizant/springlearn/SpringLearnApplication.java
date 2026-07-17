package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);

        logger.info("Spring Web Project Started");

        //Load Country from Spring Configuration XML
        displayCountry();
    }

    public static void displayCountry() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");
        Country country = applicationContext.getBean("india", Country.class);

        logger.debug("Country - {}", country.toString());
    }

}
