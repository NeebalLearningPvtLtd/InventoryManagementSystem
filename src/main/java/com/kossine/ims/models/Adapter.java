package com.kossine.ims.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@NamedQueries({ @NamedQuery(query = "Select e from Adapter e where e.adapterTag= :adapterTag", name = "getByAdapterTag"),

})
@Entity
public class Adapter extends Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private long id;
	@Column(name = "adapter_tag", unique = true, nullable = false)
	private String adapterTag;
	private String brand;
	@Column(name = "serial_num")
	private String serialNum;
	@Column(name = "model_num")
	private String modelNum;
	private String supplier;
	private boolean warranty;

	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	@Column(nullable = true)
	private LocalDate dop;

	public Adapter() {
		super("Adapter", Adapter.class);
	}

	// change constructor parameter later
	public Adapter(String adapterTag, String brand, String supplier) {
		this();
		this.adapterTag = adapterTag;
		this.brand = brand;
		this.supplier = supplier;
		serialNum = modelNum = "";
		warranty = false;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdapterTag() {
		return adapterTag;
	}

	public void setAdapterTag(String adapterTag) {
		this.adapterTag = adapterTag;
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

	public LocalDate getDop() {
		return dop;
	}

	public void setDop(LocalDate dop) {
		this.dop = dop;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public boolean isWarranty() {
		return warranty;
	}

	public void setWarranty(boolean warranty) {
		this.warranty = warranty;
	}

	@Override
	public String toString() {
		return "Adapter [id=" + id + ", adapterTag=" + adapterTag + "]";
	}

}
