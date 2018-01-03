package com.kossine.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;

@NamedQueries({ @NamedQuery(query = "Select e from Hdd e where e.hddTag= :tag", name = "Hdd.getByTag") })
@Entity
public class Hdd extends Inventory {

	@Column(name = "hdd_tag", unique = true, nullable = false)
	@Pattern(regexp = "^HDD/\\w+/\\w+/\\d+$")
	private String hddTag;
	private String brand;
	@Column(name = "serial_num")
	private String serialNum;
	private String size;
	private String type;
	private String location;
	private Boolean used;
	
	public Hdd() {
		super("Hdd", Hdd.class);
	}

	public String getHddTag() {
		return hddTag;
	}

	public void setHddTag(String hddTag) {
		this.hddTag = hddTag;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	@Override
	public String toString() {
		return "Hdd [hddTag=" + hddTag + ", brand=" + brand + ", serialNum=" + serialNum + ", size=" + size + ", type="
				+ type + ", location=" + location + ", used=" + used + "]";
	}

}
