package com.tunguyen;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class Chao extends ActionSupport {
	private String string;
	private String language;
	private String id;

	@Override
	public String execute() {
		setString("Nguyen van tu");
		System.out.println("lang = " + getLanguage());
		System.out.println("id = " + getId());
		return SUCCESS;
	}
	
	public String chaochao(){
		System.out.println("chaochaomethod");
		return SUCCESS;
	}
	
	@Override
	public void validate() { 
		if(StringUtils.isEmpty(id.trim())){
			// id is empty
			addFieldError("id", "id blank");
		}
		super.validate();
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
