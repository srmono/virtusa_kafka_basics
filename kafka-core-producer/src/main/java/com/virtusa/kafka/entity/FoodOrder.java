package com.virtusa.kafka.entity;

public class FoodOrder {
	private int amount;
	private String item;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public FoodOrder(int amount, String item) {
		super();
		this.amount = amount;
		this.item = item;
	}

	public FoodOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FoodOrder [amount=" + amount + ", item=" + item + "]";
	}

}
