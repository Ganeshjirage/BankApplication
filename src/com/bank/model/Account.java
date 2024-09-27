package com.bank.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected double balance;
    protected List<Transaction> transactions;

    public Account() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Define the abstract method that subclasses must implement
    public abstract boolean performTransaction(Transaction transaction);
}
