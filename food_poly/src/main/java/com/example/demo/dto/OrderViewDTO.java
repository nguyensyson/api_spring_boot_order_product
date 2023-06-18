package com.example.demo.dto;

import java.util.List;


public class OrderViewDTO {

	private Integer id;
	private String payment_method;
	private String nameUser;
	private double original_price;
	private double actual_price;
	private Integer orderStutus;
	private List<OrderDetailViewDTO> listOrderDetail;
	
	public OrderViewDTO(Integer id, String payment_method, String nameUser, double original_price, double actual_price,
			Integer orderStutus, List<OrderDetailViewDTO> listOrderDetail) {
		this.id = id;
		this.payment_method = payment_method;
		this.nameUser = nameUser;
		this.original_price = original_price;
		this.actual_price = actual_price;
		this.orderStutus = orderStutus;
		this.listOrderDetail = listOrderDetail;
	}

	public OrderViewDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public double getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(double original_price) {
		this.original_price = original_price;
	}

	public double getActual_price() {
		return actual_price;
	}

	public void setActual_price(double actual_price) {
		this.actual_price = actual_price;
	}

	public Integer getOrderStutus() {
		return orderStutus;
	}

	public void setOrderStutus(Integer orderStutus) {
		this.orderStutus = orderStutus;
	}

	public List<OrderDetailViewDTO> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(List<OrderDetailViewDTO> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}
	
	
}
