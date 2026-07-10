package com.cognizant.springjpaqueries.service;


import com.cognizant.springjpaqueries.model.Country;
import com.cognizant.springjpaqueries.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    public CountryRepository countryRepository;

    @Transactional
    public List<Country> searchCountry(String text) {
        return countryRepository.findByNameContaining(text);
    }

    @Transactional
    public List<Country> searchCountriesSorted(String text) {
        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }

    @Transactional
    public List<Country> getCountriesStartingWith(String text) {
        return countryRepository.findByNameStartingWith(text);
    }


}
