package com.sistemi.informativi.dto;

import java.io.Serializable;

public class CompanyDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String vatNumber;
	private String businessName;
	private String addressLocation;
	private int employeesNumber;
	

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getAddressLocation() {
		return addressLocation;
	}

	public void setAddressLocation(String addressLocation) {
		this.addressLocation = addressLocation;
	}

	public int getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(int employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

	protected CompanyDTO() {};
	
	public CompanyDTO(String vatNumber, String businessName, String addressLocation, int employeesNumber) {
		super();
		this.vatNumber = vatNumber;
		this.businessName = businessName;
		this.addressLocation = addressLocation;
		this.employeesNumber = employeesNumber;
	}

	@Override
	public String toString() {
		return "CompanyDTO [vatNumber=" + vatNumber + ", businessName=" + businessName + ", addressLocation="
				+ addressLocation + ", employeesNumber=" + employeesNumber + "]";
	}
	
}
