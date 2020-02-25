package com.ibm.request.model;

import java.util.List;

public class DisableOffer {

	private String userName;
	private String groupName;
	private boolean offerDisplayFlag;
	private String loanType;
	private List<LoanDetails> loanDetails;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public boolean isOfferDisplayFlag() {
		return offerDisplayFlag;
	}

	public void setOfferDisplayFlag(boolean offerDisplayFlag) {
		this.offerDisplayFlag = offerDisplayFlag;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public List<LoanDetails> getLoanDetails() {
		return loanDetails;
	}

	public void setLoanDetails(List<LoanDetails> loanDetails) {
		this.loanDetails = loanDetails;
	}

	@Override
	public String toString() {
		return "DisableOffer [userName=" + userName + ", groupName=" + groupName + ", offerDisplayFlag="
				+ offerDisplayFlag + ", loanType=" + loanType + ", loanDetails=" + loanDetails + "]";
	}

}
