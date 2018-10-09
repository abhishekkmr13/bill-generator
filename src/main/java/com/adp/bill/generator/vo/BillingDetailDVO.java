package com.adp.bill.generator.vo;

import java.util.Date;
import java.util.List;

public class BillingDetailDVO {
	private List<BilledItem> billedItem;
	private Date billingDate = new Date();
	private double slabDiscount;
	private double amountBeforeDiscount;
	private double amountAfterDiscount;
	
	public List<BilledItem> getBilledItem() {
		return billedItem;
	}
	public void setBilledItem(List<BilledItem> billedItem) {
		this.billedItem = billedItem;
	}
	public Date getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}
	public double getSlabDiscount() {
		return slabDiscount;
	}
	public void setSlabDiscount(double slabDiscount) {
		this.slabDiscount = slabDiscount;
	}
	public double getAmountBeforeDiscount() {
		return amountBeforeDiscount;
	}
	public void setAmountBeforeDiscount(double amountBeforeDiscount) {
		this.amountBeforeDiscount = amountBeforeDiscount;
	}
	public double getAmountAfterDiscount() {
		return amountAfterDiscount;
	}
	public void setAmountAfterDiscount(double amountAfterDiscount) {
		this.amountAfterDiscount = amountAfterDiscount;
	}
	
	
}
