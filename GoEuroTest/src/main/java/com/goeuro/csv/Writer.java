package com.goeuro.csv;

import java.util.List;
import com.goeuro.exception.GoEuroException;
import com.goeuro.model.City;
/**
 * 
 * @author Anandh
 *
 * The interface Writer used to provide the list of APIs for CSV
 */
public interface Writer {
	public void write(String fileName,List<City> cityList) throws GoEuroException; 
}
   