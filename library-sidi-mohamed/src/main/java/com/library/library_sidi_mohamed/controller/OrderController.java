package com.library.library_sidi_mohamed.controller;

import com.library.library_sidi_mohamed.domain.Order;
import com.library.library_sidi_mohamed.domainManager.OrderRepository;

import jakarta.ws.rs.Path;

//@Path("/order")
public class OrderController {
	
	public static void add(Order order) {
		OrderRepository.save(order);
	}
}
