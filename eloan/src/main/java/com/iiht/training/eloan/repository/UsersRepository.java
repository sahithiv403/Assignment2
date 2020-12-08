package com.iiht.training.eloan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iiht.training.eloan.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	@Query("SELECT u FROM Users u WHERE u.role = 'clerk'")
	List<Users> findAllByClerks();
	
	@Query("SELECT u FROM Users u WHERE u.role = 'manager'")
	List<Users> findAllByManagers();
	
}
