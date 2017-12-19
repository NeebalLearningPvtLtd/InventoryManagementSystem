package com.kossine.ims.exceptions;

@SuppressWarnings("serial")
public class ModelNotFoundException extends Exception {
	
	private String errors;
	public ModelNotFoundException() {
		super("Entity was not found while retrieving from database");
	}
	
	public ModelNotFoundException(String msg,String cause) {
		super(msg);
		this.errors=cause;
	}
	public String getErrors(){
		return this.errors;
	}
}
