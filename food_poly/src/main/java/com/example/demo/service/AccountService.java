package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountViewDTO;
import com.example.demo.dto.RegisterDTO;
import com.example.demo.entity.Account;

public interface AccountService {

	List<Account> getListAccount();
	Account createAccount(Account account);
	Account updateAccount(Account account, Integer id);
	AccountViewDTO logIn(String username, String password);
	AccountViewDTO register(RegisterDTO registerDTO);
	AccountViewDTO changePassword(String newPassWord);
}
