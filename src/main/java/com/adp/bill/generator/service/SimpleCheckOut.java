package com.adp.bill.generator.service;

import java.util.ArrayList;
import java.util.List;

import com.adp.bill.generator.entities.Item;
import com.adp.bill.generator.entities.ShoppingCart;
import com.adp.bill.generator.vo.BilledItem;
import com.adp.bill.generator.vo.BillingDetailDVO;

public class SimpleCheckOut  implements Checkout<ShoppingCart, BillingDetailDVO> {

	DiscountEvaluatorService discountEvaluatorService;
	
	@Override
	public BillingDetailDVO calculateTotal(ShoppingCart shoppingCart) {
		
		BillingDetailDVO billingDetailDVO = new BillingDetailDVO();
		billingDetailDVO.setBilledItem(new ArrayList<>());
		
		
		List<Item> shoppingCartItems = shoppingCart.getItems();
		
		shoppingCartItems.forEach(cartItem ->{
			
			
			double basePrice = cartItem.getUnitPrice()*cartItem.getQuantity();
			
			BilledItem BilledItem =  new BilledItem(cartItem, basePrice);
			
			billingDetailDVO.getBilledItem().add(BilledItem);
			billingDetailDVO.setAmountBeforeDiscount(billingDetailDVO.getAmountBeforeDiscount());
			
		});
		
		billingDetailDVO.setSlabDiscount(0);
		billingDetailDVO.setAmountAfterDiscount(billingDetailDVO.getAmountBeforeDiscount()*(1-billingDetailDVO.getSlabDiscount()/100));
		
		return billingDetailDVO;
	}

}