package com.goeuro.csv;

import static com.goeuro.csv.Constants.COMMA_DELIMITER;

import static com.goeuro.csv.Constants.FILE_HEADER;
import static com.goeuro.csv.Constants.NEW_LINE_SEPARATOR;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.goeuro.exception.GoEuroException;
import com.goeuro.model.City;
/**
 * 
 * @author Anandh
 *
 * Class WriterImpl implements all the APIs used for CSV
 */

public class WriterImpl implements Writer {
	private Logger logger = LoggerFactory.getLogger(WriterImpl.class);


	/**
	 * This API is used to create the excel sheet
	 * 
	 * @param fileName is the csv filename 
	 * @param cities is list of cities to be written in excel
	 */
	public void write(String fileName, List<City> cities) throws GoEuroException{
		logger.debug("Creating CSV file");
	      FileWriter fileWriter = null;
	        try {
	            fileWriter = new FileWriter(fileName);
	            //Write the CSV file header

	            fileWriter.append(FILE_HEADER.toString());
	            //Add a new line separator after the header

	            fileWriter.append(NEW_LINE_SEPARATOR);
	            //Write a new student object list to the CSV file

	            for (City city : cities) {

	                fileWriter.append(city.get_id().toString());

	                fileWriter.append(COMMA_DELIMITER);

	                fileWriter.append(city.getName());

	                fileWriter.append(COMMA_DELIMITER);

	                fileWriter.append(city.getType());

	                fileWriter.append(COMMA_DELIMITER);

	                fileWriter.append(city.getGeo_position().getLatitude().toString());

	                fileWriter.append(COMMA_DELIMITER);

	                fileWriter.append(city.getGeo_position().getLongitude().toString());

	                fileWriter.append(NEW_LINE_SEPARATOR);

	            }
	            logger.info("CSV file is created successfully !!!");

	        } catch (Exception e) {

			    logger.error(e.getMessage());
				throw new GoEuroException(e.getMessage());

	        } finally {
	            try {

	                fileWriter.flush();

	                fileWriter.close();

	            } catch (IOException e) {
				    logger.error(e.getMessage());
					throw new GoEuroException(e.getMessage());

	            }
	        }

	}

}
