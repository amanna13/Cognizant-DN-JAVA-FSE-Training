package com.amanna;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {

    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    public void withdraw() {
        logger.info("Withdraw is successful !");
    }
}