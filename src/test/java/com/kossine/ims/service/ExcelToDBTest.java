package com.kossine.ims.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kossine.ims.ImsApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ImsApplication.class })
public class ExcelToDBTest {
	@Autowired
	ExcelToDB exceltodb;

	@Test
	public void excelToDBTest() {
		exceltodb.perform();
	}

}
