package com.kossine.ims.utility;

import java.io.File;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import com.kossine.ims.models.Inventory;
import com.kossine.ims.utility.excel_to_pojo.FileParser;

public class FileParserTest {

	@Test
	public void test() throws Exception {
		File formatFile=new File("/home/jigar/workspace/ims/src/main/java/com/kossine/ims/utility/exceltodb/format.json");
		File excel=new File("/home/jigar/workspace/projectdata1.xlsx");
		FileParser fp=new FileParser(excel,formatFile);


		for(Entry<Class<? extends Inventory>, List<Inventory>> e:fp.parseFile().entrySet()) {
			System.out.println(e.getKey());
			for(Inventory a : e.getValue()) {
				System.out.println(a);
			}
		}
	
	}

}
