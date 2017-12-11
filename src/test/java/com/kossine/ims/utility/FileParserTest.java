package com.kossine.ims.utility;

import java.io.File;

import org.junit.Test;

import com.kossine.ims.models.Inventory;
import com.kossine.ims.models.Laptop;
import com.kossine.ims.utility.excel_to_pojo.FileParser;

public class FileParserTest {

	@Test
	public void test() throws Exception {
		File formatFile=new File("/home/jigar/workspace/ims/src/main/java/com/kossine/ims/utility/excel_to_pojo/format.json");
		File excel=new File("/home/jigar/workspace/projectdata1.xlsx");
		FileParser fp=new FileParser(excel,formatFile);

		for(Inventory e : fp.parseFile().get(Laptop.class))
			System.out.println(((Laptop)e).getDop());
	}

}
