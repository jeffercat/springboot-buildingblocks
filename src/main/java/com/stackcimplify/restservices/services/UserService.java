package com.stackcimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stackcimplify.restservices.entities.User;
import com.stackcimplify.restservices.exceptions.UserExistsException;
import com.stackcimplify.restservices.exceptions.UserNotFoundException;
import com.stackcimplify.restservices.repositories.UserRepository;

//Service
@Service
public class UserService {

	// Autowire the UserRepository
	@Autowired
	private UserRepository userRepository;

	// getAllUsers method
	public List<User> getAllUsers() {

		return userRepository.findAll();

	}

	// createUser Method
	public User createUser(User user) throws UserExistsException {
		//if user exist using username
		User existingUser= userRepository.findByUsername(user.getUsername());
		//if not exist throw UserExistsException
		if(existingUser !=null) {
			throw new UserExistsException("User already exists in repository");
		}	
		
		return userRepository.save(user);
	}

	// getUserById
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not found in user Repository");
		}

		return user;
	}

	// updateUserById Method
	public User updateUserById(Long id, User user) throws UserNotFoundException {

		Optional<User> optionalUser = userRepository.findById(id);

		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not found in user Repository, provide the correct user id");
		}

		user.setId(id);

		return userRepository.save(user);
	}

	// deleteUserById Method
	public void deleteUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"User Not found in user Repository, provide the correct user id");
		}

		userRepository.deleteById(id);

	}

	// getUserByUsername Method
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
