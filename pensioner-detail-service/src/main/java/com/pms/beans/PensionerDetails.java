package com.pms.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pensionerdetails")
public class PensionerDetails {
	@Id
	private String adharNumber;
	@NotBlank(message = "Name is a mandatory field !")
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@NotBlank(message = "pan number is a mandatory field !")
	private String pan;
	@Min(value = 100, message = "salary can not be less than 100")
	private float salaryEarned;
	@Min(value = 1000, message = "allowances can not be less than 1000")
	private float allowances;
	@Enumerated(EnumType.STRING)
	private PensionType pensionType;
	@OneToMany(cascade = CascadeType.ALL)
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
