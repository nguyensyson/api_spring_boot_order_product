package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderDetailViewDTO {

	@Id
	private Integer id;
	private String name;
	private Double price;
	private String avartarImageProduct;
	private Integer discount;
	private Double priceTotal;
	private Integer quantity;
	
	public OrderDetailViewDTO(Integer id, String name, Double price, String avartarImageProduct, Integer discount,
			Double priceTotal, Integer quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.avartarImageProduct = avartarImageProduct;
		this.discount = discount;
		this.priceTotal = priceTotal;
		this.quantity = quantity;
	}

	public OrderDetailViewDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAvartarImageProduct() {
		return avartarImageProduct;
	}

	public void setAvartarImageProduct(String avartarImageProduct) {
		this.avartarImageProduct = avartarImageProduct;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
