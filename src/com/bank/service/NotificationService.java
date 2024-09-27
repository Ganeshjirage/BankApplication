package com.bank.service;

public class NotificationService {

	// Method to send notifications
	public void sendTransactionNotification(String customerId, String message) {
		System.out.println("Notification for Customer ID " + customerId + ": " + message);
	}
}