package com.kossine.ims.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kossine.ims.models.Hdd;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HddRepoTest {
	@Autowired
	HddRepo repo;

	@Test
	public void test() {
		
		repo.findAll(new PageRequest(0, 2));
		System.out.println("*******************");
		repo.findOne(1);
	}
	@Test
	public void testBulkSave() {
		List<Hdd> list=new ArrayList<>();
		Hdd obj=new Hdd();
		obj.setId(1);
		obj.setHddTag("HDD/ADH/BST/0001");
		obj.setLocation("pluto");
		list.add(obj);
		obj=new Hdd();
		obj.setId(2);
		obj.setHddTag("HDD/ADH/BST/0002");
		obj.setLocation("jupiter");
		list.add(obj);
		repo.bulkSave(list);
	}
}
