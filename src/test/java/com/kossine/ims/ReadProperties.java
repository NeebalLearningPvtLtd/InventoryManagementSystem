package com.kossine.ims;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:excel_to_db.properties")
public class ReadProperties {
	
	@Value("${excel_file}")
	String excelPath;
	
	@Test
	public void test() {

		System.out.println(excelPath);
	}

}
