package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_type")
public class ProductType {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name_product_type")
	private String name;
	
	@Column(name = "image_type_product")
	private String image;
	
	@Column(name = "create_at")
	private LocalDate createAt;
	
	@Column(name = "update_at")
	private LocalDate updateAt;
	
	@OneToMany(mappedBy = "productType", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Products> listProduct;

	public ProductType(Integer id, String name, String image, LocalDate createAt, LocalDate updateAt,
			List<Products> listProduct) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.listProduct = listProduct;
	}

	public ProductType() {
		super();
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public LocalDate getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDate updateAt) {
		this.updateAt = updateAt;
	}

	public List<Products> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Products> listProduct) {
		this.listProduct = listProduct;
	}
	
	
}
