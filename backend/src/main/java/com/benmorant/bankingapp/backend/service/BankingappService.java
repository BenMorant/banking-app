package com.benmorant.bankingapp.backend.service;


import com.benmorant.bankingapp.backend.entity.Account;
import java.util.List;

public interface BankingappService {

  Account getAccountById(Long idAccount);

  List<Account> getAccountsByCustomerIdentifier(String customerIdentifier);

  void addToAccount(Long idAccount, double amount);

  void removeFromAccount(Long idAccount, double amount);

  void transferAmount(Long idOriginAccount, Long idDestinationAccount, double amount);
}
