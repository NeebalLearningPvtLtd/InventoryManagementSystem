package com.kossine.ims.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kossine.ims.models.Pc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PcRepoTest {
	@Autowired
	PcRepo pcrepo;
	@Autowired
	HddRepo hddrepo;
	
	@Test
	public void test() {
		
		Pc entity=new Pc();
		entity.setPcTag("PC/ef/f/0081");
		
		entity.setHdd(hddrepo.findOne(1));
		pcrepo.save(entity);
	
		System.out.println(pcrepo.findAll(new PageRequest(0,100)));
		assertThat(pcrepo.findByTag("PC/ef/f/0081").getHdd()).isNotNull();
	}

	@Test
	public void testFindAll() {
		
		pcrepo.findAll(new PageRequest(0,2));
	}
	@Test
	public void testFindOne() {
		
		pcrepo.findOne(1);
	
	}
	@Test
	public void testFindByTagReturnsJoinedResult() {
		System.out.println(pcrepo.findByTag("PC/ADH/BST/0001"));
	}
	@Test
	public void testFindAllWithJoin() {
		System.out.println(pcrepo.findAllWithJoin(new PageRequest(0,1)));
	}
	@Test
	public void testUpdate() {
		
		Pc e=pcrepo.findOne(2);
		e.setHdd(hddrepo.findOne(2));
		pcrepo.update(e);
	}
	@Test
	public void  testDelete() {
		pcrepo.delete(null);
	}
}
