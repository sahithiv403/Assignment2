package com.iiht.training.eloan.dto;

import java.time.LocalDate;

public class SanctionOutputDto {
	private Integer loanAmountSanctioned;
	private Integer termOfLoan;
	private String paymentStartDate;
	private String loanClosureDate;
	private Double monthlyPayment;
	public Integer getLoanAmountSanctioned() {
		return loanAmountSanctioned;
	}
	public void setLoanAmountSanctioned(Integer integer) {
		this.loanAmountSanctioned = integer;
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
	public String getLoanClosureDate() {
		return loanClosureDate;
	}
	public void setLoanClosureDate(String localDate) {
		this.loanClosureDate = localDate;
	}
	public Double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	
	
}
