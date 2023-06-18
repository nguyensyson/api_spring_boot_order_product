package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountViewDTO;
import com.example.demo.dto.RegisterDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HttpServletRequest request;

	@Override
	public List<Account> getListAccount() {
		List<Account> list = accountRepository.findAll();
		for (Account i : list) {
			i.setPassword("");
		}
		return list;
	}

	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account updateAccount(Account account, Integer id) {
		Optional<Account> account2 = accountRepository.findById(id);
		if(account2.isEmpty()) {
			return null;
		}
		
		account2.get().setAvatar(account.getAvatar());
		account2.get().setPassword(account.getPassword());
		account2.get().setUserName(account.getUserName());
		account2.get().setStatus(account.getStatus());
		return accountRepository.save(account2.get());
	}

	@Override
	public AccountViewDTO logIn(String username, String password) {
		Account account = accountRepository.getByUserName(username);
		if(account == null) {
			return null;
		}
		
		if(account.getPassword().equalsIgnoreCase(password)) {
			request.getSession().setAttribute("accountManager", account);
			if(account.getDecentralization() == 3) {
				User user = userRepository.getByUserName(username);
				request.getSession().setAttribute("user", user);
			} 
			
			AccountViewDTO dto = new AccountViewDTO();
			dto.setAvatar(account.getAvatar());
			dto.setDecentralization(account.getDecentralization());
			dto.setId(account.getId());
			dto.setUserName(account.getUserName());
			return dto;
		}
		return null;
	}

	@Override
	public AccountViewDTO register(RegisterDTO registerDTO) {
		
		for (Account i : accountRepository.findAll()) {
			if(i.getUserName().equalsIgnoreCase(registerDTO.getUsername())) {
				return null;
			}
		}
		
		Account account = new Account();
		account.setUserName(registerDTO.getUsername());
		account.setAvatar(registerDTO.getAvatar());
		account.setPassword(registerDTO.getPassword());
		account.setStatus(1);
		account.setDecentralization(registerDTO.getDecentralization());
		account.setCreateAt(LocalDate.now());
		account.setUpdateAt(LocalDate.now());
		Account a = accountRepository.save(account);
		
		if(a.getDecentralization() == 3) {
			User user = new User();
			user.setAccount(a);
			user.setUserName(a.getUserName());
			user.setPhone(registerDTO.getPhone());
			user.setEmail(registerDTO.getEmail());
			user.setAddress(registerDTO.getAddress());
			user.setCreateAt(LocalDate.now());
			user.setUpdateAt(LocalDate.now());
			userRepository.save(user);
		}
		
		AccountViewDTO dto = new AccountViewDTO();
		dto.setAvatar(a.getAvatar());
		dto.setDecentralization(a.getDecentralization());
		dto.setId(a.getId());
		dto.setUserName(a.getUserName());
		return dto;
	}

	@Override
	public AccountViewDTO changePassword(String newPassWord) {
		Account account = (Account) request.getSession().getAttribute("accountManager");
		if(account == null) {
			return null;
		}
		
		Optional<Account> a = accountRepository.findById(account.getId());
		a.get().setPassword(newPassWord);
		Account taiKhoan = accountRepository.save(a.get());
		
		AccountViewDTO dto = new AccountViewDTO(taiKhoan.getId(), taiKhoan.getUserName(), taiKhoan.getAvatar(), taiKhoan.getDecentralization());
		return dto;
	}

}
