package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return  countryRepository.findAll();
    }

    //Spring Data JPA
    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    // Using Hibernate
    public String addCountryHibernate(Country country) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(country);

            tx.commit();
        } catch (HibernateException e) {
            if(tx!= null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return "Addded in Database " + country;
    }
}
