package com.kossine.ims.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@JsonIgnoreProperties({"clazz","name"})
public abstract class Inventory {
	@Transient
	private String name;
	@Transient
	private Class<?> clazz;

	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false)
	protected long id;

	Inventory(String name, Class<?> clazz) {
		this.name = name;
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
