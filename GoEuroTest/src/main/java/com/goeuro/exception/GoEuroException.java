package com.goeuro.exception;
/**
 * 
 * @author Anandh
 * 
 * Class GoEuroException is a user defined exception class. Its used for Exception handling 
 *
 */
public class GoEuroException extends Exception{

	private static final long serialVersionUID = 1L;

	public GoEuroException(String errormessage){
      super(errormessage);
	}
}
