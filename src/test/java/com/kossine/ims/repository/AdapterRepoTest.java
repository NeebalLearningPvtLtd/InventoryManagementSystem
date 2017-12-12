package com.kossine.ims.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import config.AppConfig;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes=AppConfig.class)
public class AdapterRepoTest {
	
	@Autowired
	TestEntityManager em;
	
	@Autowired
	IAdapterRepo repo;
	
	@Test
	public void TestPersist() throws Exception {
		
	}
	
}
