package com.kossine.ims.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaptopRepoTest {

	@Autowired
	LaptopRepo repo;

	@Test
	public void test() {
		
		repo.findByTag("LAP/ADH/BST/0001");
		
	}
	
	
}
