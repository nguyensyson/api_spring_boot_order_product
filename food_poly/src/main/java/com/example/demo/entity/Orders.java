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
@Table(name = "orders")
public class Orders {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "payment_method")
	private String payment_method;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@Column(name = "original_price")
	private Double original_price;
	
	@Column(name = "actual_price")
	private Double actual_price;
	
	@Column(name = "order_stutus")
	private Integer orderStutus;
	
	@Column(name = "create_at")
	private LocalDate createAt;
	
	@Column(name = "update_at")
	private LocalDate updateAt;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
//	@JsonBackReference
	private List<OrderDetail> listOrderDetail;

	public Orders(Integer id, String payment_method, User user, double original_price, double actual_price,
			Integer orderStutus, LocalDate createAt, LocalDate updateAt, List<OrderDetail> listOrderDetail) {
		super();
		this.id = id;
		this.payment_method = payment_method;
		this.user = user;
		this.original_price = original_price;
		this.actual_price = actual_price;
		this.orderStutus = orderStutus;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.listOrderDetail = listOrderDetail;
	}

	public Orders() {
		super();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
