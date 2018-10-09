package com.adp.bill.generator.exception;

import com.adp.bill.generator.utils.MessageKeyEnum;

public class BillingTechnicalException  extends Exception {

	private String args[];

	/** The message key. */
	private String messageKey;

	public BillingTechnicalException() {
		super();
	}

	public BillingTechnicalException(String message) {

		super(message);
	}

	public BillingTechnicalException(Throwable cause) {

		super(cause);
	}

	public BillingTechnicalException(String message, Throwable cause) {

		super(message, cause);
	}

	public BillingTechnicalException(MessageKeyEnum messageKeyEnum, String... arg) {

		super();
		this.messageKey = messageKeyEnum.toString();
		this.args = arg;
	}

	public String getMessageKey() {

		return messageKey;
	}

	public void setMessageKey(String messageKey) {

		this.messageKey = messageKey;
	}

	public String[] getArgs() {

		return args;
	}

	public void setArgs(String[] args) {

		this.args = args;
	}
}
