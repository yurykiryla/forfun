package com.example.accountservice;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private AccountRepository accountRepository;

	@Autowired
	public AccountsController(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
		logger.info("AcountRepository says system has " + accountRepository.countAccounts() 
			+ " accounts");
	}
	
	@RequestMapping("/accounts/{accountNumber}")
	public Account byNumber(@PathVariable("accountNumber") String accountNumber) {
		logger.info("accounts-service byNumber invoked: " + accountNumber);
		Account account = accountRepository.findByNumber(accountNumber);
		logger.info("accounts-service byNumber found: " + account);
		
		if (account == null) {
			throw new AccountNotFoundException(accountNumber);
		} else {
			return account;
		}
	}
	
	@RequestMapping("/accoonts/owner/{name}")
	public List<Account> byOwner(@PathVariable("name") String partialName) {
		logger.info("accounts service byOwner invoked: "
				+ accountRepository.getClass().getName() + "for" + partialName);
		
		List<Account> accounts = accountRepository.findByOwnerContainingIgnoreCase(partialName);
		
		if (accounts == null || accounts.isEmpty()) {
			throw new AccountNotFoundException(partialName);
		} else {
			return accounts;
		}
	}
}
