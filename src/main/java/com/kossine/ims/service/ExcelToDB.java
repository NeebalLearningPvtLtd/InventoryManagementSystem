package com.kossine.ims.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kossine.ims.models.Adapter;
import com.kossine.ims.models.Hdd;
import com.kossine.ims.models.Inventory;
import com.kossine.ims.models.KeyBoard;
import com.kossine.ims.models.Laptop;
import com.kossine.ims.models.Monitor;
import com.kossine.ims.models.MotherBoard;
import com.kossine.ims.models.Mouse;
import com.kossine.ims.models.Pc;
import com.kossine.ims.models.PowerSupply;
import com.kossine.ims.models.Ram;
import com.kossine.ims.models.Wifi;
import com.kossine.ims.repository.AdapterRepo;
import com.kossine.ims.repository.HddRepo;
import com.kossine.ims.repository.KeyBoardRepo;
import com.kossine.ims.repository.LaptopRepo;
import com.kossine.ims.repository.MonitorRepo;
import com.kossine.ims.repository.MotherBoardRepo;
import com.kossine.ims.repository.MouseRepo;
import com.kossine.ims.repository.PcRepo;
import com.kossine.ims.repository.PowerSupplyRepo;
import com.kossine.ims.repository.RamRepo;
import com.kossine.ims.repository.WifiRepo;
import com.kossine.ims.utility.excel_to_pojo.FileParser;

@Service
public class ExcelToDB {
	private LaptopRepo laptopRepo;
	private AdapterRepo adapterRepo;
	private PcRepo pcRepo;
	private HddRepo hddRepo;
	private KeyBoardRepo keyboardRepo;
	private MonitorRepo monitorRepo;
	private MotherBoardRepo motherboardRepo;
	private MouseRepo mouseRepo;
	private PowerSupplyRepo powersupplyRepo;
	private RamRepo ramRepo;
	private WifiRepo wifiRepo;
	private File excelFile, formatFile;
	private static final Logger log = LoggerFactory.getLogger(ExcelToDB.class);
	@Value("${excel_file}")
	private String excelPath;

	@Value("${json_format_file}")
	private String formatPath;

	@Autowired
	public ExcelToDB(LaptopRepo laptopRepo, AdapterRepo adapterRepo, PcRepo pcRepo, HddRepo hddRepo,
			KeyBoardRepo keyboardRepo, MonitorRepo monitorRepo, MotherBoardRepo motherBoardRepo, MouseRepo mouseRepo,
			PowerSupplyRepo powerSupplyRepo, RamRepo ramRepo, WifiRepo wifiRepo) {
		this.laptopRepo = laptopRepo;
		this.adapterRepo = adapterRepo;
		this.pcRepo = pcRepo;
		this.hddRepo = hddRepo;
		this.keyboardRepo = keyboardRepo;
		this.monitorRepo = monitorRepo;
		this.motherboardRepo = motherBoardRepo;
		this.mouseRepo = mouseRepo;
		this.powersupplyRepo = powerSupplyRepo;
		this.ramRepo = ramRepo;
		this.wifiRepo = wifiRepo;
		log.debug("In constructor of ExcelToDB service");
	}

	@PostConstruct
	public void init() {
		excelFile = new File(excelPath);
		formatFile = new File(formatPath);
		log.debug("In post constructor of ExcelToDB service 1) excel file path : {}  , 2) json format  file path {}",
				excelFile, formatFile);
	}

	@SuppressWarnings("unchecked")
	public void perform() {

		try {
			FileParser<Inventory> fp = new FileParser<>(excelFile, formatFile);
			Map<Class<Inventory>, List<Inventory>> map = null;
			try {
				map = fp.parseFile();
				log.debug("calling parse file ");
				for (Entry<Class<Inventory>, List<Inventory>> pair : map.entrySet()) {
					Class<? extends Inventory> clazz=null;
					List<?> inventories=null;
					try {
						clazz = pair.getKey();
						inventories = pair.getValue();
						if (clazz.equals(Laptop.class))
							laptopRepo.bulkSave((List<Laptop>) inventories);
						else if (clazz.equals(Adapter.class))
							adapterRepo.bulkSave((List<Adapter>) inventories);
						else if (clazz.equals(Pc.class))
							pcRepo.bulkSave((List<Pc>) inventories);
						else if (clazz.equals(Hdd.class))
							hddRepo.bulkSave((List<Hdd>) inventories);
						else if (clazz.equals(KeyBoard.class))
							keyboardRepo.bulkSave((List<KeyBoard>) inventories);
						else if (clazz.equals(Monitor.class))
							monitorRepo.bulkSave((List<Monitor>) inventories);
						else if (clazz.equals(MotherBoard.class))
							motherboardRepo.bulkSave((List<MotherBoard>) inventories);
						else if (clazz.equals(Mouse.class))
							mouseRepo.bulkSave((List<Mouse>) inventories);
						else if (clazz.equals(PowerSupply.class))
							powersupplyRepo.bulkSave((List<PowerSupply>) inventories);
						else if (clazz.equals(Ram.class))
							ramRepo.bulkSave((List<Ram>) inventories);
						else if (clazz.equals(Wifi.class))
							wifiRepo.bulkSave((List<Wifi>) inventories);
					} catch (Exception e) {
						log.warn(e + " in bulk saving for class : "+clazz);
					}
				}
			} catch (Exception e) {
				log.error("excel sheets were not parsed , " + e);
			}

		} catch (FileNotFoundException e) {

			log.error("excel file / format file were not found  , " + e);
		}

	}

}
