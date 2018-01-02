package com.kossine.ims.models;

public class InventoryFactory {
	@SuppressWarnings("unchecked")
	public static Class<? extends Inventory> getClazz(String name) {
		
		try {
			return (Class<? extends Inventory>) Class.forName("com.kossine.ims.models."+name);
		
		} catch (ClassNotFoundException e ) {
			return null;
		}
		
	}
}
