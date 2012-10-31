package com.dahuette.menulist;

public class Menu {
	private String apetizer;
	private String starter;
	private String main;
	private String dessert;
	
	public Menu(String apetizer, String starter, String main, String dessert) {
		this.apetizer = apetizer;
		this.starter = starter;
		this.main = main;
		this.dessert = dessert;
	}
	
	public Menu(String starter, String main, String dessert) {
		this.starter = starter;
		this.main = main;
		this.dessert = dessert;
	}
	
	public Menu(String main) {
		this.main = main;
	}
	
	public String getApetizer() {
		return apetizer;
	}

	public String getStarter() {
		return starter;
	}
	
	public String getMain() {
		return main;
	}
	
	public String getDessert() {
		return dessert;
	}
}
