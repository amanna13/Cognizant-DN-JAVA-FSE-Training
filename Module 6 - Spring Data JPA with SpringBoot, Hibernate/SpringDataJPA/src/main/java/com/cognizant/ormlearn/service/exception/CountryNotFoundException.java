package com.cognizant.ormlearn.service.exception;

import com.cognizant.ormlearn.model.Country;

public class CountryNotFoundException extends Exception{

    public CountryNotFoundException(String message) {
        super(message);
    }
}
