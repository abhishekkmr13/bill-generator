package com.adp.bill.generator.service;

import com.adp.bill.generator.dao.CategoryDao;
import com.adp.bill.generator.dao.CategoryDaoImpl;
import com.adp.bill.generator.dao.DiscountDao;
import com.adp.bill.generator.dao.DiscountDaoImpl;
import com.adp.bill.generator.entities.Category;
import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;

public class DiscountEvaluatorServiceImpl implements DiscountEvaluatorService{

	private DiscountDao discountDao = new DiscountDaoImpl();
	private CategoryDao categoryDao = new CategoryDaoImpl();
	
	/*****
	 * Find out category discount using category ID
	 * @param categoryId
	 * @return
	 * @throws BillingBusinessException 
	 * @throws BillingTechnicalException 
	 * @throws IllegalAccessException 
	 */
	public float getDiscountOnCategory(int categoryId) throws IllegalArgumentException, BillingTechnicalException, BillingBusinessException{
		
		if(categoryId <=0)
			throw new IllegalArgumentException("Invalid categoryId="+categoryId);
		
		Category category = categoryDao.getCategory(categoryId);
		if(null != category )
			return category.getDiscount();
		
		return 0;
	}

	/*****
	 * Find out discount on total bill
	 * @param categoryId
	 * @return
	 * @throws BillingBusinessException 
	 * @throws BillingTechnicalException 
	 */
	public float getDiscountOnSlab(int finalPrice) throws IllegalArgumentException, BillingTechnicalException, BillingBusinessException{
		if(finalPrice <0)
			throw new IllegalArgumentException("Invalid finalPrice="+finalPrice);
		
		return discountDao.getDiscountOnSlab(finalPrice);
	}

}
