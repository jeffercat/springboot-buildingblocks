package com.stackcimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackcimplify.restservices.entities.Order;
import com.stackcimplify.restservices.entities.User;
import com.stackcimplify.restservices.exceptions.UserNotFoundException;
//import com.stackcimplify.restservices.repositories.OrderRepository;
import com.stackcimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/hateoas/users")
public class OrderHateoasController {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private OrderRepository orderRepository;

	// get All Order for a User
	@GetMapping("/{userid}/orders")
	public Resources<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {

		Optional<User> userOptional = userRepository.findById(userid);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		List<Order> allorders = userOptional.get().getOrders();
		Resources<Order> finalResources = new Resources<Order>(allorders);
		return finalResources;
	}

}
