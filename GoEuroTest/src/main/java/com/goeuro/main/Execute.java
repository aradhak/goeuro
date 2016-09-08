package com.goeuro.main;

import static com.goeuro.constants.GoEuro.CSV_FILE_NAME;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.goeuro.csv.Writer;
import com.goeuro.model.City;
import com.goeuro.service.GoEuroService;
import com.goeuro.util.Utilities;
/**
 * 
 * @author Anandh
 *
 * Class Execute is the main class for getting city list and writing into csv file for the specified name
 */
public class Execute {
	private static Logger logger = LoggerFactory.getLogger(Execute.class);

	/**
	 * This API is used to get the list of cities and write in a csv the 
	 * @param args is the string arguments containing  a city name
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		logger.info("GoEuro process started");
		//Get the Spring Context
		if(args.length==1){
			logger.info("City name is {}",args[0]);
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("goeuro.xml");
			GoEuroService goEuroService = ctx.getBean("goEuroService", GoEuroService.class);
			Writer csvWriter = ctx.getBean("writer", Writer.class);
			logger.info("Getting city list");
	        List<City> cityList= goEuroService.getCityList(args[0]);
	        if(cityList!= null && cityList.size()>0){
				logger.info("Writing into a csv file");
				csvWriter.write(Utilities.getInstance().getValue(CSV_FILE_NAME), cityList);
	        }else{
				logger.info("No city found for {}",args[0]);
	        }
			ctx.close();
			
		}else if(args.length==0){
			logger.info("No city name found");
		}else{
			logger.info("Please provide only one city name at a time");
		}
		logger.info("GoEuro process completed");
	}
}
