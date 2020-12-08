package com.iiht.training.eloan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iiht.training.eloan.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

	@Query("SELECT l FROM Loan l WHERE l.customerId = ?1")
	List<Loan> findAllByCustId(Long customerId);
	
	@Query("SELECT l FROM Loan l WHERE l.status ='processed'")
	List<Loan> findAllProcessedLoan();
	
	@Modifying(clearAutomatically=true)
	@Query("UPDATE Loan l SET l.status = 'rejected', l.remark=:remark where l.id = :loanAppId")
	public void rejectLoan(Long loanAppId,String remark);
	
	
	@Modifying(clearAutomatically=true)
	@Query("UPDATE Loan l SET l.status = :status where l.id = :loanAppId")
	public void setStatusApp(Long loanAppId, String status);
	
}
