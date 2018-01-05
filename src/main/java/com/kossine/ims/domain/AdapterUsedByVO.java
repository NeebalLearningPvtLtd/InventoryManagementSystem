package com.kossine.ims.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

public class AdapterUsedByVO {

	private Long id;

	private Long adapter_id;
	private LocalDateTime time;

	@Size(max = 255)
	private String location;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getAdapter_id() {
		return adapter_id;
	}

	public void setAdapter_id(Long adapter_id) {
		this.adapter_id = adapter_id;
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
		return "AdapterUsedByVO [id=" + id + ", adapter_id=" + adapter_id + ", time=" + time + ", location=" + location
				+ "]";
	}

	
}
