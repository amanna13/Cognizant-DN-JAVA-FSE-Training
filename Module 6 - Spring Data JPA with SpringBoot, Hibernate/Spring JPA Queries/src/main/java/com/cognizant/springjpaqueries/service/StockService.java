package com.cognizant.springjpaqueries.service;

import com.cognizant.springjpaqueries.model.Stock;
import com.cognizant.springjpaqueries.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    /**
     * Returns all Facebook stocks between two dates.
     */
    @Transactional
    public List<Stock> getStocksByCodeAndDateRange(String code, LocalDate startDate, LocalDate endDate) {
        return stockRepository.findByCodeAndDateBetween(code, startDate, endDate);
    }

    /**
     * Returns stocks whose closing price is greater than the given price.
     */
    @Transactional
    public List<Stock> getStocksByClosingPriceGreaterThan(String code, BigDecimal price) {
        return stockRepository.findByCodeAndCloseGreaterThan(code, price);
    }

    /**
     * Returns the top 3 highest volume transactions.
     */
    @Transactional
    public List<Stock> getTopThreeHighestVolumeStocks() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    /**
     * Returns the lowest three closing prices for a stock.
     */
    @Transactional
    public List<Stock> getLowestThreeClosingPrices(String code) {
        return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
    }
}