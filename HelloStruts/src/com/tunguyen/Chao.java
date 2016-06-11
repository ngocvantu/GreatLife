package com.tunguyen;

public class Chao {
	private String string;
	private String language;
	private String id;

	public String execute() {
		setString("Nguyen van tu");
		System.out.println("lang = " + getLanguage());
		System.out.println("id = " + getId());
		return "success";
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
