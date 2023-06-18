package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDetailViewDTO;
import com.example.demo.dto.OrderViewDTO;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Products;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	OrderDetailRepository detailRepository;
	
	@Autowired
	ProductsRepository productsRepository;

	@Override
	public OrderViewDTO createOrders(Orders orders) {
		Orders orders2 = ordersRepository.save(orders);
		List<OrderDetail> details = orders.getListOrderDetail();
		
		for (OrderDetail i : details) {
			i.setOrders(orders2);
			Optional<Products> products = productsRepository.findById(i.getProducts().getId());
			i.setPriceTotal(i.getQuantity() * products.get().getPrice() * (products.get().getDiscount() == 0 ? 100 : products.get().getDiscount()) / 100);
			i.setCreateAt(LocalDate.now());
			i.setUpdateAt(LocalDate.now());
		}
		detailRepository.saveAll(details);
		
		double totalOriginalPrice = 0;
		double totalActualPrice = 0;
		for (OrderDetail i : details) {
			totalActualPrice += i.getPriceTotal();
			Optional<Products> products = productsRepository.findById(i.getProducts().getId());
			totalOriginalPrice += (i.getQuantity() * products.get().getPrice());
		}
		
		orders2.setActual_price(totalActualPrice);
		orders2.setOriginal_price(totalOriginalPrice);
		orders2.setCreateAt(LocalDate.now());
		orders2.setUpdateAt(LocalDate.now());
		
		Orders o = ordersRepository.save(orders2);
		
		OrderViewDTO dto = new OrderViewDTO();
		dto.setId(o.getId());
		dto.setActual_price(o.getActual_price());
		dto.setNameUser(o.getUser().getUserName());
		dto.setOrderStutus(o.getOrderStutus());
		dto.setOriginal_price(o.getOriginal_price());
		dto.setPayment_method(o.getPayment_method());
		dto.setListOrderDetail(detailRepository.getByOrder(o.getId()));
		
		return dto;
	}

}
