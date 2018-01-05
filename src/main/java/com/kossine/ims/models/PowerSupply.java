package com.kossine.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.envers.Audited;
@NamedQueries({
@NamedQuery(query = "Select e from PowerSupply e where e.powerSupplyTag= :tag", name = "PowerSupply.getByTag")
})
@Entity
@Table(name="powersupply")
@Audited
public class PowerSupply extends Inventory {
	@Column(name = "powersupply_tag", unique = true, nullable = false)
	@Pattern(regexp = "^PWS/\\w+/\\w+/\\d+$")
	private String powerSupplyTag;
	private String brand;
	@Column(name = "serial_num")
	private String serialNum;
	private String location;
	private Boolean used;

	public PowerSupply() {
		super("PowerSupply", PowerSupply.class);
	}

	public String getPowersupplyTag() {
		return powerSupplyTag;
	}

	public void setPowersupplyTag(String powersupplyTag) {
		this.powerSupplyTag = powersupplyTag;
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
	public void copy(PowerSupply updated) {
		if (updated.getPowersupplyTag() != null)
			setPowersupplyTag(updated.getPowersupplyTag());
		if (updated.getSerialNum() != null)
			setSerialNum(updated.getSerialNum());
		if (updated.getBrand() != null)
			setBrand(updated.getBrand());
		if (updated.getLocation() != null)
			setLocation(updated.getLocation());
		if (updated.getUsed() != null)
			setUsed(updated.getUsed());

	}
	@Override
	public String toString() {
		return "PowerSupply [powersupplyTag=" + powerSupplyTag + ", brand=" + brand + ", serialNum=" + serialNum
				+ ", location=" + location + ", used=" + used + "]";
	}
}
