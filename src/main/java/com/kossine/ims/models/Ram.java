package com.kossine.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;

import org.hibernate.envers.Audited;
@NamedQueries({
@NamedQuery(query = "Select e from Ram e where e.ramTag= :tag", name = "Ram.getByTag")
})
@Entity
@Audited
public class Ram extends Inventory {
	@Column(name = "ram_tag", unique = true, nullable = false)
	@Pattern(regexp = "^RAM/\\w+/\\w+/\\d+$")
	private String ramTag;
	private String brand;
	@Column(name = "serial_num")
	private String serialNum;
	private String size;
	private String type;
	private String location;
	private Boolean used;
	
	public Ram() {

		super("Ram", Ram.class);
	}

	public String getRamTag() {
		return ramTag;
	}

	public void setRamTag(String ramTag) {
		this.ramTag = ramTag;
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
	public void copy(Ram updated) {
		if (updated.getRamTag() != null)
			setRamTag(updated.getRamTag());
		if (updated.getSerialNum() != null)
			setSerialNum(updated.getSerialNum());
		if (updated.getBrand() != null)
			setBrand(updated.getBrand());
		if (updated.getSize() != null)
			setSize(updated.getSize());
		if (updated.getType() != null)
			setType(updated.getType());
		if (updated.getLocation() != null)
			setLocation(updated.getLocation());
		if (updated.getUsed() != null)
			setUsed(updated.getUsed());

	}

	@Override
	public String toString() {
		return "Ram [ramTag=" + ramTag + ", brand=" + brand + ", serialNum=" + serialNum + ", size=" + size + ", type="
				+ type + ", location=" + location + ", used=" + used + "]";
	}
}
