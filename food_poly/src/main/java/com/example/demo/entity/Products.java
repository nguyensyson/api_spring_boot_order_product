package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_type_id", referencedColumnName = "id")
	private ProductType productType;
	
	@Column(name = "name_product")
	private String nameProduct;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "avartar_image_product")
	private String avartarImageProduct;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "discount")
	private Integer discount;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "create_at")
	private LocalDate createAt;
	
	@Column(name = "update_at")
	private LocalDate updateAt;
	
	@OneToMany(mappedBy = "products", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrderDetail> listOrderDetail;

	public Products(Integer id, ProductType productType, String nameProduct, double price, String avartarImageProduct,
			String title, Integer discount, Integer status, LocalDate createAt, LocalDate updateAt,
			List<OrderDetail> listOrderDetail) {
		this.id = id;
		this.productType = productType;
		this.nameProduct = nameProduct;
		this.price = price;
		this.avartarImageProduct = avartarImageProduct;
		this.title = title;
		this.discount = discount;
		this.status = status;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.listOrderDetail = listOrderDetail;
	}

	public Products() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public List<OrderDetail> getListOrderDetail() {
		return listOrderDetail;
	}

	public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}
	
	
}
