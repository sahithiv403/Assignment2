package com.iiht.training.eloan.dto;

import java.time.LocalDate;

public class SanctionDto {
	private Integer loanAmountSanctioned;
	private Integer termOfLoan;
	private String paymentStartDate;
	public Integer getLoanAmountSanctioned() {
		return loanAmountSanctioned;
	}
	public void setLoanAmountSanctioned(Integer loanAmountSanctioned) {
		this.loanAmountSanctioned = loanAmountSanctioned;
	}
	public Integer getTermOfLoan() {
		return termOfLoan;
	}
	public void setTermOfLoan(Integer termOfLoan) {
		this.termOfLoan = termOfLoan;
	}
	public String getPaymentStartDate() {
		return paymentStartDate;
	}
	public void setPaymentStartDate(String paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}
	
	
}
