package com.kossine.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;

import org.hibernate.envers.Audited;
@NamedQueries({
@NamedQuery(query = "Select e from Monitor e where e.monitorTag= :tag", name = "Monitor.getByTag")
})
@Entity
@Audited
public class Monitor extends Inventory {
	@Column(name = "monitor_tag", unique = true, nullable = false)
	@Pattern(regexp = "^MON/\\w+/\\w+/\\d+$")
	private String monitorTag;
	private String brand;
	@Column(name = "serial_num")
	private String serialNum;
	@Column(name = "model_num")
	private String modelNum;
	private String resolution;
	private String location;
	private Boolean used;

	public Monitor() {
		super("Monitor", Monitor.class);
	}

	public String getMonitorTag() {
		return monitorTag;
	}

	public void setMonitorTag(String monitorTag) {
		this.monitorTag = monitorTag;
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

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
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
	public void copy(Monitor updated) {
		if (updated.getMonitorTag() != null)
			setMonitorTag(updated.getMonitorTag());
		if (updated.getSerialNum() != null)
			setSerialNum(updated.getSerialNum());
		if (updated.getModelNum() != null)
			setModelNum(updated.getModelNum());
		if (updated.getBrand() != null)
			setBrand(updated.getBrand());
		if (updated.getResolution() != null)
			setResolution(updated.getResolution());
		if (updated.getLocation() != null)
			setLocation(updated.getLocation());
		if (updated.getUsed() != null)
			setUsed(updated.getUsed());
	}
	@Override
	public String toString() {
		return "Monitor [monitorTag=" + monitorTag + ", brand=" + brand + ", serialNum=" + serialNum + ", modelNum="
				+ modelNum + ", resolution=" + resolution + ", location=" + location + ", used=" + used + "]";
	}

}
