package com.stackcimplify.restservices.dtos;

import java.util.List;

import com.stackcimplify.restservices.entities.Order;

public class UserMmDto {

	private Long userId;
	private String username;
	private String firstname;
	private List<Order> orders;
	
	
	
	public Long getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
	
	
	
	
}
