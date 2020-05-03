package com.stackcimplify.restservices.repositories;

import org.springframework.stereotype.Repository;

import com.stackcimplify.restservices.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
