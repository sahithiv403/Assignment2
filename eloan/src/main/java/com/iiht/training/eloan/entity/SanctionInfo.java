package com.iiht.training.eloan.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sanctionInfo")
public class SanctionInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long loanAppId;
	private Long managerId;
	private Integer loanAmountSanctioned;
	private Integer termOfLoan;
	private String paymentStartDate;
	private String loanClosureDate;
	private Double monthlyPayment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLoanAppId() {
		return loanAppId;
	}
	public void setLoanAppId(Long loanAppId) {
		this.loanAppId = loanAppId;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
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
	public void setLoanClosureDate(String loanClosureDate) {
		this.loanClosureDate = loanClosureDate;
	}
	public Double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

}
