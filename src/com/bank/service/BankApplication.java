package com.bank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.enums.TransactionType;
import com.bank.model.Customer;
import com.bank.model.Transaction;

public class BankApplication {
    private Map<String, Customer> customers = new HashMap<>();
    private NotificationService notificationService = new NotificationService(); // Instantiate NotificationService

    public void onboardCustomer(String customerId, String name) {
        Customer customer = new Customer(customerId, name);
        customers.put(customerId, customer);
    }

    public boolean performTransaction(String customerId, double amount) {
        Customer customer = customers.get(customerId);
        boolean success = customer.getCurrentAccount().performTransaction(new Transaction("TX" + System.currentTimeMillis(), TransactionType.PAYMENT, amount));
        
        // Send notification based on transaction success
        if (success) {
            notificationService.sendTransactionNotification(customerId, "Transaction of Rs " + amount + " was successful.");
        } else {
            notificationService.sendTransactionNotification(customerId, "Transaction of Rs " + amount + " failed due to insufficient balance.");
        }
        return success;
    }

    public List<Transaction> getTransactions(String customerId) {
        Customer customer = customers.get(customerId);
        return customer.getCurrentAccount().getTransactions();
    }
    
    public Customer getCustomer(String customerId) {
        return customers.get(customerId);
    }
}
