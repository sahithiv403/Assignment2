package com.iiht.training.eloan.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.dto.RejectDto;
import com.iiht.training.eloan.dto.SanctionDto;
import com.iiht.training.eloan.dto.SanctionOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.ProcessingInfo;
import com.iiht.training.eloan.entity.SanctionInfo;
import com.iiht.training.eloan.entity.Users;

public class EMParser {

	public static LoanDto parse(Loan source) {
		LoanDto target = new LoanDto();
		
		target.setLoanName(source.getLoanName());
		target.setLoanAmount(source.getLoanAmount());
		target.setLoanApplicationDate(source.getLoanApplicationDate());
		target.setBusinessStructure(source.getBusinessStructure());
		target.setBillingIndicator(source.getBillingIndicator());
		target.setTaxIndicator(source.getTaxIndicator());
		
		return target;
	}
	
	
	public static LoanOutputDto parseo(Loan source) {
		LoanOutputDto target = new LoanOutputDto();
		
		target.setLoanAppId(source.getId());
		target.setCustomerId(source.getCustomerId());
		target.setRemark(source.getRemark());
		target.setStatus(source.getStatus());
		target.setLoanDto(parse(source));
		
		return target;
	}
	
	public static Loan parse(LoanDto source,Long customerId)
	{
		Loan target = new Loan();
		
		target.setCustomerId(customerId);
		target.setStatus("submitted");
		target.setLoanName(source.getLoanName());
		target.setLoanAmount(source.getLoanAmount());
	
		target.setLoanApplicationDate(source.getLoanApplicationDate());
		target.setBusinessStructure(source.getBusinessStructure());
		target.setBillingIndicator(source.getBillingIndicator());
		target.setTaxIndicator(source.getTaxIndicator());
		
		return target;
		
	}

	public static Users parse(UserDto source) {
		Users target = new Users();
		
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole(source.getRole());
				
		return target;
	}
	
	public static UserDto parse(Users source) {
		UserDto target = new UserDto();
		
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole(source.getRole());
		return target;
	}
	
	public static ProcessingDto parse(ProcessingInfo source) {
		ProcessingDto target = new ProcessingDto();
		
		target.setAcresOfLand(source.getAcresOfLand());
		target.setLandValue(source.getLandValue());
		target.setAppraisedBy(source.getAppraisedBy());
		target.setValuationDate(source.getValuationDate());
		target.setAddressOfProperty(source.getAddressOfProperty());
		target.setSuggestedAmountOfLoan(source.getSuggestedAmountOfLoan());
		
		return target;
	}
	
	public static ProcessingInfo parse(ProcessingDto source, Long clerkId, Long loanAppId) {
		ProcessingInfo target = new ProcessingInfo();
		
		target.setLoanAppId(loanAppId);
		target.setLoanClerkId(clerkId);
		target.setAcresOfLand(source.getAcresOfLand());
		target.setLandValue(source.getLandValue());
		target.setAppraisedBy(source.getAppraisedBy());
		target.setValuationDate(source.getValuationDate());
		target.setAddressOfProperty(source.getAddressOfProperty());
		target.setSuggestedAmountOfLoan(source.getSuggestedAmountOfLoan());
		
		
		return target;
	}

	public static Loan parse(RejectDto rejectDto, Long managerId, Long loanAppId) {
		Loan target= new Loan();
		target.setRemark(rejectDto.getRemark());
		return target;
	
		
	}
	
	public static RejectDto parse(Loan source, Long managerId, Long loanAppId) {
		RejectDto target= new RejectDto();
		
		target.setRemark(source.getRemark());
		return target;
		
	}

	public static SanctionDto parse(SanctionInfo source) {
		SanctionDto target = new SanctionDto();
		
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setPaymentStartDate(source.getPaymentStartDate());
		target.setTermOfLoan(source.getTermOfLoan());
		
		return target;
	}

	
	public static SanctionInfo parse(SanctionDto source, Long managerId, Long loanAppId) {
		SanctionInfo target = new SanctionInfo();
		
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());		 
		target.setPaymentStartDate(source.getPaymentStartDate().toString());
		target.setTermOfLoan(source.getTermOfLoan());
		target.setLoanAppId(loanAppId);
		target.setManagerId(managerId);
		return target;
	}
	
	public static SanctionInfo parse(SanctionDto source, Long managerId, Long loanAppId,LocalDate loanClosureDate,Double monthlyPayment) {
		SanctionInfo target = new SanctionInfo();
		
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setPaymentStartDate(source.getPaymentStartDate().toString());
		target.setTermOfLoan(source.getTermOfLoan());
		target.setLoanAppId(loanAppId);
		target.setManagerId(managerId);
		target.setLoanClosureDate(loanClosureDate.toString());
		target.setMonthlyPayment(monthlyPayment);
		return target;
	}
	

	public static SanctionOutputDto parseop(SanctionInfo source) {
		SanctionOutputDto target = new SanctionOutputDto();
		
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setLoanClosureDate(source.getLoanClosureDate());
		target.setMonthlyPayment(source.getMonthlyPayment());
		target.setPaymentStartDate(source.getPaymentStartDate());
		target.setTermOfLoan(source.getTermOfLoan());
		
		return target;
	}


	
	

}
