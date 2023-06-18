package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "decentralization")
	private Integer decentralization;
	
	@Column(name = "create_at")
	private LocalDate createAt;
	
	@Column(name = "update_at")
	private LocalDate updateAt;
	
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
	private List<User> listUser;

	public Account(Integer id, String userName, String avatar, String password, Integer status,
			Integer decentralization, LocalDate createAt, LocalDate updateAt, List<User> listUser) {
		super();
		this.id = id;
		this.userName = userName;
		this.avatar = avatar;
		this.password = password;
		this.status = status;
		this.decentralization = decentralization;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.listUser = listUser;
	}

	public Account() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDecentralization() {
		return decentralization;
	}

	public void setDecentralization(Integer decentralization) {
		this.decentralization = decentralization;
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

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
	
	

}
