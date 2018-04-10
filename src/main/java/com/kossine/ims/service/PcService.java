package com.kossine.ims.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.domain.PcVO;
import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Hdd;
import com.kossine.ims.models.KeyBoard;
import com.kossine.ims.models.Monitor;
import com.kossine.ims.models.MotherBoard;
import com.kossine.ims.models.Mouse;
import com.kossine.ims.models.Pc;
import com.kossine.ims.models.PowerSupply;
import com.kossine.ims.models.Ram;
import com.kossine.ims.models.Wifi;
import com.kossine.ims.repository.HddRepo;
import com.kossine.ims.repository.KeyBoardRepo;
import com.kossine.ims.repository.MonitorRepo;
import com.kossine.ims.repository.MotherBoardRepo;
import com.kossine.ims.repository.MouseRepo;
import com.kossine.ims.repository.PcRepo;
import com.kossine.ims.repository.PowerSupplyRepo;
import com.kossine.ims.repository.RamRepo;
import com.kossine.ims.repository.WifiRepo;

@Service
public class PcService {

	@Autowired
	PcRepo pcRepo;
	@Autowired
	RamRepo ramRepo;
	@Autowired
	HddRepo hddRepo;
	@Autowired
	MouseRepo mouseRepo;
	@Autowired
	KeyBoardRepo keyboardRepo;
	@Autowired
	MonitorRepo monitorRepo;
	@Autowired
	PowerSupplyRepo powersupplyRepo;
	@Autowired
	MotherBoardRepo motherboardRepo;
	@Autowired
	WifiRepo wifiRepo;

	private PcVO copy(Pc model) {
		PcVO domain = new PcVO();
		domain.setId(model.getId());
		domain.setPcTag(model.getPcTag());
		domain.setLocation(model.getLocation());
		domain.setVt(model.getVt());
		if (model.getRam() != null)
			domain.setRam_id(model.getRam().getId());
		if (model.getHdd() != null)
			domain.setHdd_id(model.getHdd().getId());
		if (model.getMouse() != null)
			domain.setMouse_id(model.getMouse().getId());
		if (model.getKeyboard() != null)
			domain.setKeyboard_id(model.getKeyboard().getId());
		if (model.getMonitor() != null)
			domain.setMonitor_id(model.getMonitor().getId());
		if (model.getPowersupply() != null)
			domain.setPowersupply_id(model.getPowersupply().getId());
		if (model.getMotherboard() != null)
			domain.setMotherboard_id(model.getMotherboard().getId());
		if (model.getWifi() != null)
			domain.setWifi_id(model.getWifi().getId());

		return domain;
	}

	private Pc copy(PcVO domain) {
		Pc model = new Pc();

		model.setPcTag(domain.getPcTag());
		model.setLocation(domain.getLocation());
		model.setVt(domain.getVt());
		if (domain.getRam_id() != null)
			model.setRam(ramRepo.findOne(domain.getRam_id()));
		if (domain.getHdd_id() != null)
			model.setHdd(hddRepo.findOne(domain.getHdd_id()));
		if (domain.getMouse_id() != null)
			model.setMouse(mouseRepo.findOne(domain.getMouse_id()));
		if (domain.getKeyboard_id() != null)
			model.setKeyboard(keyboardRepo.findOne(domain.getKeyboard_id()));
		if (domain.getMonitor_id() != null)
			model.setMonitor(monitorRepo.findOne(domain.getMonitor_id()));
		if (domain.getPowersupply_id() != null)
			model.setPowersupply(powersupplyRepo.findOne(domain.getPowersupply_id()));
		if (domain.getMotherboard_id() != null)
			model.setMotherboard(motherboardRepo.findOne(domain.getMotherboard_id()));
		if (domain.getWifi_id() != null)
			model.setWifi(wifiRepo.findOne(domain.getWifi_id()));

		return model;
	}

