package com.amanna;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {

    private int balance = 0;

    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    public void withdraw(int amount) {
        if(amount > balance) {
            logger.error("Not sufficient balance present. Requested amount {}, current balance {}", amount, balance);
        } else {
            balance = balance - amount;
            logger.info("Withdraw of {} is successful! Remaining balance {}", amount, balance);
            warnBalance();
        }
    }

    public void deposit(int amount) {
        if(amount < 0) {
            logger.error("Cannot deposit less than zero");
        } else {
            balance = balance + amount;
            logger.info("Amount {} has been credited to your account", amount);
        }
    }

    public void warnBalance(){
        if (balance < 100) {
            logger.warn("Low Balance! You have amount {} remaining", balance);
        }
    }
}