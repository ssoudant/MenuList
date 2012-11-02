package com.dahuette.menulist;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;

public class Menus {
	private static String TAG = "Menus";
	private Map<Integer, Menu> menus;
	private static Menus m;
	
	public static Menus getInstance() {
		if (m == null) { 
			m = new Menus();
		}
		return m;
	}
	
	private Menus() {
		menus = new HashMap<Integer, Menu>();
	}
	
	public void addDay(Integer id, String day) {
		Menu menu = getMenu(id);
		menu.setDay(day);
	}

	public void addMenu(Integer id, String dish) {
		Menu m = getMenu(id);
		m.setDish(dish);
	}

	private Menu getMenu(Integer id) {
		Menu menu = menus.get(id);
		if (menu == null) {
			menu = new Menu();
			menus.put(id, menu);
		}
		return menu;
	}
		
	public void log() {
		for (Map.Entry<Integer, Menu> entry : menus.entrySet()) {
			Integer i = entry.getKey();
			Menu m = entry.getValue();
			Log.i(TAG, "Menu du " + m.getDay() + " id:" + i + ": " + m.getDish());
		}
	}
}