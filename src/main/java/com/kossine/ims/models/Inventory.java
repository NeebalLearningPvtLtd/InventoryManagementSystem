package com.kossine.ims.models;

public abstract class Inventory {
	private String name;
	private Class<?> clazz;
	Inventory(String name,Class<?> clazz){	
		this.name=name;
		this.clazz=clazz;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

}
