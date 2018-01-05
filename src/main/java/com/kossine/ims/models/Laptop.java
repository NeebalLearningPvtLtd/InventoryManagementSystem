package com.kossine.ims.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Pattern;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@NamedQueries({ @NamedQuery(query = "select e from Laptop e where e.laptopTag = :tag", name = "Laptop.getByTag"),
		@NamedQuery(query = "Select e from Laptop e where e.laptopTag like :laptopTag", name = "getByLaptopTagLikeQuery") })

@Entity
@Audited
public class Laptop extends Inventory {
	@Column(name = "laptop_tag", unique = true, nullable = false)
	@NotEmpty
	@Pattern(regexp = "^LAP/\\w+/\\w+/\\d+$")
	private String laptopTag;

	@Column(name = "serial_num")
	private String serialNum;
	@Column(name = "brand")
	private String brand;
	@Column(name = "battery_serial_num")
	private String batterySerialNum;
	@Column(name = "model_num")
	private String modelNum;

	private String processor;
	private String ram;
	private String hdd;
	private String supplier;
	private Boolean vt;
	private Boolean wifi;
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dop;

	private Boolean warranty;

	public Laptop() {
		super("Laptop", Laptop.class);
	}

	// change constructor parameter later
	public Laptop(String laptopTag, String serialNum, String supplier) {
		this();
		setLaptopTag(laptopTag);
		setSerialNum(serialNum);
		setSupplier(supplier);
		modelNum = brand = batterySerialNum = processor = hdd = ram = "";
		vt = wifi = warranty = false;

	}

	public String getLaptopTag() {
		return laptopTag;
	}

	public void setLaptopTag(String laptopTag) {
		this.laptopTag = laptopTag;
	}

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBatterySerialNum() {
		return batterySerialNum;
	}

	public void setBatterySerialNum(String batterySerialNum) {
		this.batterySerialNum = batterySerialNum;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public Boolean getVt() {
		return vt;
	}

	public void setVt(Boolean vt) {
		this.vt = vt;
	}

	public Boolean isWifi() {
		return wifi;
	}

	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}

	public LocalDate getDop() {
		return dop;
	}

	public void setDop(LocalDate dop) {
		this.dop = dop;
	}

	public Boolean isWarranty() {
		return warranty;
	}

	public void setWarranty(Boolean warranty) {
		this.warranty = warranty;
	}

	public void copy(Laptop updated) {
		if (updated.getLaptopTag() != null)
			setLaptopTag(updated.getLaptopTag());
		if (updated.getSerialNum() != null)
			setSerialNum(updated.getSerialNum());
		if (updated.getModelNum() != null)
			setModelNum(updated.getModelNum());
		if (updated.getBatterySerialNum() != null)
			setBatterySerialNum(updated.getBatterySerialNum());
		if (updated.getBrand() != null)
			setBrand(updated.getBrand());
		if (updated.getProcessor() != null)
			setProcessor(updated.getProcessor());
		if (updated.getRam() != null)
			setRam(updated.getRam());
		if (updated.getHdd() != null)
			setHdd(updated.getHdd());
		if (updated.getSupplier() != null)
			setSupplier(updated.getSupplier());
		if (updated.getVt() != null)
			setVt(updated.getVt());
		if (updated.isWifi() != null)
			setWifi(updated.isWifi());
		if (updated.getDop() != null)
			setDop(updated.getDop());
		if (updated.isWarranty() != null)
			setWarranty(updated.isWarranty());

	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", laptopTag=" + laptopTag + "]";
	}

}
