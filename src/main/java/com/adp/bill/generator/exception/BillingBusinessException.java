package com.adp.bill.generator.exception;

import com.adp.bill.generator.utils.MessageKeyEnum;

public class BillingBusinessException extends Exception {

	private String args[];

	/** The message key. */
	private String messageKey;

	public BillingBusinessException() {
		super();
	}

	public BillingBusinessException(String message) {

		super(message);
	}

	public BillingBusinessException(Throwable cause) {

		super(cause);
	}

	public BillingBusinessException(String message, Throwable cause) {

		super(message, cause);
	}

	public BillingBusinessException(MessageKeyEnum messageKeyEnum, String... arg) {

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
