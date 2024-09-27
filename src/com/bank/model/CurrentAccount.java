package com.bank.model;

import com.bank.enums.TransactionType;

public class CurrentAccount extends Account {
    @Override
    public boolean performTransaction(Transaction transaction) {
        if (transaction.getTransactionType() == TransactionType.PAYMENT) {
            double amount = transaction.getAmount();
            double transactionFee = amount * 0.0005; // 0.05%
            if (balance >= (amount + transactionFee)) {
                balance -= (amount + transactionFee);
                addTransaction(transaction);
                return true;
            }
            return false; // Insufficient balance
        } else if (transaction.getTransactionType() == TransactionType.DEPOSIT) {
            balance += transaction.getAmount();
            addTransaction(transaction);
            return true;
        }
        return false;
    }
}
