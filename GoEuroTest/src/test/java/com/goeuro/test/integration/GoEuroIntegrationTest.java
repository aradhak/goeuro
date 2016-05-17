package com.goeuro.test.integration;

import java.io.File;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.goeuro.csv.Writer;
import com.goeuro.exception.GoEuroException;
import com.goeuro.model.City;
import com.goeuro.service.GoEuroService;

public class GoEuroIntegrationTest {
	private ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("goeuro-test.xml");
	private GoEuroService goEuroService = classPathXmlApplicationContext.getBean("goEuroService", GoEuroService.class);
	private Writer csvWriter = classPathXmlApplicationContext.getBean("writer", Writer.class);

	/**
	 * Used to check with known city name
	 * @throws GoEuroException
	 */
	@Test
	public void checkWithKnownCity() throws GoEuroException{
		List<City> cityList=goEuroService.getCityList("berlin");
		String fileName="city_integration_valid.csv";
		if(cityList!=null && cityList.size()>0){
			csvWriter.write(fileName, cityList);
		}
		File csvFile=new File(fileName);
		Assert.assertTrue(csvFile.exists());
	}
	
	/** Used to check with unknown city name
	 * @throws GoEuroException
	 */
	@Test
	public void checkWithUnknownCity() throws GoEuroException{
		List<City> cityList=goEuroService.getCityList("zzz");
		String fileName="city_integration_invalid.csv";
		if(cityList!=null && cityList.size()>0){
			csvWriter.write(fileName, cityList);
		}
		File csvFile=new File(fileName);
		Assert.assertTrue(!csvFile.exists());
	}
}
