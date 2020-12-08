package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.exception.LoanNotFoundException;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.service.ClerkService;
import com.iiht.training.eloan.service.EMParser;

@Service
public class ClerkServiceImpl implements ClerkService {

	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;
	
	@Override
	public List<LoanOutputDto> allAppliedLoans() {
		return loanRepository.findAll().stream().map(e->EMParser.parseo(e)).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public ProcessingDto processLoan(Long clerkId, Long loanAppId, ProcessingDto processingDto) {
		
		if(processingDto!=null) {
			if(!loanRepository.existsById(loanAppId)) {
				throw new LoanNotFoundException("Loan" + loanAppId + "  does not exists");
			}
			
			
			processingDto = EMParser.parse(pProcessingInfoRepository.save(EMParser.parse(processingDto,clerkId,loanAppId)));
			loanRepository.setStatusApp(loanAppId,"processed");
		
		}
		  return processingDto;
	}
}
