package com.adp.bill.generator.dao;

import com.adp.bill.generator.entities.Category;
import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;

public interface CategoryDao {
	
	public Category getCategory(int categoryId) throws BillingTechnicalException, BillingBusinessException;

}