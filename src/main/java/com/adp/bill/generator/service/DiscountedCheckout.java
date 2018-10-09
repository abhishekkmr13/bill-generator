package com.adp.bill.generator.service;

import java.util.ArrayList;
import java.util.List;

import com.adp.bill.generator.entities.Item;
import com.adp.bill.generator.entities.ShoppingCart;
import com.adp.bill.generator.exception.BillingBusinessException;
import com.adp.bill.generator.exception.BillingTechnicalException;
import com.adp.bill.generator.vo.BilledItem;
import com.adp.bill.generator.vo.BillingDetailDVO;

public class DiscountedCheckout implements Checkout<ShoppingCart, BillingDetailDVO> {

	private DiscountEvaluatorService discountEvaluatorService = new DiscountEvaluatorServiceImpl();

	/*****
	 * Applies discount on all the items on ShoppingCart items
	 * @param shoppingCart
	 * @return BillingDetailVO which contains complete detail about the bill
	 * @throws BillingTechnicalException 
	 */
	@Override
	public BillingDetailDVO calculateTotal(ShoppingCart shoppingCart) throws BillingTechnicalException {

		BillingDetailDVO billingDetailDVO = new BillingDetailDVO();

		try {
			billingDetailDVO.setBilledItem(new ArrayList<>());


			List<Item> shoppingCartItems = shoppingCart.getItems();

			shoppingCartItems.forEach(cartItem ->{

				float discount=0.0f;
				try {
					discount = evaluateDiscountOnItem(cartItem);
				} catch (IllegalArgumentException | BillingTechnicalException | BillingBusinessException e) {
					System.err.println("Exception occured while evaluating discount on item. Cause="+e.getMessage());
				}

				double basePrice = cartItem.getUnitPrice()*cartItem.getQuantity();
				double priceAfterDiscount =basePrice *(1-discount/100);

				BilledItem billedItem =  new BilledItem(cartItem, priceAfterDiscount);

				billedItem.setDiscount(discount);
				billedItem.setItem(cartItem);
				billedItem.setFinalPrice(priceAfterDiscount);
				billingDetailDVO.getBilledItem().add(billedItem);
				billingDetailDVO.setAmountBeforeDiscount(billingDetailDVO.getAmountBeforeDiscount()+priceAfterDiscount);

			});

			billingDetailDVO.setSlabDiscount(evaluateDiscountOnTotalPrice(billingDetailDVO.getAmountBeforeDiscount()));
			billingDetailDVO.setAmountAfterDiscount(billingDetailDVO.getAmountBeforeDiscount()*(1-billingDetailDVO.getSlabDiscount()/100));
		}catch(Exception exc) {
			System.err.println("Exception occured while generating bill. Cause:"+exc.getMessage());
			throw new BillingTechnicalException("Exception occured while generating bill", exc);
		}
		return billingDetailDVO;
	}

	private float evaluateDiscountOnItem(Item item) throws IllegalArgumentException, BillingTechnicalException, BillingBusinessException {
		return discountEvaluatorService.getDiscountOnCategory(item.getItemCategory().getId());
	}

	/*****
	 * Find out the discount applicable on final price
	 * @param totalPrice
	 * @return
	 * @throws BillingBusinessException 
	 * @throws BillingTechnicalException 
	 * @throws IllegalArgumentException 
	 */
	private float evaluateDiscountOnTotalPrice(double totalPrice) throws IllegalArgumentException, BillingTechnicalException, BillingBusinessException {

		return discountEvaluatorService.getDiscountOnSlab((int)Math.round(totalPrice));
	}

}
