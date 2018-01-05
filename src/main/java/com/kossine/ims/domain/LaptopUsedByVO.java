package com.kossine.ims.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

public class LaptopUsedByVO {

	private Long id;

	private Long laptop_id;
	private LocalDateTime time;

	@Size(max = 255)
	private String location;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getLaptop_id() {
		return laptop_id;
	}

	public void setLaptop_id(Long laptop_id) {
		this.laptop_id = laptop_id;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "LaptopUsedByVO [id=" + id + ", laptop_id=" + laptop_id + ", time=" + time + ", location=" + location
				+ "]";
	}

}
