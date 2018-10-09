package com.adp.bill.generator.entities;

public class Item {
	
	private int id;
	private Category itemCategory;
	private String itemName;
	private float unitPrice;
	private int quantity;
	
	
	public Item() {
		
	}
	
	public Item(int id, Category itemCategory, String itemName, float unitPrice, int quantity) {
		super();
		this.id = id;
		this.itemCategory = itemCategory;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(Category itemCategory) {
		this.itemCategory = itemCategory;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	
}
