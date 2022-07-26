package com.virtusa.kafka.entity;

public class Image {
	
	private String name;
	private long size;
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Image(String name, long size, String type) {
		super();
		this.name = name;
		this.size = size;
		this.type = type;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Image [name=" + name + ", size=" + size + ", type=" + type + "]";
	}

}
