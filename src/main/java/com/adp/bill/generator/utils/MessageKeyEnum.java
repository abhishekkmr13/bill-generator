package com.adp.bill.generator.utils;

public enum MessageKeyEnum {

	/** The system error. */
	SYSTEM_ERROR("system_error"),

	/** The business exception. */
	BUSINESS_EXCEPTION("business_exception"),

	/** The technical exception. */
	TECHNICAL_EXCEPTION("technical_exception");

	private final String messageKeyValue;

	private MessageKeyEnum(final String s) {

		messageKeyValue = s;
	}

	public String toString() {

		return messageKeyValue;
	}


	public String getKeyValue() {
		return messageKeyValue;
	}
}
