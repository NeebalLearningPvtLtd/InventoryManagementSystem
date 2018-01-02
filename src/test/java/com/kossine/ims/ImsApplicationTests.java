package com.kossine.ims;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImsApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(ImsApplicationTests.class);
	@Test
	public void integrationTest() {
		
		log.error("erroring");
		log.warn("warning");
		log.info("infoing");
		log.debug("debugging");
		log.trace("tracing");
	}

}
