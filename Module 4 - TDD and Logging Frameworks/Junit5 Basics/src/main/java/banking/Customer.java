package banking;

import java.math.BigDecimal;

public class Customer {

    String name;
    int age;
    String email;
    BigDecimal balance;
    String accountType;

    Customer(String name, int age, String email, BigDecimal balance, String accountType) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.balance = balance;
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal withdraw_amount) {
        balance = balance.subtract(withdraw_amount);
    }

    public void deposit(BigDecimal deposit_amount) {
        balance = balance.add(deposit_amount);
    }
}
