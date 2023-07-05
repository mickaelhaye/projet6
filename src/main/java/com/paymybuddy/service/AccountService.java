package com.paymybuddy.service;

import java.util.Optional;

import com.paymybuddy.model.entity.AccountModel;

public interface AccountService {

	public Iterable<AccountModel> getAccounts();

	public AccountModel addAccount(AccountModel account);

	public Optional<AccountModel> getAccountById(Integer id);

	public void delAccount(AccountModel account);

	public void addAccountToUser(AccountModel account, String name, String firstName) throws Exception;

}
