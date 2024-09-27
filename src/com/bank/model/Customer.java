package com.bank.model;

import com.bank.enums.TransactionType;

public class Customer {
    private String customerId;
    private String name;
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.currentAccount = new CurrentAccount();
        this.savingsAccount = new SavingsAccount();
        this.savingsAccount.performTransaction(new Transaction("JOIN_BONUS", TransactionType.DEPOSIT, 500.0)); // Joining bonus
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }
}