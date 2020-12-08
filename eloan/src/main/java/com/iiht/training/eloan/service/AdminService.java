package com.iiht.training.eloan.service;

import java.util.List;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.ExceptionResponse;

public interface AdminService {

	
	public UserDto registerClerk(UserDto userDto) throws ExceptionResponse;
		
	public UserDto registerManager(UserDto userDto) throws ExceptionResponse;
	
	public List<UserDto> getAllClerks();
		
	public List<UserDto> getAllManagers();

	
}
