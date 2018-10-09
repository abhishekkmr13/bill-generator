package com.adp.bill.generator.service;

import com.adp.bill.generator.exception.BillingTechnicalException;

@FunctionalInterface
public interface Checkout<T, V> {
	public V  calculateTotal(T t) throws BillingTechnicalException;
}
