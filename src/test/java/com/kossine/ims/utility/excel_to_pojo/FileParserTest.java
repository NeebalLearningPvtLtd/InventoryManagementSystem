package com.kossine.ims.utility.excel_to_pojo;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.kossine.ims.models.Inventory;
import com.kossine.ims.models.Laptop;

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
		FileParser fp = new FileParser(excel, formatFile);

		for (Inventory e : fp.parseFile().get(Laptop.class))
			System.out.println(((Laptop) e).getDop());
	}

}
