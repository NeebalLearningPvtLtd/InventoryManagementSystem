package com.kossine.ims.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaptopUsedByTest {

	@Autowired
	EntityManager em;
	@Autowired
	LaptopRepo laptoprepo;
	
	@Autowired
	LaptopUsedByRepo usedbyrepo;
	
	
	@Test
	@Transactional
	public void test() {

		laptoprepo.deleteById(3L);
		em.flush();
		assertThat(usedbyrepo.count()).isEqualTo(1L);
		assertThat(usedbyrepo.findOne(2L).getLaptop()).isNull();
	}

}
