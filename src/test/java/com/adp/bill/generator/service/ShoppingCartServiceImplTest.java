package com.adp.bill.generator.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;

public class ShoppingCartServiceImplTest {
	private ShoppingCartService shoppingCartService;

	@BeforeEach
	public void setUp() throws Exception {
		shoppingCartService = new ShoppingCartServiceImpl(); 
	}


	@Test
	void testGetAllItems() {
		try {
			assertTrue(4==shoppingCartService.getAllItems().size());
		} catch (BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
}
