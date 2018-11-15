package com.bucketlist.aaron.bucketlist.exceptions;

/**
 * This is a custom exception that will be thrown when the number of goal
 * exceeds a certain number.
 * 
 * @author Aaron
 * @version 1.0
 * @since 2018-11-15
 */
public class TooManyGoalsException extends RuntimeException {
	public TooManyGoalsException(String errorMessage) {
		super(errorMessage);
	}
}
