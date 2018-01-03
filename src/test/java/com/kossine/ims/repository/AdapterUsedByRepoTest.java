package com.kossine.ims.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdapterUsedByRepoTest {

	@Autowired
	AdapterUsedByRepo usedbyrepo;

	@Test
	public void test() {

	
		usedbyrepo.findAllWithJoin(new PageRequest(0, 2));
		
	}

}
