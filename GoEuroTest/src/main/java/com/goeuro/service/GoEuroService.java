package com.goeuro.service;

import java.util.List;

import com.goeuro.exception.GoEuroException;
import com.goeuro.model.City;
/**
 * 
 * @author Anandh 
 *
 * The interface GoEuroService used to provide the list of webservice APIs to implements
 */
public interface GoEuroService {
	public List<City> getCityList(String cityName)throws GoEuroException;
}
