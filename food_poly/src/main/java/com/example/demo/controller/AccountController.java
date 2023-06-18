package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountViewDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.RegisterDTO;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@GetMapping("/manager/account/view")
	public ResponseEntity<List<Account>> getAllAccount() {
		try {
			List<Account> accounts = accountService.getListAccount();
			return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<List<Account>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/manager/account/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		try {
			Account account2 = accountService.createAccount(account);
			return new ResponseEntity<Account>(account2, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/manager/account/update")
	public ResponseEntity<Account> updateAccount(@RequestParam Integer id, @RequestBody Account account) {
		try {
			Account account2 = accountService.updateAccount(account, id);
			return new ResponseEntity<Account>(account2, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/log-in")
	public ResponseEntity<AccountViewDTO> logIn(@RequestBody LoginDTO login) {
		try {
			AccountViewDTO account = accountService.logIn(login.getUsername(), login.getPassword());
			return new ResponseEntity<AccountViewDTO>(account ,HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<AccountViewDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<AccountViewDTO> register(@RequestBody RegisterDTO dto) {
		try {
			AccountViewDTO account = accountService.register(dto);
			return new ResponseEntity<AccountViewDTO>(account, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<AccountViewDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/change-password")
	public ResponseEntity<AccountViewDTO> changePassWord(@RequestBody LoginDTO login) {
		try {
			AccountViewDTO account = accountService.changePassword(login.getPassword());
			return new ResponseEntity<AccountViewDTO>(account, HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<AccountViewDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
}
