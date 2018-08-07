package com.ict.erp.vo;

public class Menu {
	private String url;
	private String name;
	private String label;
	
	public Menu(String url, String name, String label) {
		this.url = url;
		this.name = name;
		this.label = label;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		return "Menu [url=" + url + ", name=" + name + ", label=" + label + "]";
	}
	
	
}