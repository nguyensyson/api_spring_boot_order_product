package com.example.demo.dto;

public class AccountViewDTO {

	private Integer id;
	private String userName;
	private String avatar;
	private Integer decentralization;
	
	public AccountViewDTO(Integer id, String userName, String avatar, Integer decentralization) {
		this.id = id;
		this.userName = userName;
		this.avatar = avatar;
		this.decentralization = decentralization;
	}

	public AccountViewDTO() {
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

	public Integer getDecentralization() {
		return decentralization;
	}

	public void setDecentralization(Integer decentralization) {
		this.decentralization = decentralization;
	}
	
	
}
