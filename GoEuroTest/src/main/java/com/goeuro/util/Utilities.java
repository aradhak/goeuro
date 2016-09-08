package com.goeuro.util;

import static com.goeuro.constants.GoEuro.PROPERTY_FILE;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This class is used to provide list of useful Apis for the application. It is singleton class 
 * @author Anandh 
 *
 */
public class Utilities {
	private Logger logger = LoggerFactory.getLogger(Utilities.class);
	private static Utilities utilities = null;
	private ResourceBundle resourceBundle = ResourceBundle.getBundle(PROPERTY_FILE);
	
	private Utilities(){	
	}

	public static synchronized Utilities getInstance(){
		if(utilities == null){
			utilities = new Utilities();
		}
		return utilities;
	}
    
	/**
	 *  This API is used to provide the property value for the specified key
	 * @param key is key name
	 * @return the key value
	 */
	public String getValue(String key){
		logger.debug("getValue({}) is invoked",key);
		String value=resourceBundle.getString(key);
		return value;
	}	
	
}
