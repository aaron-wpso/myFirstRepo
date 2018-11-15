package com.bucketlist.aaron.bucketlist.exceptions;

public class TooManyGoalsException extends RuntimeException
{
	public TooManyGoalsException (String errorMessage)
	{
		super(errorMessage);
	}
}
