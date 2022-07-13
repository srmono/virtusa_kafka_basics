package com.virtusa.kafka;

public class Product {

	private String prodName;
	private String isbn;

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Product(String prodName, String isbn) {
		super();
		this.prodName = prodName;
		this.isbn = isbn;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
