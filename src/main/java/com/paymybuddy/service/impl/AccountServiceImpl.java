package com.paymybuddy.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.model.entity.AccountModel;
import com.paymybuddy.model.entity.UserModel;
import com.paymybuddy.repository.AccountRepository;
import com.paymybuddy.service.AccountService;
import com.paymybuddy.service.UserService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserService userService;

	@Override
	public Iterable<AccountModel> getAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Optional<AccountModel> getAccountById(Integer id) {
		return accountRepository.findById(id);
	}

	@Override
	public AccountModel addAccount(AccountModel account) {
		return accountRepository.save(account);
	}

	@Override
	public void delAccount(AccountModel account) {
		accountRepository.delete(account);

	}

	@Override
	public void addAccountToUser(AccountModel account, String name, String firstName) {
		UserModel user = userService.getUserByNameAndFirstname(name, firstName);
		user.setAccountToList(account);
		userService.addUser(user);

	}

}
