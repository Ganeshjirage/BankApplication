package com.bank.main;

import java.util.List;

import com.bank.enums.TransactionType;
import com.bank.model.Customer;
import com.bank.model.Transaction;
import com.bank.service.BankApplication;

public class Main {
	public static void main(String[] args) {
		BankApplication bankApp = new BankApplication();

		// Step 1: Onboard a new customer
		bankApp.onboardCustomer("CUST001", "Ganesh Jirage");

		// Print initial balances
		Customer customer = bankApp.getCustomer("CUST001"); // Use the new method to get the customer
		System.out.println("Initial Current Account Balance: " + customer.getCurrentAccount().getBalance());
		System.out.println("Initial Savings Account Balance: " + customer.getSavingsAccount().getBalance());

		// Step 2: Deposit funds into the current account
		Transaction depositTransaction = new Transaction("DEP" + System.currentTimeMillis(), TransactionType.DEPOSIT,
				501.0); // Deposit amount of R2000
		boolean depositStatus = customer.getCurrentAccount().performTransaction(depositTransaction);

		if (depositStatus) {
			System.out.println(
					"Deposit successful! New Current Account Balance: " + customer.getCurrentAccount().getBalance());
		} else {
			System.out.println("Deposit failed!");
		}

		// Step 3: Perform a transaction (transfer funds)
		boolean transactionStatus = bankApp.performTransaction("CUST001", 500.0); // Try to transfer Rs 1000
		if (transactionStatus) {
			System.out.println("Transaction successful!");
		} else {
			System.out.println("Transaction failed. Insufficient balance.");
		}

		// Retrieve and print transactions for the customer
		List<Transaction> transactions = bankApp.getTransactions("CUST001");
		if (transactions != null) {
			System.out.println("Transactions for customer:");
			for (Transaction transaction : transactions) {
				System.out.println(transaction.getTransactionId() + " - " + transaction.getTransactionType() + " - "
						+ transaction.getAmount());
			}
		}
	}
}
