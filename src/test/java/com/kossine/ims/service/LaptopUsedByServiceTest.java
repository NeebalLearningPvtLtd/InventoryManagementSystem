package com.kossine.ims.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.repository.LaptopUsedByRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaptopUsedByServiceTest {

	@Autowired
	LaptopUsedByService service;

	@Autowired
	LaptopUsedByRepo usedbyrepo;

	@Test
	@Rollback(false)
	public void test() throws ModelNotFoundException {

		service.saveLaptopByLaptopTag("LAP/ADH/BST/0003", "kossine jupiter");
	}

}
