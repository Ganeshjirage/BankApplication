package com.bank.model;

import com.bank.enums.TransactionType;

public class Transaction {
    private String transactionId;
    private TransactionType transactionType;
    private double amount;

    public Transaction(String transactionId, TransactionType transactionType, double amount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }
}