package com.virtusa.kafka.entity;

public class PaymentRequest {

	private String paymentNumber;
	private int amount;
	private String currency;
	private String notes;
	private String transactionType;

	public String getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public PaymentRequest(String paymentNumber, int amount, String currency, String notes, String transactionType) {
		super();
		this.paymentNumber = paymentNumber;
		this.amount = amount;
		this.currency = currency;
		this.notes = notes;
		this.transactionType = transactionType;
	}

	public PaymentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
