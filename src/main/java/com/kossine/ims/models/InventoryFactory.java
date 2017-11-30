package com.kossine.ims.models;

public class InventoryFactory {
	public static Class<? extends Inventory> getClazz(String name) {
		if (name.equals("Laptop"))
			return Laptop.class;
		if (name.equals("Adapter"))
			return Adapter.class;
		// add more
		return null;
	}
}
