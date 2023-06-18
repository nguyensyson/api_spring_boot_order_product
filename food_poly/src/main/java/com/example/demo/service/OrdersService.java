package com.example.demo.service;

import com.example.demo.dto.OrderViewDTO;
import com.example.demo.entity.Orders;

public interface OrdersService {

	OrderViewDTO createOrders(Orders orders);
}
