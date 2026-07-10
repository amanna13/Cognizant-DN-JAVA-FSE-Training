package com.cognizant.springjpaqueries;

import com.cognizant.springjpaqueries.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class SpringJpaQueriesApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringJpaQueriesApplication.class);
    private static StockService stockService;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringJpaQueriesApplication.class, args);
        stockService = applicationContext.getBean(StockService.class);
    }

    public static void testQueryMethods() {
        logger.info("Start");
        logger.debug("getStocksByCodeAndDateRange - {}", stockService.getStocksByCodeAndDateRange("FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30)));
        logger.debug("getStocksByClosingPriceGreaterThan - {}", stockService.getStocksByClosingPriceGreaterThan("GOOGL", new BigDecimal("1250")));
        logger.debug("getTopThreeHighestVolumeStocks - {}", stockService.getTopThreeHighestVolumeStocks());
        logger.debug("getLowestThreeClosingPrices - {}", stockService.getLowestThreeClosingPrices("NFLX"));
        logger.info("End");
    }

}
