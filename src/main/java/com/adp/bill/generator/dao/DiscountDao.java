package com.adp.bill.generator.dao;

import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;

public interface DiscountDao {

	public float getDiscountOnSlab(int totalBill) throws BillingTechnicalException, BillingBusinessException;
}
