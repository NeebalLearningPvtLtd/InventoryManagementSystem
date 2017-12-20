package com.kossine.ims.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.kossine.ims.models.Adapter;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AdapterRepoTest {

	@Autowired
	private AdapterRepo repo;
	private Adapter obj;
	@Autowired
	private JdbcTemplate jdbc;

	@Before
	public void populatedb() throws ScriptException, SQLException {
		ScriptUtils.executeSqlScript(jdbc.getDataSource().getConnection(), new ClassPathResource("scripts/import.sql"));		
	}

	@After
	public void teardown() throws ScriptException, SQLException {
		// wipe data
		ScriptUtils.executeSqlScript(jdbc.getDataSource().getConnection(), new ClassPathResource("scripts/wipe.sql"));
		ScriptUtils.executeSqlScript(jdbc.getDataSource().getConnection(), new ClassPathResource("scripts/reset_auto_increment.sql"));
	}

	@Test
	public void testFindByTag() {

		assertThat(repo.findByTag("ADP/ADH/BST/0001").getId()).isEqualTo(1);
	}

	@Test
	public void testFindAll() {

		assertThat(repo.findAll(new PageRequest(0,50)).size()).isEqualTo(10);
	}

	@Test
	public void testPersist() throws Exception {

		obj = new Adapter();
		obj.setAdapterTag("123");
		repo.save(obj);

		assertThat(repo.findByTag("123").getId()).isEqualTo(obj.getId());
	}

	@Test
	public void testUpdate() throws Exception {

		obj = repo.findOne(1);
		obj.setAdapterTag("1234");
		repo.update(obj);

		assertThat(repo.findByTag("1234")).isNotNull();

	}

	@Test
	public void testDelete() throws Exception {

			repo.deleteById(1);
		assertThat(repo.findOne(1)).isNull();
	}

}
