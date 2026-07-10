package com.cognizant.springjpaqueries.repository;

import com.cognizant.springjpaqueries.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameContaining(String name);

    List<Country> findByNameContainingOrderByNameAsc(String name);

    List<Country> findByNameStartingWith(String name);
}
