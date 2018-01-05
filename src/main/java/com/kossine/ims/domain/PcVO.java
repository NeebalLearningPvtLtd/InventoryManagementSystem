package com.kossine.ims.domain;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class PcVO {
	private Long id;
	@Pattern(regexp = "^PC/\\w+/\\w+/\\d+$")
	@NotEmpty
	private String PcTag;
	private String Processor;
	private String location;
	private Boolean vt;
	private Long ram_id;
	private Long hdd_id;
	private Long mouse_id;
	private Long keyboard_id;
	private Long monitor_id;
	private Long motherboard_id;
	private Long powersupply_id;
	private Long wifi_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPcTag() {
		return PcTag;
	}
	public void setPcTag(String pcTag) {
		PcTag = pcTag;
	}
	public String getProcessor() {
		return Processor;
	}
	public void setProcessor(String processor) {
		Processor = processor;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getRam_id() {
		return ram_id;
	}
	public void setRam_id(Long ram_id) {
		this.ram_id = ram_id;
	}
	public Long getHdd_id() {
		return hdd_id;
	}
	public void setHdd_id(Long hdd_id) {
		this.hdd_id = hdd_id;
	}
	public Long getMouse_id() {
		return mouse_id;
	}
	public void setMouse_id(Long mouse_id) {
		this.mouse_id = mouse_id;
	}
	public Long getKeyboard_id() {
		return keyboard_id;
	}
	public void setKeyboard_id(Long keyboard_id) {
		this.keyboard_id = keyboard_id;
	}
	public Long getMonitor_id() {
		return monitor_id;
	}
	public void setMonitor_id(Long monitor_id) {
		this.monitor_id = monitor_id;
	}
	public Long getMotherboard_id() {
		return motherboard_id;
	}
	public void setMotherboard_id(Long motherboard_id) {
		this.motherboard_id = motherboard_id;
	}
	public Long getPowersupply_id() {
		return powersupply_id;
	}
	public void setPowersupply_id(Long powersupply_id) {
		this.powersupply_id = powersupply_id;
	}
	public Long getWifi_id() {
		return wifi_id;
	}
	public void setWifi_id(Long wifi_id) {
		this.wifi_id = wifi_id;
	}
	public Boolean getVt() {
		return vt;
	}
	public void setVt(Boolean vt) {
		this.vt = vt;
	}
	@Override
	public String toString() {
		return "Pc [PcTag=" + PcTag + ", Processor=" + Processor + ", location=" + location + ", vt=" + vt + ", ram_id="
				+ ram_id + ", hdd_id=" + hdd_id + ", mouse_id=" + mouse_id + ", keyboard_id=" + keyboard_id
				+ ", monitor_id=" + monitor_id + ", motherboard_id=" + motherboard_id + ", powersupply_id="
				+ powersupply_id + ", wifi_id=" + wifi_id + "]";
	}
	
}