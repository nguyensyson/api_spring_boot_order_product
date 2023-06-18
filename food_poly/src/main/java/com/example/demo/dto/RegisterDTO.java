package com.example.demo.dto;

public class RegisterDTO {

	private String username;
	private String password;
	private String avatar;
	private String phone;
	private String email;
	private String address;
	private Integer decentralization;
	
	public RegisterDTO(String username, String password, String avatar, String phone, String email, String address,
			Integer decentralization) {
		this.username = username;
		this.password = password;
		this.avatar = avatar;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.decentralization = decentralization;
	}

	public RegisterDTO() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getDecentralization() {
		return decentralization;
	}

	public void setDecentralization(Integer decentralization) {
		this.decentralization = decentralization;
	}
	
}
