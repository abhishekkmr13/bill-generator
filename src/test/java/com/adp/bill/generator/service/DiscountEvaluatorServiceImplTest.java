package com.adp.bill.generator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;

class DiscountEvaluatorServiceImplTest {

	private DiscountEvaluatorService discountEvaluatorService;
	
	@BeforeEach
	public void setUp() throws Exception {
		discountEvaluatorService = new DiscountEvaluatorServiceImpl(); 
	}
	
	@Test
	void testGetDiscountOnCategory_ConsumerGoods() {
		try {
			assertTrue(5.0f==discountEvaluatorService.getDiscountOnCategory(1));
		} catch (IllegalArgumentException | BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
	@Test
	void testGetDiscountOnCategory_OrganicFood() {
		try {
			assertTrue(7.0f==discountEvaluatorService.getDiscountOnCategory(2));
		} catch (IllegalArgumentException | BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
	@Test
	void testGetDiscountOnCategory_Grocery() {
		try {
			assertTrue(2.0f==discountEvaluatorService.getDiscountOnCategory(3));
		} catch (IllegalArgumentException | BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
	@Test
	void testGetDiscountOnCategory_BabyProducts() {
		try {
			assertTrue(10.0f==discountEvaluatorService.getDiscountOnCategory(4));
		} catch (IllegalArgumentException | BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
	@Test
	void testGetDiscountOnCategory_Apparrel() {
		try {
			assertTrue(15.0f==discountEvaluatorService.getDiscountOnCategory(5));
		} catch (IllegalArgumentException | BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
}
