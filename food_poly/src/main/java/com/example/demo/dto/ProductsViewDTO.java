package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductsViewDTO {

	@Id
	private Integer id;
	private String productType;
	private String name;
	private Double price;
	private String avartarImageProduct;
	private String title;
	private Integer discount;
	
	public ProductsViewDTO(Integer id, String productType, String name, Double price, String avartarImageProduct,
			String title, Integer discount) {
		this.id = id;
		this.productType = productType;
		this.name = name;
		this.price = price;
		this.avartarImageProduct = avartarImageProduct;
		this.title = title;
		this.discount = discount;
	}

	public ProductsViewDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	
}
