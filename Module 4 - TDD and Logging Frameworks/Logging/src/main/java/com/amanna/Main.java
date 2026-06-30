package com.amanna;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(200);
        bankAccount.deposit(1000);
        bankAccount.deposit(-100);
        bankAccount.withdraw(900);
    }
}