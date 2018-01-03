package com.kossine.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;
@NamedQueries({
@NamedQuery(query = "Select e from Mouse e where e.mouseTag= :tag", name = "Mouse.getByTag")
})
@Entity
public class Mouse extends Inventory {

	@Column(name = "mouse_tag", unique = true, nullable = false)
	@Pattern(regexp = "^MOU/\\w+/\\w+/\\d+$")
	private String mouseTag;
	private String brand;
	@Column(name = "serial_num")
	private String serialNum;
	@Column(name = "conn_type")
	private String connType;
	private String location;
	private Boolean used;

	public Mouse() {
		super("Mouse", Mouse.class);
	}

	public String getMouseTag() {
		return mouseTag;
	}

	public void setMouseTag(String mouseTag) {
		this.mouseTag = mouseTag;
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

	public String getConnType() {
		return connType;
	}

	public void setConnType(String connType) {
		this.connType = connType;
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
		return "Mouse [mouseTag=" + mouseTag + ", brand=" + brand + ", serialNum=" + serialNum + ", connType="
				+ connType + ", location=" + location + ", used=" + used + "]";
	}
}
