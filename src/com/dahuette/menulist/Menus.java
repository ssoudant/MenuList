package com.dahuette.menulist;

import java.util.HashMap;
import java.util.Map;

public class Menus {
	private Map<String,Menu> menus;
	private static Menus m;
	
	public static Menus getInstance() {
		if (m == null) { 
			m = new Menus();
		}
		return m;
	}
	
	private Menus() {
		// FIXME : voir si on a besoin de trier les éléments selon le jour du repas
		menus = new HashMap<String, Menu>();
	}
	
	public void addMenu(String d) {
		menus.put(d, null);
	}

	public void putMenu(String d, Menu n) {
		menus.put(d, n);
		// FIXME : gérer les retours n'est pas interdit, voir si c'est utile
	}
	
	public void removeMenu(String d) {
		menus.remove(d);
		// FIXME : gérer les retours n'est pas interdit, voir si c'est utile
	}
}
