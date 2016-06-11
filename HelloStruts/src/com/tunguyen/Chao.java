package com.tunguyen;

public class Chao {
	private String string;

	public String execute() {
		setString("Nguyen van tu");
		return "success";
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
