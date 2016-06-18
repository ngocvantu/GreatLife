package com.tunguyen;

import java.util.ArrayList;
import java.util.List;

import com.object.Language;
import com.opensymphony.xwork2.ActionSupport;

public class RadioButtonAction extends ActionSupport {
	List<String> genders;
	List<Language> languages; 
	
	private String yourGender;
	private String yourAnswer;
	private String yourLanguage;
	
	private static final String MALE = "xin cào";
	private static final String FEMALE = "female";
	private static final String UNKNOWN = "unknown";
	
	public RadioButtonAction() {
		genders = new ArrayList<String>();
		genders.add(MALE);
		genders.add(FEMALE);
		genders.add(UNKNOWN);
		
		languages = new ArrayList<Language>();
		languages.add( new Language("EN", "English") );
		languages.add( new Language("FR", "France") );
		languages.add( new Language("CN_ZH", "Chinese") );
		languages.add( new Language("DE", "German") );
	}
	
	//return default gender value
		public String getDefaultGenderValue(){
			return UNKNOWN;
		}

		//return default language value
		public String getDefaultLanguageValue(){
			return "CN_ZH";
		}
		
		public String execute() {
			return SUCCESS;
		}
		public String display() {
			return NONE;
		}

		public List<String> getGenders() {
			return genders;
		}

		public void setGenders(List<String> genders) {
			this.genders = genders;
		}

		public List<Language> getLanguages() {
			return languages;
		}

		public void setLanguages(List<Language> languages) {
			this.languages = languages;
		}

		public String getYourGender() {
			return yourGender;
		}

		public void setYourGender(String yourGender) {
			this.yourGender = yourGender;
		}

		public String getYourAnswer() {
			return yourAnswer;
		}

		public void setYourAnswer(String yourAnswer) {
			this.yourAnswer = yourAnswer;
		}

		public String getYourLanguage() {
			return yourLanguage;
		}

		public void setYourLanguage(String yourLanguage) {
			this.yourLanguage = yourLanguage;
		}

		public static String getMale() {
			return MALE;
		}

		public static String getFemale() {
			return FEMALE;
		}

		public static String getUnknown() {
			return UNKNOWN;
		}
		
		
	
}
