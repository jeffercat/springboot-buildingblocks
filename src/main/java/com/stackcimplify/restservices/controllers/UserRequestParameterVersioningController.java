package com.stackcimplify.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackcimplify.restservices.dtos.UserDtoV1;
import com.stackcimplify.restservices.dtos.UserDtoV2;
import com.stackcimplify.restservices.entities.User;
import com.stackcimplify.restservices.exceptions.UserNotFoundException;
import com.stackcimplify.restservices.services.UserService;

@RestController
@RequestMapping("/versioning/params/users")
public class UserRequestParameterVersioningController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	// getUserById
	// Request Parameter  based Versioning - V1
	@GetMapping( value = "/{id}", params = "version=1")

	public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {

		Optional<User> userOptional = userService.getUserById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("user not found");
		}
		User user = userOptional.get();

		UserDtoV1 userDtoV1 = modelMapper.map(user, UserDtoV1.class);
		return userDtoV1;

	}
	
	
	// Request Parameter  based Versioning - V2
	@GetMapping(value = "/{id}", params = "version=2")

	public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {

		Optional<User> userOptional = userService.getUserById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("user not found");
		}
		User user = userOptional.get();

		UserDtoV2 userDtoV2 = modelMapper.map(user, UserDtoV2.class);
		return userDtoV2;

	}

}
