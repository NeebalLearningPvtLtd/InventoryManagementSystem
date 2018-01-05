package com.kossine.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.envers.Audited;

@NamedQueries({
		@NamedQuery(query = "Select e from Pc e left join fetch e.ram left join fetch e.hdd left join fetch e.mouse left join fetch e.keyboard left join fetch e.powersupply left join fetch e.motherboard left join fetch e.monitor left join fetch e.wifi where e.pcTag= :tag", name = "Pc.getByTag"),
		@NamedQuery(query = "Select e from Pc e left join fetch e.ram left join fetch e.hdd left join fetch e.mouse left join fetch e.keyboard left join fetch e.powersupply left join fetch e.motherboard left join fetch e.monitor left join fetch e.wifi ", name = "Pc.findAllWithJoin") })
@Entity
@Audited
public class Pc extends Inventory {

	@Column(name = "pc_tag", unique = true, nullable = false)
	@Pattern(regexp = "^PC/\\w+/\\w+/\\d+$")
	private String pcTag;
	private String processor;
	@OneToOne
	private Ram ram;
	@OneToOne
	private Hdd hdd;
	@OneToOne
	private Mouse mouse;
	@OneToOne
	private KeyBoard keyboard;
	@OneToOne
	private PowerSupply powersupply;
	@OneToOne
	private MotherBoard motherboard;
	@OneToOne
	private Monitor monitor;
	@OneToOne
	private Wifi wifi;
	private Boolean vt;
	private String location;

	public Pc() {
		super("Pc", Pc.class);
	}

	public String getPcTag() {
		return pcTag;
	}

	public void setPcTag(String pcTag) {
		this.pcTag = pcTag;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Hdd getHdd() {
		return hdd;
	}

	public void setHdd(Hdd hdd) {
		this.hdd = hdd;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public KeyBoard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(KeyBoard keyboard) {
		this.keyboard = keyboard;
	}

	public PowerSupply getPowersupply() {
		return powersupply;
	}

	public void setPowersupply(PowerSupply powersupply) {
		this.powersupply = powersupply;
	}

	public MotherBoard getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(MotherBoard motherboard) {
		this.motherboard = motherboard;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Wifi getWifi() {
		return wifi;
	}

	public void setWifi(Wifi wifi) {
		this.wifi = wifi;
	}

	public Boolean getVt() {
		return vt;
	}

	public void setVt(Boolean vt) {
		this.vt = vt;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Pc [pcTag=" + pcTag + ", processor=" + processor + ", ram=" + ram + ", hdd=" + hdd + ", mouse=" + mouse
				+ ", keyboard=" + keyboard + ", powersupply=" + powersupply + ", motherboard=" + motherboard
				+ ", monitor=" + monitor + ", wifi=" + wifi + ", vt=" + vt + ", location=" + location + "]";
	}

}
