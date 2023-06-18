package com.example.demo.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderViewDTO;
import com.example.demo.entity.Orders;
import com.example.demo.service.OrdersService;

@RestController
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@PostMapping( value = "/order/create" )
	public ResponseEntity<OrderViewDTO> createOrders(@RequestBody Orders orders) {
		try {
			OrderViewDTO orders2 = ordersService.createOrders(orders);
			return new ResponseEntity<OrderViewDTO>(orders2, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<OrderViewDTO>(HttpStatus.NOT_FOUND);
		}
	}
}
