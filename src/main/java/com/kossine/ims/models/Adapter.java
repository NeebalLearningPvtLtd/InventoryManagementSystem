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

@NamedQueries({ @NamedQuery(query = "select e from Adapter e where e.adapterTag = :tag", name = "Adapter.getByTag"),
		@NamedQuery(query = "Select e from Adapter e where e.adapterTag like :adapterTag", name = "getByAdapterTagLikeQuery"), })
@Entity
@Audited
public class Adapter extends Inventory {
	@Column(name = "adapter_tag", unique = true, nullable = false)
	@NotEmpty
	@Pattern(regexp = "^ADP/\\w+/\\w+/\\d+$")
	private String adapterTag;
	private String brand;
	@Column(name = "serial_num")
	private String serialNum;
	@Column(name = "model_num")
	private String modelNum;

	private String supplier;
	private Boolean warranty;

	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
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

	public Boolean isWarranty() {
		return warranty;
	}

	public void setWarranty(Boolean warranty) {
		this.warranty = warranty;
	}

	public void copy(Adapter updated) {
		if (updated.getAdapterTag() != null)
			setAdapterTag(updated.getAdapterTag());
		if (updated.getSerialNum() != null)
			setSerialNum(updated.getSerialNum());
		if (updated.getModelNum() != null)
			setModelNum(updated.getModelNum());
		if (updated.getBrand() != null)
			setBrand(updated.getBrand());
		if (updated.getSupplier() != null)
			setSupplier(updated.getSupplier());
		if (updated.getDop() != null)
			setDop(updated.getDop());
		if (updated.isWarranty() != null)
			setWarranty(updated.isWarranty());

	}

	@Override
	public String toString() {
		return "Adapter [id=" + id + ", adapterTag=" + adapterTag + "]";
	}

}
