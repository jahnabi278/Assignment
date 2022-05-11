package com.pms.beans;

public class BankDetails {
	private String bankName;
	private String accountNumber;
	private BankType banktype;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BankType getBanktype() {
		return banktype;
	}

	public void setBanktype(BankType banktype) {
		this.banktype = banktype;
	}
}
