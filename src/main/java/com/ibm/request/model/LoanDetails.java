package com.ibm.request.model;

public class LoanDetails {

	private String loanNumber;
	private String zipCode;
	private String reason;

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "LoanDetails [loanNumber=" + loanNumber + ", zipCode=" + zipCode + ", reason=" + reason + "]";
	}

}
