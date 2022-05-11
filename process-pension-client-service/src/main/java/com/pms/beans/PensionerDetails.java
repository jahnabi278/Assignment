package com.pms.beans;

import java.util.Date;
import java.util.List;

public class PensionerDetails {
	private String adharNumber;
	private String name;
	private Date dob;
	private String pan;
	private float salaryEarned;
	private float allowances;
	private PensionType pensionType;
	private List<BankDetails> bankDetails;

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public float getSalaryEarned() {
		return salaryEarned;
	}

	public void setSalaryEarned(float salaryEarned) {
		this.salaryEarned = salaryEarned;
	}

	public float getAllowances() {
		return allowances;
	}

	public void setAllowances(float allowances) {
		this.allowances = allowances;
	}

	public PensionType getPensionType() {
		return pensionType;
	}

	public void setPensionType(PensionType pensionType) {
		this.pensionType = pensionType;
	}

	public List<BankDetails> getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(List<BankDetails> bankDetails) {
		this.bankDetails = bankDetails;
	}

}
