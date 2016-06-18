package com.tunguyen;

import org.apache.commons.lang3.StringUtils;

import com.object.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Chao extends ActionSupport implements ModelDriven<Customer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String string;
	private String language;
	private String id;
	private String password;
	  Customer customer =new Customer();

	@Override
	public String execute() {
		setString("Nguyen van tu");
		System.out.println("lang = " + getLanguage());
		System.out.println("id = " + getId());
		System.out.println(customer.getName());
		return SUCCESS;
	}
	
	public String chaochao(){ 
		if (customer.getName().trim().equals("tunguyen") && customer.getPassword().trim().equals("tunguyen")) {
			return SUCCESS;
		} else {
			return INPUT;
		}
		
	}
	
	@Override
	public void validate() { 
		if(StringUtils.isEmpty(customer.getName().trim())){
			// id is empty
			addFieldError("name", "id blank");
			addActionError("có lỗi xảy ra");
			addActionMessage("chao ban");
			
			
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

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
