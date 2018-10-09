package com.adp.bill.generator.dao;

import java.util.List;

import com.adp.bill.generator.entities.Item;
import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;

public interface ShoppingCartDao {
	
	public void addItemToShoppingCart(Item item);
	public void deleteItemFromShoppingCart(Item item, int quantity);
	public List<Item> getAllItems() throws BillingTechnicalException, BillingBusinessException;
	
}
