package com.kossine.ims.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.kossine.ims.models.Hdd;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HddRepoTest {
	@Autowired
	HddRepo repo;

	@Test
	@Rollback(false)
	public void test() {
		List<Hdd> list = new ArrayList<>();
		Hdd one = new Hdd();
		one.setHddTag("HDD/ds/sd/1");
		Hdd two = new Hdd();
		two.setHddTag("HDD/ds/sd/2");
		list.add(one);
		list.add(two);
		repo.bulkSave(list);
		assertThat(repo.findByTag("one")).isNotNull();
	}
}
