package com.kossine.ims.models;

import java.time.LocalDate;

public class Adapter extends Inventory {
	private long id;
	private String adapterTag;
	private String brand;
	private String serialNum;
	private String modelNum;
	private String supplier;
	private boolean warranty;
	private LocalDate dop;
	private String where;

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

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	@Override
	public String toString() {
		return "Adapter [id=" + id + ", adapterTag=" + adapterTag + "]";
	}

	

}
