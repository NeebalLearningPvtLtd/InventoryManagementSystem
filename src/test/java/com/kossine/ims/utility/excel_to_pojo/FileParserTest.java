package com.kossine.ims.utility.excel_to_pojo;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.kossine.ims.models.Inventory;

@TestPropertySource(locations = "classpath:application.properties")
@RunWith(SpringRunner.class)
public class FileParserTest {

	@Value("${json_format_file}")
	String formatfile;
	@Value("${excel_file}")
	String excelfile;

	@Test
	public void test() throws Exception {
		File formatFile = new File(formatfile);
		File excel = new File(excelfile);
		FileParser<Inventory> fp = new FileParser<>(excel, formatFile);
		
		fp.parseFile().forEach((clazz,list)->{
			System.out.println("content for:"+clazz.getName());	
			list.forEach(System.out::println);	
			
		});
	}

}
