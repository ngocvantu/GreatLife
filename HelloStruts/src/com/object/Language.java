package com.object;

public class Language {
	String languageCode;
	String languageDisplay;
	
	
	
	public Language(String languageCode, String languageDisplay) {
		super();
		this.languageCode = languageCode;
		this.languageDisplay = languageDisplay;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getLanguageDisplay() {
		return languageDisplay;
	}
	public void setLanguageDisplay(String languageDisplay) {
		this.languageDisplay = languageDisplay;
	}
	
	
}
