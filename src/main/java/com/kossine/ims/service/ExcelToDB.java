package com.kossine.ims.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kossine.ims.models.Adapter;
import com.kossine.ims.models.Inventory;
import com.kossine.ims.models.Laptop;
import com.kossine.ims.repository.IAdapterRepo;
import com.kossine.ims.repository.ILaptopRepo;
import com.kossine.ims.utility.excel_to_pojo.FileParser;

@Service
public class ExcelToDB {
	private ILaptopRepo laptopRepo;
	private IAdapterRepo adapterRepo;
	private File excelFile, formatFile;

	@Value("${excel_file}")
	private String excelPath;

	@Value("${json_format_file}")
	private String formatPath;

	@Autowired
	public ExcelToDB(ILaptopRepo laptopRepo, IAdapterRepo adapterRepo) {
		this.laptopRepo = laptopRepo;
		this.adapterRepo = adapterRepo;
	}

	@PostConstruct
	public void init() {
		excelFile = new File(excelPath);
		formatFile = new File(formatPath);
	}

	@SuppressWarnings("unchecked")
	public void perform() {

		try {
			FileParser fp = new FileParser(excelFile, formatFile);
				Map<Class<? extends Inventory>, List<Inventory>> map = null;
				try {
					map = fp.parseFile();
				} catch (Exception e) {
					
					System.err.println("excel sheets were not parsed , "+e);
				}
				for (Entry<Class<? extends Inventory>, List<Inventory>> pair : map.entrySet()) {
					Class<? extends Inventory> clazz = pair.getKey();
					if (clazz.equals(Laptop.class))
						laptopRepo.bulkSave((List<Laptop>)(List<?>)pair.getValue());
					else if (clazz.equals(Adapter.class))
						adapterRepo.bulkSave((List<Adapter>)(List<?>)pair.getValue());
				}
	
		} catch (FileNotFoundException e) {

			System.err.println(e);
		}

	}

}
