package com.ecommerce.product.constants;

public class ApplicationConstants {
	private ApplicationConstants() {

	}
	
	public static final String LOGIN_SUCCESS = "Login successfull";
	public static final String LOGIN_FAILURE = "Login not successfull";
	public static final Integer LOGIN_SUCCESS_STATUS = 200;
	public static final Integer LOGIN_FAILURE_STATUS =404;
	
	public static final String CUSTOMER_NOT_EXIST = "Invalid customer email or password";
	
	public static final String ORDER_NOT_FOUND="No order found on this customerId";
	public static final Integer ORDER_FAILURE_STATUS = 404;
	public static final String ORDER_FOUND="Orders on this CustomerId";
	public static final Integer ORDER_SUCCESS_STATUS = 200;
}
