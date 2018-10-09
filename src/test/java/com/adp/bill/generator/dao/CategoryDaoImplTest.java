package com.adp.bill.generator.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;

public class CategoryDaoImplTest {
	private CategoryDao categoryDao;
	
	@BeforeEach
    public void setUp() throws Exception {
		categoryDao = new CategoryDaoImpl(); 
    }

	
	@Test
	void testGetAllItems() {
		try {
			assertNotNull(categoryDao.getCategory(1));
		} catch (BillingTechnicalException | BillingBusinessException e) {
			fail(e);
		}
	}
}
