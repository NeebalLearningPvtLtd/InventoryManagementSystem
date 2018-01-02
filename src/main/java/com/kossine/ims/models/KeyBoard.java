package com.kossine.ims.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
@NamedQueries({
@NamedQuery(query = "Select e from KeyBoard e where e.keyBoardTag= :tag", name = "KeyBoard.getByTag")
})
@Entity
@Table(name="keyboard")
public class KeyBoard extends Inventory {

	@Column(name = "keyboard_tag", unique = true, nullable = false)
	@Pattern(regexp = "^KBD/\\w+/\\w+/\\d+$")
	private String keyBoardTag;
	private String brand;
	@Column(name = "serial_num")
	private String serialNum;
	private String location;
	private Boolean used;
	@OneToOne(mappedBy="keyboard")
	@Transient
	private Pc pc;
	public KeyBoard() {
		super("KeyBoard", KeyBoard.class);
	}

	public String getKeyboardTag() {
		return keyBoardTag;
	}

	public void setKeyboardTag(String keyBoardTag) {
		this.keyBoardTag = keyBoardTag;
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

	@Override
	public String toString() {
		return "KeyBoard [keyboardTag=" + keyBoardTag + ", brand=" + brand + ", serialNum=" + serialNum + ", location="
				+ location + ", used=" + used + "]";
	}

}
