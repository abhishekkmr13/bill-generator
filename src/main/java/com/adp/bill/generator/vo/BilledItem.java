package com.adp.bill.generator.vo;

import com.adp.bill.generator.entities.Item;

public class BilledItem {
	private Item Item;
	private double finalPrice;
	private float discount;
	
	public BilledItem(Item item, double finalPrice) {
		super();
		Item = item;
		this.finalPrice = finalPrice;
	}
	public Item getItem() {
		return Item;
	}
	public void setItem(Item item) {
		Item = item;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
	
	
}
