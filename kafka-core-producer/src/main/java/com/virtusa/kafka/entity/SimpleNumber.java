package com.virtusa.kafka.entity;

public class SimpleNumber {

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public SimpleNumber(int number) {
		super();
		this.number = number;
	}

	public SimpleNumber() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SimpleNumber [number=" + number + "]";
	}

}
