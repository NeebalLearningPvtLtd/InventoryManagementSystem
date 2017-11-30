package com.kossine.ims.utility;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.kossine.ims.models.Inventory;
import com.kossine.ims.models.Laptop;
import com.kossine.ims.utility.exceltodb.FileParser;

public class FileParserTest {

	@Test
	public void test() throws Exception {
		File formatFile=new File("/home/jigar/workspace/ims/src/main/java/com/kossine/ims/utility/exceltodb/format.json");
		File excel=new File("/home/jigar/workspace/ims/src/test/java/com/kossine/ims/utility/projectdata.xlsx");
		FileParser fp=new FileParser(excel,formatFile);
//		System.out.println(fp.parseFile().get(Laptop.class)));
		Map<Class<? extends Inventory> ,List<Inventory> > mp=fp.parseFile();
		@SuppressWarnings("unchecked")
		List<Laptop> list=(List<Laptop>)(List<?>)mp.get(Laptop.class);
		System.out.println(list);
//		System.out.println(Class.forName("java.lang.Boolean"));
	}

}
