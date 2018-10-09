package com.adp.bill.generator.service;

import java.util.List;

import com.adp.bill.generator.dao.ShoppingCartDao;
import com.adp.bill.generator.dao.ShoppingCartDaoImpl;
import com.adp.bill.generator.entities.Item;
import com.adp.bill.generator.entities.ShoppingCart;
import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;

public class ShoppingCartServiceImpl implements ShoppingCartService{

	private ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();
	
	@Override
	public void addItemToShoppingCart(Item item) {
		
	}

	@Override
	public void deleteItemFromShoppingCart(Item item, int quantity) {
		
	}

	@Override
	public List<Item> getAllItems() throws BillingTechnicalException, BillingBusinessException {
		return shoppingCartDao.getAllItems();
	}

	@Override
	public double getTotalBill(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return 0;
	}

}
