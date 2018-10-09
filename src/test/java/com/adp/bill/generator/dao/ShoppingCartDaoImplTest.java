package com.adp.bill.generator.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;


class ShoppingCartDaoImplTest {

	private ShoppingCartDaoImpl shoppingCartDaoImpl ; 
	
	@BeforeEach
    public void setUp() throws Exception {
		shoppingCartDaoImpl = new ShoppingCartDaoImpl(); 
    }

	
	@Test
	void testGetAllItems() {
		try {
			assertTrue(4==shoppingCartDaoImpl.getAllItems().size());
		} catch (BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
}
