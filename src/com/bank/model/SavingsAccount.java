package com.bank.model;

import com.bank.enums.TransactionType;

public class SavingsAccount extends Account {
    @Override
    public boolean performTransaction(Transaction transaction) {
        if (transaction.getTransactionType() == TransactionType.DEPOSIT) {
            double interest = balance * 0.005; // 0.5% interest
            balance += (transaction.getAmount() + interest);
            addTransaction(transaction);
            return true;
        }
        return false;
    }
}