	private void update(Pc entity, PcVO domain) throws ModelNotFoundException {

		if (domain.getPcTag() != null)
			entity.setPcTag(domain.getPcTag());
		if (domain.getVt() != null)
			entity.setVt(domain.getVt());
		if (domain.getLocation() != null)
			entity.setLocation(domain.getLocation());
		if (entity.getRam() != null && domain.getRam_id()!=null && entity.getRam().getId() != domain.getRam_id()) {
			Ram obj = ramRepo.findOne(domain.getRam_id());
			if (obj == null)
				throw new ModelNotFoundException("updating of pc with id " + entity.getId() + " failed ",
						"ram not found with id " + domain.getRam_id());
			entity.setRam(obj);
		}
		if (entity.getHdd() != null && domain.getHdd_id()!=null && entity.getHdd().getId() != domain.getHdd_id()) {
			Hdd obj = hddRepo.findOne(domain.getHdd_id());
			if (obj == null)
				throw new ModelNotFoundException("updating of pc with id " + entity.getId() + " failed ",
						"hdd not found with id " + domain.getHdd_id());
			entity.setHdd(obj);
		}
		if (entity.getMouse() != null && domain.getMouse_id()!=null && entity.getMouse().getId() != domain.getMouse_id()) {
			Mouse obj = mouseRepo.findOne(domain.getMouse_id());
			if (obj == null)
				throw new ModelNotFoundException("updating of pc with id " + entity.getId() + " failed ",
						"mouse not found with id " + domain.getMouse_id());
			entity.setMouse(obj);
		}
		if (entity.getKeyboard() != null && domain.getKeyboard_id()!=null && entity.getKeyboard().getId() != domain.getKeyboard_id()) {
			KeyBoard obj = keyboardRepo.findOne(domain.getKeyboard_id());
			if (obj == null)
				throw new ModelNotFoundException("updating of pc with id " + entity.getId() + " failed ",
						"keyboard not found with id " + domain.getKeyboard_id());
			entity.setKeyboard(obj);
		}
		if (entity.getMonitor() != null && domain.getMonitor_id()!=null && entity.getMonitor().getId() != domain.getMonitor_id()) {
			Monitor obj = monitorRepo.findOne(domain.getMonitor_id());
			if (obj == null)
				throw new ModelNotFoundException("updating of pc with id " + entity.getId() + " failed ",
						"monitor not found with id " + domain.getMonitor_id());
			entity.setMonitor(obj);
		}
		if (entity.getMotherboard() != null && domain.getMotherboard_id()!=null && entity.getMotherboard().getId() != domain.getMotherboard_id()) {
			MotherBoard obj = motherboardRepo.findOne(domain.getMotherboard_id());
			if (obj == null)
				throw new ModelNotFoundException("updating of pc with id " + entity.getId() + " failed ",
						"motherboard not found with id " + domain.getMotherboard_id());
			entity.setMotherboard(obj);
		}
		if (entity.getPowersupply() != null && domain.getPowersupply_id()!=null && entity.getPowersupply().getId() != domain.getPowersupply_id()) {
			PowerSupply obj = powersupplyRepo.findOne(domain.getPowersupply_id());
			if (obj == null)
				throw new ModelNotFoundException("updating of pc with id " + entity.getId() + " failed ",
						"powersupply not found with id " + domain.getPowersupply_id());
			entity.setPowersupply(obj);
		}
		if (entity.getWifi() != null && domain.getWifi_id()!=null && entity.getWifi().getId() != domain.getWifi_id()) {
			Wifi obj = wifiRepo.findOne(domain.getWifi_id());
			if (obj == null)
				throw new ModelNotFoundException("updating of pc with id " + entity.getId() + " failed ",
						"wifi not found with id " + domain.getWifi_id());
			entity.setWifi(obj);
		}

	}

	public List<PcVO> findAllPc(Pageable pageable) {
		List<PcVO> list = new ArrayList<>();
		pcRepo.findAllWithJoin(pageable).forEach(pc -> list.add(copy(pc)));
		return list;
	}

	public PcVO findPcById(Long id) throws ModelNotFoundException {

		Pc e = pcRepo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Pc was not found ", "Pc was not found with id " + id);
		return copy(e);
	}

	public Long savePcToDB(PcVO e) {
		pcRepo.save(copy(e));
		return pcRepo.findByTag(e.getPcTag()).getId();
	}

	public void updatePc(Long id, PcVO domain) throws ModelNotFoundException {
		Pc entry = pcRepo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Pc was not found ", "Pc was not found with id " + id);

		update(entry, domain);

		pcRepo.update(entry);
	}

	public void deletePcById(Long id) throws ModelNotFoundException {

		Pc e = pcRepo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Pc was not found ", "Pc was not found with id " + id);

		pcRepo.delete(e);

	}
}
