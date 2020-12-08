package com.iiht.training.eloan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.dto.exception.ExceptionResponse;
import com.iiht.training.eloan.service.AdminService;
import com.iiht.training.eloan.service.ExceptionApi;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/register-clerk")
	public ResponseEntity<UserDto> registerClerk(@RequestBody @Valid UserDto userDto, BindingResult result)
			throws ExceptionResponse {

		ResponseEntity<UserDto> response = null;

		if (result.hasErrors()) {
			throw new ExceptionResponse(ExceptionApi.toErrMsg(result.getAllErrors()),System.currentTimeMillis(),
					  HttpStatus.NOT_FOUND.value());

		} else {

			userDto = adminService.registerClerk(userDto);
			response = new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		}

		return response;
	}

	@PostMapping("/register-manager")
	public ResponseEntity<UserDto> registerManager(@RequestBody @Valid UserDto userDto, BindingResult result)
			throws ExceptionResponse {

		ResponseEntity<UserDto> response = null;

		if (result.hasErrors()) {
			throw new ExceptionResponse(ExceptionApi.toErrMsg(result.getAllErrors()),System.currentTimeMillis(),
					  HttpStatus.NOT_FOUND.value());

		} else {

			userDto = adminService.registerManager(userDto);
			response = new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
		}

		return response;
	}

	@GetMapping("/all-clerks")
	public ResponseEntity<List<UserDto>> getAllClerks() {
		return new ResponseEntity<List<UserDto>>(adminService.getAllClerks(), HttpStatus.OK);
	}

	@GetMapping("/all-managers")
	public ResponseEntity<List<UserDto>> getAllManagers() {
		return new ResponseEntity<List<UserDto>>(adminService.getAllManagers(), HttpStatus.OK);
	}

}
