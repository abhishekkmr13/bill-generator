package com.adp.bill.generator.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;

public class DiscountDaoImplTest {


	private DiscountDao discountDao;

	@BeforeEach
	public void setUp() throws Exception {
		discountDao = new DiscountDaoImpl(); 
	}


	@Test
	void testGetDiscountOnSlab_ForTotalBill_1000() {
		try {
			assertEquals(2.0f,discountDao.getDiscountOnSlab(1000));
		} catch (BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
	@Test
	void testGetDiscountOnSlab_ForTotalBill_3000() {
		try {
			assertEquals(2.0f,discountDao.getDiscountOnSlab(2000));
		} catch (BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
	@Test
	void testGetDiscountOnSlab_ForTotalBill_3001() {
		try {
			assertEquals(4.0f,discountDao.getDiscountOnSlab(3001));
		} catch (BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
	@Test
	void testGetDiscountOnSlab_ForTotalBill_4000() {
		try {
			assertEquals(4.0f,discountDao.getDiscountOnSlab(4000));
		} catch (BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
	@Test
	void testGetDiscountOnSlab_ForTotalBill_7000() {
		try {
			assertEquals(4.0f,discountDao.getDiscountOnSlab(7000));
		} catch (BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
	@Test
	void testGetDiscountOnSlab_ForTotalBill_7001() {
		try {
			assertEquals(5.0f,discountDao.getDiscountOnSlab(7001));
		} catch (BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
	
	@Test
	void testGetDiscountOnSlab_ForTotalBill_9000() {
		try {
			assertEquals(5.0f,discountDao.getDiscountOnSlab(9000));
		} catch (BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
}
