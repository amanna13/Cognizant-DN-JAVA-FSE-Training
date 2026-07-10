package com.cognizant.springjpaqueries.repository;

import com.cognizant.springjpaqueries.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByCodeAndDateBetween(String code, LocalDate dateAfter, LocalDate dateBefore);

    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal closeIsGreaterThan);

    List<Stock> findTop3ByOrderByVolumeDesc();

    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
 }
