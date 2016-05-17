package com.goeuro.test;

import static com.goeuro.constants.GoEuro.CSV_FILE_NAME;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.goeuro.csv.Writer;
import com.goeuro.service.GoEuroService;
import com.goeuro.util.Utilities;

public class GoEuroTest {
	private ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("goeuro-test.xml");
	private GoEuroService goEuroService = classPathXmlApplicationContext.getBean("goEuroService", GoEuroService.class);
	private Writer csvWriter = classPathXmlApplicationContext.getBean("writer", Writer.class);
	private Utilities utilities=Utilities.getInstance();
	
	@Test
	public void isClassPathXmlApplicationContextNotNull(){
		Assert.assertNotNull(classPathXmlApplicationContext);
	}
	@Test
	public void isGoEuroServiceNotNull(){
		Assert.assertNotNull(goEuroService);
	}
	@Test
	public void isCsvWriterNotNull(){
		Assert.assertNotNull(csvWriter);
	}
	@Test
	public void isUtilitiesNotNull(){
		Assert.assertNotNull(utilities);
	}
	@Test
	public void getKeyValue(){
		String actual=utilities.getValue(CSV_FILE_NAME);
		String expected = "city.csv";
		Assert.assertEquals(expected, actual);
	}
}
