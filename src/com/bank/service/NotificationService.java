package com.bank.service;

public class NotificationService {

	// Method to send notifications
	public void sendTransactionNotification(String customerId, String message) {
		// In a real application, this could send an email or SMS.
		System.out.println("Notification for Customer ID " + customerId + ": " + message);
	}
}