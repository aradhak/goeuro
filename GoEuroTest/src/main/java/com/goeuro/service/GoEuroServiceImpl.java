package com.goeuro.service;

import static com.goeuro.constants.GoEuro.API_ENDPOINT;
import java.io.InputStream;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goeuro.exception.GoEuroException;
import com.goeuro.model.City;
import com.goeuro.util.Utilities;
/**
 * 
 * @author Anandh 
 *
 * Class GoEuroServiceImpl implements all the APIs used for making webservice call
 */
public class GoEuroServiceImpl implements GoEuroService {
	private Logger logger = LoggerFactory.getLogger(GoEuroServiceImpl.class);
	private HttpClient client = HttpClientBuilder.create().build();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Utilities util=Utilities.getInstance(); 
    
	/**
	 * This API is used to get the list of cities around the world in the specified name
	 * 
	 * @param cityName is the city filename 
	 * @return list of cities
	 */
	public List<City> getCityList(String cityName) throws GoEuroException {
       logger.debug("getCity({}) is invoked",cityName);
    	HttpGet httpGet = new HttpGet(
    			util.getValue(API_ENDPOINT)+cityName
    			);
		HttpResponse httpResponse=null;
		try {
			httpResponse = client.execute(httpGet);
		} catch (Exception e) {
		    logger.error(e.getMessage());
			throw new GoEuroException(e.getMessage());
		}
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		List<City> cityList = null; 
		if(statusCode==200){
			InputStream inputStream=null;
			try {
				inputStream = httpResponse.getEntity().getContent();
				cityList = objectMapper.readValue(inputStream,
		          objectMapper.getTypeFactory().constructCollectionType(
		                  List.class, City.class));
				
			    logger.info("City list size is {}",cityList.size());
			} catch (Exception e) {
			    logger.error(e.getMessage());
				throw new GoEuroException(e.getMessage());
			}

		}else{
		    logger.error("Invalid status code: {}",statusCode);
			throw new GoEuroException("No response found");
		}
	    return cityList;
	}

} 
