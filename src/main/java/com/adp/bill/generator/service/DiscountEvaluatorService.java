package com.adp.bill.generator.service;

import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;

public interface DiscountEvaluatorService {
	public float getDiscountOnCategory(int categoryId) throws IllegalArgumentException, BillingTechnicalException, BillingBusinessException;
	public float getDiscountOnSlab(int finalPrice) throws IllegalArgumentException, BillingTechnicalException, BillingBusinessException;
}
