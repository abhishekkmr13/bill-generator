package com.adp.bill.generator.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adp.bill.generator.entities.ShoppingCart;
import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;
import com.adp.bill.generator.vo.BillingDetailDVO;

class DiscountedCheckoutTest {

	private Checkout<ShoppingCart, BillingDetailDVO> checkout;
	
	@BeforeEach
	public void setUp() throws Exception {
		checkout = new DiscountedCheckout(); 
	}
	
	@Test
	void testCalculateTotal_OnFinalPrice() throws BillingTechnicalException, BillingBusinessException {
		ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
		ShoppingCart shoppingCart =  new ShoppingCart(shoppingCartService.getAllItems());
		BillingDetailDVO billingDetailVO = checkout.calculateTotal(shoppingCart);
		
		assertTrue(1601.52==Math.round(billingDetailVO.getAmountAfterDiscount()*100.00)/100.00);
	}
	
	@Test
	void testCalculateTotal_OnSlabDiscount() throws BillingTechnicalException, BillingBusinessException {
		ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
		ShoppingCart shoppingCart =  new ShoppingCart(shoppingCartService.getAllItems());
		BillingDetailDVO billingDetailVO = checkout.calculateTotal(shoppingCart);
		
		assertTrue(2.0==billingDetailVO.getSlabDiscount());
	}
	
	@Test
	void testCalculateTotal_OnBasePrice() throws BillingTechnicalException, BillingBusinessException {
		ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
		ShoppingCart shoppingCart =  new ShoppingCart(shoppingCartService.getAllItems());
		BillingDetailDVO billingDetailVO = checkout.calculateTotal(shoppingCart);
		assertTrue(1634.2==Math.round(billingDetailVO.getAmountBeforeDiscount()*100.00)/100.00);
	}

}
