package com.kossine.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;

import org.hibernate.envers.Audited;
@NamedQueries({
@NamedQuery(query = "Select e from Wifi e where e.wifiTag= :tag", name = "Wifi.getByTag")
})
@Entity
@Audited
public class Wifi extends Inventory {

	@Column(name = "wifi_tag", unique = true, nullable = false)
	@Pattern(regexp = "^WIFI/\\w+/\\w+/\\d+$")
	private String wifiTag;
	private String brand;
	@Column(name = "model_num")
	private String modelNum;
	private String location;
	private Boolean used;

	public Wifi() {
		super("Wifi", Wifi.class);
	}

	public String getWifiTag() {
		return wifiTag;
	}

	public void setWifiTag(String wifiTag) {
		this.wifiTag = wifiTag;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
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
	public void copy(Wifi updated) {
		if (updated.getWifiTag() != null)
			setWifiTag(updated.getWifiTag());
		if (updated.getModelNum() != null)
			setModelNum(updated.getModelNum());
		if (updated.getBrand() != null)
			setBrand(updated.getBrand());
		if (updated.getLocation() != null)
			setLocation(updated.getLocation());
		if (updated.getUsed() != null)
			setUsed(updated.getUsed());

	}	@Override
	public String toString() {
		return "Wifi [wifiTag=" + wifiTag + ", brand=" + brand + ", modelNum=" + modelNum + ", location=" + location
				+ ", used=" + used + "]";
	}

}
