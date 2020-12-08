package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.ExceptionResponse;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.AdminService;
import com.iiht.training.eloan.service.EMParser;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Transactional
	@Override
	public UserDto registerClerk(UserDto userDto) throws ExceptionResponse {
		if(userDto!=null) {
			if(usersRepository.existsById(userDto.getId())) {
				throw new ExceptionResponse("user"+userDto.getId()+" already exists",new java.util.Date().getTime(),404);
			}
			userDto = EMParser.parse(usersRepository.save(EMParser.parse(userDto)));
			
		}
		return userDto;
	}

	@Transactional
	@Override
	public UserDto registerManager(UserDto userDto) throws ExceptionResponse {
		if(userDto!=null) {
			if(usersRepository.existsById(userDto.getId())) {
				throw new ExceptionResponse("user"+userDto.getId()+" already exists",new java.util.Date().getTime(),404);
			}
			userDto = EMParser.parse(usersRepository.save(EMParser.parse(userDto)));
			
		}
		return userDto;
	}

	
	@Override
	public List<UserDto> getAllClerks() {
		
		return usersRepository.findAllByClerks()
				.stream().map(e->EMParser.parse(e)).collect(Collectors.toList());
		
	}

	@Override
	public List<UserDto> getAllManagers() {
		return usersRepository.findAllByManagers()
				.stream().map(e->EMParser.parse(e)).collect(Collectors.toList());
	}

}
