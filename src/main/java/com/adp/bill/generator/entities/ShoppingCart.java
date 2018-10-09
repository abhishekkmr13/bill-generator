package com.adp.bill.generator.entities;

import java.util.List;

public class ShoppingCart {
	List<Item> items;

	public ShoppingCart(List<Item> items) {
		super();
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
